package br.com.fiap.exceptions.mappers;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

import java.sql.SQLException;
import java.util.Map;

public class SQLExceptionMapper  implements ExceptionMapper<SQLException> {

    @Override
    public Response toResponse(SQLException exception) {
        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(Map.of(
                        "detail", "A database error occurred while processing the request. Please try again later",
                        "error", exception.getMessage()
                ))
                .build();
    }

}
