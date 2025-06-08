package br.com.fiap.dao;

import br.com.fiap.beans.Medal;
import br.com.fiap.beans.Scenario;
import br.com.fiap.dto.UserMedal;
import br.com.fiap.exceptions.ConnectionException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedalDAO extends BaseDAO {

    public MedalDAO() throws ConnectionException {
        super();
    }

    public List<Medal> findAll() throws SQLException {
        String sql = """
        SELECT
            m.medal_id,
            m.name,
            m.tier,
            m.score_requirement,
            m.icon_url,
            s.scenario_id,
            s.title,
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
                pdc_medal m
            LEFT JOIN pdc_scenario s ON (m.scenario_id = s.scenario_id)
        ORDER BY
            s.scenario_id,
            m.score_requirement
        """;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            try (ResultSet rs = stmt.executeQuery()) {
                List<Medal> medals = new ArrayList<Medal>();

                while (rs.next()) {
                    Scenario scenario = new Scenario();
                    scenario.setId(rs.getInt("scenario_id"));
                    scenario.setTitle(rs.getString("title"));
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

                    Medal medal = new Medal();
                    medal.setId(rs.getInt("medal_id"));
                    medal.setName(rs.getString("name"));
                    medal.setScenario(scenario);
                    medal.setTier(rs.getString("tier"));
                    medal.setScoreRequirement(rs.getInt("score_requirement"));
                    medal.setIconUrl(rs.getString("icon_url"));

                    medals.add(medal);
                }

                return medals;
            }

        }
    }

    public Medal findById(int id) throws SQLException {
        String sql = """
        SELECT
            m.medal_id,
            m.name,
            m.tier,
            m.score_requirement,
            m.icon_url,
            s.scenario_id,
            s.title,
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
                pdc_medal m
            LEFT JOIN pdc_scenario s ON (m.scenario_id = s.scenario_id)
        WHERE
            m.scenario_id = ?
        ORDER BY
            s.scenario_id,
            m.score_requirement
        """;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Scenario scenario = new Scenario();
                    scenario.setId(rs.getInt("scenario_id"));
                    scenario.setTitle(rs.getString("title"));
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

                    Medal medal = new Medal();
                    medal.setId(rs.getInt("medal_id"));
                    medal.setName(rs.getString("name"));
                    medal.setScenario(scenario);
                    medal.setTier(rs.getString("tier"));
                    medal.setScoreRequirement(rs.getInt("score_requirement"));
                    medal.setIconUrl(rs.getString("icon_url"));

                    return medal;
                }

                return null;
            }
        }
    }

    public List<UserMedal> findByUserId(int userId) throws SQLException {
        String sql = """
        SELECT
            m.medal_id,
            m.name,
            m.tier,
            m.score_requirement,
            m.icon_url,
            s.scenario_id,
            s.title,
            s.description,
            s.story,
            s.cover_url,
            s.preparation_bg_url,
            s.action_bg_url,
            s.initial_budget,
            s.initial_fire_units,
            s.initial_military_support,
            s.initial_logistics,
            s.difficulty,
            um.earned_at
        FROM
                pdc_medal m
            LEFT JOIN pdc_scenario s ON (m.scenario_id = s.scenario_id)
            LEFT JOIN pdc_user_medal um ON (m.medal_id = um.medal_id)
        WHERE
            um.user_id = ?
        ORDER BY
            s.scenario_id,
            m.score_requirement
        """;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                List<UserMedal> medals = new ArrayList<UserMedal>();

                while (rs.next()) {
                    Scenario scenario = new Scenario();
                    scenario.setId(rs.getInt("scenario_id"));
                    scenario.setTitle(rs.getString("title"));
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

                    UserMedal medal = new UserMedal();
                    medal.setId(rs.getInt("medal_id"));
                    medal.setName(rs.getString("name"));
                    medal.setScenario(scenario);
                    medal.setTier(rs.getString("tier"));
                    medal.setScoreRequirement(rs.getInt("score_requirement"));
                    medal.setIconUrl(rs.getString("icon_url"));
                    medal.setEarnedAt(rs.getTimestamp("earned_at").toLocalDateTime());

                    medals.add(medal);
                }

                return medals;
            }

        }
    }

}
