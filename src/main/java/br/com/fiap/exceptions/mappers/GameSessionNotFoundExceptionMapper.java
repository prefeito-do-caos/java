package br.com.fiap.exceptions.mappers;

import br.com.fiap.exceptions.GameSessionNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;

@Provider
public class GameSessionNotFoundExceptionMapper implements ExceptionMapper<GameSessionNotFoundException> {

    @Override
    public Response toResponse(GameSessionNotFoundException exception) {
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(Map.of(
                        "detail", "Game session not found"
                ))
                .build();
    }

}
