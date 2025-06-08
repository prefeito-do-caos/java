package br.com.fiap.exceptions.mappers;

import br.com.fiap.exceptions.ScenarioNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;

@Provider
public class ScenarioNotFoundExceptionMapper implements ExceptionMapper<ScenarioNotFoundException> {

    @Override
    public Response toResponse(ScenarioNotFoundException exception) {
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(Map.of(
                        "detail", "Scenario not found"
                ))
                .build();
    }

}
