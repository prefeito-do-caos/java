package br.com.fiap.exceptions.mappers;

import br.com.fiap.exceptions.InsertException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;

@Provider
public class InsertExceptionMapper implements ExceptionMapper<InsertException> {

    @Override
    public Response toResponse(InsertException exception) {
        return Response
            .status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(Map.of(
                "detail", "Failed to create the resource due to an internal error or invalid request data"
            ))
            .build();
    }

}
