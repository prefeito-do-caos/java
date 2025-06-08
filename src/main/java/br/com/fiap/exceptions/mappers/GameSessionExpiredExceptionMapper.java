package br.com.fiap.exceptions.mappers;

import br.com.fiap.exceptions.GameSessionExpiredException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;

@Provider
public class GameSessionExpiredExceptionMapper implements ExceptionMapper<GameSessionExpiredException> {

    @Override
    public Response toResponse(GameSessionExpiredException exception) {
        return Response
                .status(Response.Status.GONE)
                .entity(Map.of(
                        "detail", "Game session has expired"
                ))
                .build();
    }

}
