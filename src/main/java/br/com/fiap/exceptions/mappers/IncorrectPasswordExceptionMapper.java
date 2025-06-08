package br.com.fiap.exceptions.mappers;

import br.com.fiap.exceptions.IncorrectPasswordException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;

@Provider
public class IncorrectPasswordExceptionMapper implements ExceptionMapper<IncorrectPasswordException> {

    @Override
    public Response toResponse(IncorrectPasswordException exception) {
        return Response
                .status(Response.Status.FORBIDDEN)
                .entity(Map.of(
                        "detail", "Incorrect current password"
                ))
                .build();
    }

}
