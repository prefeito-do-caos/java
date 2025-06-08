package br.com.fiap.resources;

import br.com.fiap.beans.GameSession;
import br.com.fiap.bo.GameSessionBO;
import br.com.fiap.bo.SessionCardBO;
import br.com.fiap.dto.CreateGameSession;
import br.com.fiap.dto.NextCard;
import br.com.fiap.exceptions.*;
import br.com.fiap.security.TokenValidator;

import io.quarkus.security.Authenticated;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.jwt.JsonWebToken;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

@Path("/game-sessions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GameResource {

    private final GameSessionBO gameSessionBO = new GameSessionBO();
    private final SessionCardBO sessionCardBO = new SessionCardBO();

    @Inject
    JsonWebToken jwt;

    @GET
    @Path("/me")
    @Authenticated
    public Response getGameSessionsByUserId() throws SQLException, ConnectionException {
        int userId = TokenValidator.validAccessToken(jwt);
        ArrayList<GameSession> gameSessions = gameSessionBO.getByUserId(userId);
        return Response.ok(gameSessions).build();
    }

    @GET
    @Path("/{code}")
    @Authenticated
    public Response getGameSessionsByCode(@PathParam("code") String code) throws
            SQLException, ConnectionException, GameSessionNotFoundException {

        int userId = TokenValidator.validAccessToken(jwt);

        GameSession gameSession = gameSessionBO.getByCode(code);
        if (gameSession == null) throw new GameSessionNotFoundException();
        if (gameSession.getUser().getId() != userId) {
            return Response.status(Response.Status.UNAUTHORIZED)
                .entity(Map.of("detail", "You are not authorized to access this game session"))
                .build();
        };

        return Response.ok(gameSession).build();
    }

    @GET
    @Path("/{code}/next")
    @Authenticated
    public Response getNextCardFromGameSessionsByCode(@PathParam("code") String code) throws
            SQLException, ConnectionException, GameSessionNotFoundException, NextCardNotFoundException, GameSessionExpiredException {

        int userId = TokenValidator.validAccessToken(jwt);

        GameSession gameSession = gameSessionBO.getByCode(code);
        if (gameSession == null) throw new GameSessionNotFoundException();
        if (gameSession.getUser().getId() != userId) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(Map.of("detail", "You are not authorized to access this game session"))
                    .build();
        };
        if (LocalDateTime.now().isAfter(gameSession.getExpireAt())) throw new GameSessionExpiredException();

        NextCard nextCard = sessionCardBO.getNextCardFromGameSessionsByCode(code);
        if (nextCard == null) throw new NextCardNotFoundException();

        return Response.ok(nextCard).build();
    }

    @POST
    @Authenticated
    public Response postGameSession(CreateGameSession createGameSession) throws
            SQLException, ScenarioNotFoundException, ConnectionException, InsertException {

        int userId = TokenValidator.validAccessToken(jwt);
        GameSession createdGameSession = gameSessionBO.insert(userId, createGameSession.getScenarioId());
        return Response
            .status(Response.Status.CREATED)
            .entity(createdGameSession)
            .build();
    }

}
