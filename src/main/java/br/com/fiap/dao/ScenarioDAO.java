package br.com.fiap.dao;

import br.com.fiap.beans.Scenario;
import br.com.fiap.exceptions.ConnectionException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScenarioDAO extends BaseDAO {

    public ScenarioDAO() throws ConnectionException {
        super();
    }

    public List<Scenario> findAll() throws SQLException {
        String sql = """
        SELECT
            scenario_id,
            title,
            description,
            story,
            cover_url,
            preparation_bg_url,
            action_bg_url,
            initial_budget,
            initial_fire_units,
            initial_military_support,
            initial_logistics,
            difficulty
        FROM
            pdc_scenario
        ORDER BY
            scenario_id
        """;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            try (ResultSet rs = stmt.executeQuery()) {
                List<Scenario> scenarios = new ArrayList<Scenario>();

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

                    scenarios.add(scenario);
                }

                return scenarios;
            }

        }
    }

    public Scenario findById(int id) throws SQLException {
        String sql = """
        SELECT
            scenario_id,
            title,
            description,
            story,
            cover_url,
            preparation_bg_url,
            action_bg_url,
            initial_budget,
            initial_fire_units,
            initial_military_support,
            initial_logistics,
            difficulty
        FROM
            pdc_scenario
        WHERE
            scenario_id = ?
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

                    return scenario;
                }

                return null;
            }
        }
    }

}
