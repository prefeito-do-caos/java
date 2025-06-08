package br.com.fiap.dao;

import br.com.fiap.beans.GameSession;
import br.com.fiap.beans.Scenario;
import br.com.fiap.dto.PublicUser;
import br.com.fiap.exceptions.ConnectionException;
import br.com.fiap.exceptions.InsertException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class GameSessionDAO extends  BaseDAO {

    public GameSessionDAO() throws ConnectionException {
        super();
    }

    public int insert(GameSession gameSession) throws InsertException {
        String sql = "INSERT INTO pdc_game_session (code, user_id, scenario_id, budget, fire_units, military_support, logistics, is_ended, expire_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql, new String[] { "game_session_id" })) {
            stmt.setString(1, gameSession.getCode());
            stmt.setInt(2, gameSession.getUser().getId());
            stmt.setInt(3, gameSession.getScenario().getId());
            stmt.setInt(4, gameSession.getBudget());
            stmt.setInt(5, gameSession.getFireUnits());
            stmt.setInt(6, gameSession.getMilitarySupport());
            stmt.setInt(7, gameSession.getLogistics());
            stmt.setInt(8, gameSession.getIsEnded());
            stmt.setTimestamp(9, Timestamp.valueOf(gameSession.getExpireAt()));

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new InsertException("Failed to insert game session");
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
            throw new InsertException("SQL error while inserting game session: " + e.getMessage(), e);
        }
    }

    public GameSession findById(int id) throws SQLException {
        String sql = """
        SELECT
            gs.game_session_id,
            gs.code,
            gs.turn,
            gs.budget,
            gs.fire_units,
            gs.military_support,
            gs.logistics,
            gs.saved_lives,
            gs.crisis_control,
            gs.public_confidence,
            gs.structural_integrity,
            gs.is_ended,
            gs.created_at,
            gs.expire_at,
            u.user_id,
            u.name AS user_name,
            u.created_at user_created_at,
            s.scenario_id,
            s.title AS scenario_title,
            s.description,
            s.story,
            s.cover_url,
            s.preparation_bg_url,
            s.action_bg_url,
            s.initial_budget,
            s.initial_fire_units,
            s.initial_military_support,
            s.initial_logistics,
            s.difficulty
        FROM
                pdc_game_session gs
            LEFT JOIN pdc_user u ON (gs.user_id = u.user_id)
            LEFT JOIN pdc_scenario s ON (gs.scenario_id = s.scenario_id)
        WHERE
            gs.game_session_id = ?
        """;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    PublicUser user = new PublicUser();
                    user.setId(rs.getInt("user_id"));
                    user.setName(rs.getString("user_name"));
                    user.setCreatedAt(rs.getTimestamp("user_created_at").toLocalDateTime());

                    Scenario scenario = new Scenario();
                    scenario.setId(rs.getInt("scenario_id"));
                    scenario.setTitle(rs.getString("scenario_title"));
                    scenario.setDescription(rs.getString("description"));
                    scenario.setStory(rs.getString("story"));
                    scenario.setCoverUrl(rs.getString("cover_url"));
                    scenario.setPreparationBgUrl(rs.getString("preparation_bg_url"));
                    scenario.setActionBgUrl(rs.getString("action_bg_url"));
                    scenario.setInitialBudget(rs.getInt("initial_budget"));
                    scenario.setInitialFireUnits(rs.getInt("initial_fire_units"));
                    scenario.setInitialMilitarySupport(rs.getInt("initial_military_support"));
                    scenario.setInitialLogistics(rs.getInt("initial_logistics"));
                    scenario.setDifficulty(rs.getString("difficulty"));

                    GameSession gameSession = new GameSession();
                    gameSession.setId(rs.getInt("game_session_id"));
                    gameSession.setCode(rs.getString("code"));
                    gameSession.setUser(user);
                    gameSession.setScenario(scenario);
                    gameSession.setTurn(rs.getInt("turn"));
                    gameSession.setBudget(rs.getInt("budget"));
                    gameSession.setFireUnits(rs.getInt("fire_units"));
                    gameSession.setMilitarySupport(rs.getInt("military_support"));
                    gameSession.setLogistics(rs.getInt("logistics"));
                    gameSession.setSavedLives(rs.getInt("saved_lives"));
                    gameSession.setCrisisControl(rs.getInt("crisis_control"));
                    gameSession.setPublicConfidence(rs.getInt("public_confidence"));
                    gameSession.setStructuralIntegrity(rs.getInt("structural_integrity"));
                    gameSession.setIsEnded(rs.getInt("is_ended"));
                    gameSession.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());

                    return gameSession;
                }

                return null;
            }
        }
    }

    public GameSession findByCode(String code) throws SQLException {
        String sql = """
        SELECT
            gs.game_session_id,
            gs.code,
            gs.turn,
            gs.budget,
            gs.fire_units,
            gs.military_support,
            gs.logistics,
            gs.saved_lives,
            gs.crisis_control,
            gs.public_confidence,
            gs.structural_integrity,
            gs.is_ended,
            gs.created_at,
            gs.expire_at,
            u.user_id,
            u.name AS user_name,
            u.created_at user_created_at,
            s.scenario_id,
            s.title AS scenario_title,
            s.description,
            s.story,
            s.cover_url,
            s.preparation_bg_url,
            s.action_bg_url,
            s.initial_budget,
            s.initial_fire_units,
            s.initial_military_support,
            s.initial_logistics,
            s.difficulty
        FROM
                pdc_game_session gs
            LEFT JOIN pdc_user u ON (gs.user_id = u.user_id)
            LEFT JOIN pdc_scenario s ON (gs.scenario_id = s.scenario_id)
        WHERE
            gs.code = ?
        """;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, code);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    PublicUser user = new PublicUser();
                    user.setId(rs.getInt("user_id"));
                    user.setName(rs.getString("user_name"));
                    user.setCreatedAt(rs.getTimestamp("user_created_at").toLocalDateTime());

                    Scenario scenario = new Scenario();
                    scenario.setId(rs.getInt("scenario_id"));
                    scenario.setTitle(rs.getString("scenario_title"));
                    scenario.setDescription(rs.getString("description"));
                    scenario.setStory(rs.getString("story"));
                    scenario.setCoverUrl(rs.getString("cover_url"));
                    scenario.setPreparationBgUrl(rs.getString("preparation_bg_url"));
                    scenario.setActionBgUrl(rs.getString("action_bg_url"));
                    scenario.setInitialBudget(rs.getInt("initial_budget"));
                    scenario.setInitialFireUnits(rs.getInt("initial_fire_units"));
                    scenario.setInitialMilitarySupport(rs.getInt("initial_military_support"));
                    scenario.setInitialLogistics(rs.getInt("initial_logistics"));
                    scenario.setDifficulty(rs.getString("difficulty"));

                    GameSession gameSession = new GameSession();
                    gameSession.setId(rs.getInt("game_session_id"));
                    gameSession.setCode(rs.getString("code"));
                    gameSession.setUser(user);
                    gameSession.setScenario(scenario);
                    gameSession.setTurn(rs.getInt("turn"));
                    gameSession.setBudget(rs.getInt("budget"));
                    gameSession.setFireUnits(rs.getInt("fire_units"));
                    gameSession.setMilitarySupport(rs.getInt("military_support"));
                    gameSession.setLogistics(rs.getInt("logistics"));
                    gameSession.setSavedLives(rs.getInt("saved_lives"));
                    gameSession.setCrisisControl(rs.getInt("crisis_control"));
                    gameSession.setPublicConfidence(rs.getInt("public_confidence"));
                    gameSession.setStructuralIntegrity(rs.getInt("structural_integrity"));
                    gameSession.setIsEnded(rs.getInt("is_ended"));
                    gameSession.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());

                    return gameSession;
                }

                return null;
            }
        }
    }

    public List<GameSession> findByUserId(int userId) throws SQLException {
        String sql = """
        SELECT
            gs.game_session_id,
            gs.code,
            gs.turn,
            gs.budget,
            gs.fire_units,
            gs.military_support,
            gs.logistics,
            gs.saved_lives,
            gs.crisis_control,
            gs.public_confidence,
            gs.structural_integrity,
            gs.is_ended,
            gs.created_at,
            gs.expire_at,
            u.user_id,
            u.name AS user_name,
            u.created_at user_created_at,
            s.scenario_id,
            s.title AS scenario_title,
            s.description,
            s.story,
            s.cover_url,
            s.preparation_bg_url,
            s.action_bg_url,
            s.initial_budget,
            s.initial_fire_units,
            s.initial_military_support,
            s.initial_logistics,
            s.difficulty
        FROM
                pdc_game_session gs
            LEFT JOIN pdc_user u ON (gs.user_id = u.user_id)
            LEFT JOIN pdc_scenario s ON (gs.scenario_id = s.scenario_id)
        WHERE
            u.user_id = ?
        ORDER BY
            gs.created_at
        """;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                List<GameSession> gameSessions = new ArrayList<GameSession>();

                while (rs.next()) {
                    PublicUser user = new PublicUser();
                    user.setId(rs.getInt("user_id"));
                    user.setName(rs.getString("user_name"));
                    user.setCreatedAt(rs.getTimestamp("user_created_at").toLocalDateTime());

                    Scenario scenario = new Scenario();
                    scenario.setId(rs.getInt("scenario_id"));
                    scenario.setTitle(rs.getString("scenario_title"));
                    scenario.setDescription(rs.getString("description"));
                    scenario.setStory(rs.getString("story"));
                    scenario.setCoverUrl(rs.getString("cover_url"));
                    scenario.setPreparationBgUrl(rs.getString("preparation_bg_url"));
                    scenario.setActionBgUrl(rs.getString("action_bg_url"));
                    scenario.setInitialBudget(rs.getInt("initial_budget"));
                    scenario.setInitialFireUnits(rs.getInt("initial_fire_units"));
                    scenario.setInitialMilitarySupport(rs.getInt("initial_military_support"));
                    scenario.setInitialLogistics(rs.getInt("initial_logistics"));
                    scenario.setDifficulty(rs.getString("difficulty"));

                    GameSession gameSession = new GameSession();
                    gameSession.setId(rs.getInt("game_session_id"));
                    gameSession.setCode(rs.getString("code"));
                    gameSession.setUser(user);
                    gameSession.setScenario(scenario);
                    gameSession.setTurn(rs.getInt("turn"));
                    gameSession.setBudget(rs.getInt("budget"));
                    gameSession.setFireUnits(rs.getInt("fire_units"));
                    gameSession.setMilitarySupport(rs.getInt("military_support"));
                    gameSession.setLogistics(rs.getInt("logistics"));
                    gameSession.setSavedLives(rs.getInt("saved_lives"));
                    gameSession.setCrisisControl(rs.getInt("crisis_control"));
                    gameSession.setPublicConfidence(rs.getInt("public_confidence"));
                    gameSession.setStructuralIntegrity(rs.getInt("structural_integrity"));
                    gameSession.setIsEnded(rs.getInt("is_ended"));
                    gameSession.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());

                    gameSessions.add(gameSession);
                }

                return gameSessions;
            }
        }
    }

}
