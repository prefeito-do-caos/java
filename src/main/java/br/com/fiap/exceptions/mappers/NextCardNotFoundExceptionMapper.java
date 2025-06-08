package br.com.fiap.exceptions.mappers;

import br.com.fiap.exceptions.NextCardNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;

@Provider
public class NextCardNotFoundExceptionMapper implements ExceptionMapper<NextCardNotFoundException> {

    @Override
    public Response toResponse(NextCardNotFoundException exception) {
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(Map.of(
                        "detail", "Next card not found"
                ))
                .build();
    }

}
