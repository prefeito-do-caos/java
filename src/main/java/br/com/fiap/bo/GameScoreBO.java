package br.com.fiap.bo;

import br.com.fiap.dao.GameScoreDAO;
import br.com.fiap.dto.LeaderboardGameScore;
import br.com.fiap.exceptions.ConnectionException;

import java.sql.SQLException;
import java.util.ArrayList;

public class GameScoreBO {

    public ArrayList<LeaderboardGameScore> getLeaderBoardByScenarioId(int scenarioId) throws ConnectionException, SQLException {
        try (GameScoreDAO gameScoreDAO = new GameScoreDAO()) {
            return (ArrayList<LeaderboardGameScore>) gameScoreDAO.findLeaderboardByScenarioId(scenarioId);
        }
    }

}
