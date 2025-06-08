package br.com.fiap.exceptions.mappers;

import br.com.fiap.exceptions.UserNameAlreadyExistsException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;

@Provider
public class UserNameAlreadyExistsExceptionMapper implements ExceptionMapper<UserNameAlreadyExistsException> {

    @Override
    public Response toResponse(UserNameAlreadyExistsException exception) {
        return Response
            .status(Response.Status.CONFLICT)
            .entity(Map.of(
                "detail", "Name already exists"
            ))
            .build();
    }

}
