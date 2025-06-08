package br.com.fiap.bo;

import br.com.fiap.dao.CardDAO;
import br.com.fiap.dto.CardDTO;
import br.com.fiap.exceptions.ConnectionException;

import java.sql.SQLException;
import java.util.ArrayList;

public class CardBO {

    public ArrayList<CardDTO> getPreparationCardsByScenarioId(int scenarioId) throws
            ConnectionException, SQLException {

        try (CardDAO cardDAO = new CardDAO()) {
            return (ArrayList<CardDTO>) cardDAO.findPreparationCardsByScenarioId(scenarioId);
        }
    }

}
