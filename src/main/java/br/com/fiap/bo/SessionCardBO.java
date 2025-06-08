package br.com.fiap.bo;

import br.com.fiap.dao.SessionCardDAO;
import br.com.fiap.dto.NextCard;
import br.com.fiap.exceptions.ConnectionException;

import java.sql.SQLException;

public class SessionCardBO {

    public NextCard getNextCardFromGameSessionsByCode(String code) throws ConnectionException, SQLException {
        try (SessionCardDAO sessionCardDAO = new SessionCardDAO()) {
            return sessionCardDAO.findNextCardFromGameSessionsByCode(code);
        }
    }

}
