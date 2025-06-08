package br.com.fiap.bo;

import br.com.fiap.beans.GameSession;
import br.com.fiap.beans.Scenario;
import br.com.fiap.dao.GameSessionDAO;
import br.com.fiap.dao.SessionCardDAO;
import br.com.fiap.dto.CardDTO;
import br.com.fiap.dto.CreateSessionCard;
import br.com.fiap.dto.PublicUser;
import br.com.fiap.exceptions.ConnectionException;
import br.com.fiap.exceptions.InsertException;
import br.com.fiap.exceptions.ScenarioNotFoundException;

import java.sql.SQLException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class GameSessionBO {

    public GameSession insert(int userId, int scenarioId) throws
            SQLException, ConnectionException, ScenarioNotFoundException, InsertException {

        PublicUser user = new UserBO().getById(userId);

        Scenario scenario = new ScenarioBO().getById(scenarioId);
        if (scenario == null) throw new ScenarioNotFoundException();

        GameSession gameSession = new GameSession();
        gameSession.setUser(user);
        gameSession.setScenario(scenario);
        gameSession.setBudget(scenario.getInitialBudget());
        gameSession.setFireUnits(scenario.getInitialFireUnits());
        gameSession.setMilitarySupport(scenario.getInitialMilitarySupport());
        gameSession.setLogistics(scenario.getInitialLogistics());
        gameSession.setIsEnded(0);
        gameSession.setExpireAt(
                ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).plusDays(15).toLocalDateTime()
        );

        try (GameSessionDAO gameSessionDAO = new GameSessionDAO()) {
            int id = gameSessionDAO.insert(gameSession);
            GameSession createdGameSession = gameSessionDAO.findById(id);

            ArrayList<CardDTO> preparationCards = new CardBO().getPreparationCardsByScenarioId(scenario.getId());

            try (SessionCardDAO sessionCardDAO = new SessionCardDAO()) {

                for (CardDTO preparationCard : preparationCards) {
                    CreateSessionCard sessionCard = new CreateSessionCard();
                    sessionCard.setGameSessionId(createdGameSession.getId());
                    sessionCard.setCardId(preparationCard.getId());
                    sessionCard.setSequenceOrder(preparationCard.getSequenceOrder());

                    sessionCardDAO.insert(sessionCard);
                }

            }

            return createdGameSession;
        }
    }

    public ArrayList<GameSession> getByUserId(int userId) throws ConnectionException, SQLException {
        try (GameSessionDAO gameSessionDAO = new GameSessionDAO()) {
            return (ArrayList<GameSession>) gameSessionDAO.findByUserId(userId);
        }
    }

    public GameSession getByCode(String code) throws ConnectionException, SQLException {
        try (GameSessionDAO gameSessionDAO = new GameSessionDAO()) {
            return gameSessionDAO.findByCode(code);
        }
    }

}
