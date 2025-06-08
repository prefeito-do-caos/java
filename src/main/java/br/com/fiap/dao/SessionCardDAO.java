package br.com.fiap.dao;

import br.com.fiap.beans.Scenario;
import br.com.fiap.dto.CardDecisionEffectDTO;
import br.com.fiap.dto.CreateSessionCard;
import br.com.fiap.dto.NextCard;
import br.com.fiap.exceptions.ConnectionException;
import br.com.fiap.exceptions.InsertException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SessionCardDAO extends BaseDAO {

    public SessionCardDAO() throws ConnectionException {
        super();
    }

    public int insert(CreateSessionCard sessionCard) throws InsertException {
        String sql = "INSERT INTO pdc_session_card (game_session_id, card_id, sequence_order) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql, new String[] { "session_card_id" })) {
            stmt.setInt(1, sessionCard.getGameSessionId());
            stmt.setInt(2, sessionCard.getCardId());
            stmt.setInt(3, sessionCard.getSequenceOrder());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new InsertException("Failed to insert session card");
            }

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                } else {
                    throw new InsertException("Failed to retrieve generated ID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new InsertException("SQL error while inserting user: " + e.getMessage(), e);
        }
    }

    public NextCard findNextCardFromGameSessionsByCode(String code) throws SQLException {
        String sql = """
        SELECT
            sc.sequence_order,
            c.phase,
            c.title,
            c.description,
            c.cover_url,
            c.accept_label,
            c.reject_label,
            cde_accept.effect_budget accept_effect_budget,
            cde_accept.effect_fire_units accept_effect_fire_units,
            cde_accept.effect_military_support accept_effect_military_support,
            cde_accept.effect_logistics accept_effect_logistics,
            cde_accept.effect_saved_lives accept_effect_saved_lives,
            cde_accept.effect_crisis_control accept_effect_crisis_control,
            cde_accept.effect_public_confidence accept_effect_public_confidence,
            cde_accept.effect_structural_integrity accept_effect_structural_integrity,
            cde_reject.effect_budget reject_effect_budget,
            cde_reject.effect_fire_units reject_effect_fire_units,
            cde_reject.effect_military_support reject_effect_military_support,
            cde_reject.effect_logistics reject_effect_logistics,
            cde_reject.effect_saved_lives reject_effect_saved_lives,
            cde_reject.effect_crisis_control reject_effect_crisis_control,
            cde_reject.effect_public_confidence reject_effect_public_confidence,
            cde_reject.effect_structural_integrity reject_effect_structural_integrity
        FROM
                pdc_session_card sc
            LEFT JOIN pdc_game_session s ON (sc.game_session_id = s.game_session_id)
            LEFT JOIN pdc_card c ON (sc.card_id = c.card_id)
            LEFT JOIN pdc_card_decision_effect cde_accept ON (sc.card_id = cde_accept.card_id AND cde_accept.decision_type = 'accept')
            LEFT JOIN pdc_card_decision_effect cde_reject ON (sc.card_id = cde_reject.card_id AND cde_reject.decision_type = 'reject')
        WHERE
            s.code = ?
            AND sc.was_played = 0
            AND sc.sequence_order IS NOT NULL
        ORDER BY
            sc.sequence_order
        FETCH FIRST 1 ROWS ONLY
        """;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, code);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    CardDecisionEffectDTO acceptEffect = new CardDecisionEffectDTO();
                    acceptEffect.setEffectBudget(rs.getInt("accept_effect_budget"));
                    acceptEffect.setEffectFireUnits(rs.getInt("accept_effect_fire_units"));
                    acceptEffect.setEffectMilitarySupport(rs.getInt("accept_effect_military_support"));
                    acceptEffect.setEffectLogistics(rs.getInt("accept_effect_logistics"));

                    CardDecisionEffectDTO rejectEffect = new CardDecisionEffectDTO();
                    rejectEffect.setEffectBudget(rs.getInt("reject_effect_budget"));
                    rejectEffect.setEffectFireUnits(rs.getInt("reject_effect_fire_units"));
                    rejectEffect.setEffectMilitarySupport(rs.getInt("reject_effect_military_support"));
                    rejectEffect.setEffectLogistics(rs.getInt("reject_effect_logistics"));

                    NextCard nextCard = new NextCard();
                    nextCard.setSequenceOrder(rs.getInt("sequence_order"));
                    nextCard.setPhase(rs.getString("phase"));
                    nextCard.setTitle(rs.getString("title"));
                    nextCard.setDescription(rs.getString("description"));
                    nextCard.setCoverUrl(rs.getString("cover_url"));
                    nextCard.setAcceptLabel(rs.getString("accept_label"));
                    nextCard.setRejectLabel(rs.getString("reject_label"));
                    nextCard.setAcceptEffect(acceptEffect);
                    nextCard.setRejectEffect(rejectEffect);

                    return nextCard;
                }

                return null;
            }
        }

    }

}
