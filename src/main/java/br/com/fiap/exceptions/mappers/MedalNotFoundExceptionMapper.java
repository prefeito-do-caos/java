package br.com.fiap.exceptions.mappers;

import br.com.fiap.exceptions.MedalNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;

@Provider
public class MedalNotFoundExceptionMapper implements ExceptionMapper<MedalNotFoundException> {

    @Override
    public Response toResponse(MedalNotFoundException exception) {
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(Map.of(
                        "detail", "Medal not found"
                ))
                .build();
    }

}
