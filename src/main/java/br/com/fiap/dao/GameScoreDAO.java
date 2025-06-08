package br.com.fiap.dao;

import br.com.fiap.dto.LeaderboardGameScore;
import br.com.fiap.dto.PublicUser;
import br.com.fiap.exceptions.ConnectionException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameScoreDAO extends BaseDAO {

    public GameScoreDAO() throws ConnectionException {
        super();
    }

    public List<LeaderboardGameScore> findLeaderboardByScenarioId(int scenarioId) throws SQLException {
        String sql = """
        SELECT
            MAX(gs.score) AS max_score,
            u.user_id,
            u.name,
            u.created_at AS user_created_at,
            s.scenario_id
        FROM
            pdc_game_score gs
        LEFT JOIN pdc_user u ON gs.user_id = u.user_id
        LEFT JOIN pdc_scenario s ON gs.scenario_id = s.scenario_id
        WHERE
            gs.scenario_id = ?
        GROUP BY
            u.user_id,
            u.name,
            u.created_at,
            s.scenario_id
        ORDER BY
            max_score DESC
        """;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, scenarioId);

            try (ResultSet rs = stmt.executeQuery()) {
                List<LeaderboardGameScore> leaderboardGameScores = new ArrayList<LeaderboardGameScore>();

                while (rs.next()) {
                    PublicUser user = new PublicUser();
                    user.setId(rs.getInt("user_id"));
                    user.setName(rs.getString("name"));
                    user.setCreatedAt(rs.getTimestamp("user_created_at").toLocalDateTime());

                    LeaderboardGameScore leaderBoardGameScore = new LeaderboardGameScore();
                    leaderBoardGameScore.setUser(user);
                    leaderBoardGameScore.setScenarioId(rs.getInt("scenario_id"));
                    leaderBoardGameScore.setScore(rs.getInt("max_score"));

                    leaderboardGameScores.add(leaderBoardGameScore);
                }

                return leaderboardGameScores;
            }
        }
    }

}
