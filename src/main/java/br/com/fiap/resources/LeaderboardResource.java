package br.com.fiap.resources;

import br.com.fiap.bo.GameScoreBO;
import br.com.fiap.dto.LeaderboardGameScore;
import br.com.fiap.exceptions.ConnectionException;
import br.com.fiap.exceptions.ScenarioNotFoundException;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/leaderboard")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LeaderboardResource {

    private final GameScoreBO gameScoreBO = new GameScoreBO();

    @GET
    @Path("/{scenario_id}")
    public Response getLeaderboardByScenarioId(@PathParam("scenario_id") int scenarioId) throws
            ScenarioNotFoundException, SQLException, ConnectionException {

        ArrayList<LeaderboardGameScore> leaderboard = (ArrayList<LeaderboardGameScore>) gameScoreBO.getLeaderBoardByScenarioId(scenarioId);
        return Response.ok(leaderboard).build();
    }

}
