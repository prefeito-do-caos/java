package br.com.fiap.bo;

import br.com.fiap.beans.Scenario;
import br.com.fiap.dao.ScenarioDAO;
import br.com.fiap.exceptions.ConnectionException;

import java.sql.SQLException;
import java.util.ArrayList;

public class ScenarioBO {

    public ArrayList<Scenario> getAll() throws ConnectionException, SQLException {
        try (ScenarioDAO scenarioDAO = new ScenarioDAO()) {
            return (ArrayList<Scenario>) scenarioDAO.findAll();
        }
    }

    public Scenario getById(int id) throws ConnectionException, SQLException {
        try (ScenarioDAO scenarioDAO = new ScenarioDAO()) {
            return scenarioDAO.findById(id);
        }
    }

}
