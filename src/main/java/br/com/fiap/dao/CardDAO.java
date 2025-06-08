package br.com.fiap.dao;

import br.com.fiap.dto.CardDTO;
import br.com.fiap.exceptions.ConnectionException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardDAO extends BaseDAO {

    public CardDAO() throws ConnectionException {
        super();
    }

    public List<CardDTO> findPreparationCardsByScenarioId(int scenarioId) throws SQLException {
        String sql = """
        SELECT
            card_id,
            scenario_id,
            phase,
            title,
            description,
            sequence_order,
            cover_url,
            accept_label,
            reject_label
        FROM
                pdc_card c
        WHERE
            phase = 'preparation' AND
            scenario_id = ?
        ORDER BY
            sequence_order
        """;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, scenarioId);

            try (ResultSet rs = stmt.executeQuery()) {
                List<CardDTO> cards = new ArrayList<CardDTO>();

                while (rs.next()) {
                    CardDTO card = new CardDTO();
                    card.setId(rs.getInt("card_id"));
                    card.setScenarioId(rs.getInt("scenario_id"));
                    card.setPhase(rs.getString("phase"));
                    card.setTitle(rs.getString("title"));
                    card.setDescription(rs.getString("description"));
                    card.setSequenceOrder(rs.getInt("sequence_order"));
                    card.setCoverUrl(rs.getString("cover_url"));
                    card.setAcceptLabel(rs.getString("accept_label"));
                    card.setRejectLabel(rs.getString("reject_label"));

                    cards.add(card);
                }

                return cards;
            }

        }
    }

}
