package br.com.fiap.exceptions.mappers;

import br.com.fiap.exceptions.UpdateException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;

@Provider
public class UpdateExceptionMapper implements ExceptionMapper<UpdateException> {

    @Override
    public Response toResponse(UpdateException exception) {
        return Response
            .status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(Map.of(
                    "detail", "Failed to update the resource due to an internal error or invalid request data"
            ))
            .build();
    }

}
