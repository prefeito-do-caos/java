package br.com.fiap.resources;

import br.com.fiap.beans.Medal;
import br.com.fiap.bo.MedalBO;
import br.com.fiap.dto.UserMedal;
import br.com.fiap.exceptions.ConnectionException;
import br.com.fiap.exceptions.MedalNotFoundException;
import br.com.fiap.security.TokenValidator;

import io.quarkus.security.Authenticated;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.jwt.JsonWebToken;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/medals")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedalResource {

    private final MedalBO medalBO = new MedalBO();

    @Inject
    JsonWebToken jwt;

    @GET
    public Response getMedals() throws SQLException, ConnectionException {

        ArrayList<Medal> medals = (ArrayList<Medal>) medalBO.getAll();
        return Response.ok(medals).build();
    }

    @GET
    @Path("/{id}")
    public Response getMedalsById(@PathParam("id") int id) throws
            SQLException, ConnectionException, MedalNotFoundException {

        Medal medal = medalBO.getById(id);
        if (medal == null) throw new MedalNotFoundException();
        return Response.ok(medal).build();
    }

    @GET
    @Path("/me")
    @Authenticated
    public Response getMedalsByUserId() throws SQLException, ConnectionException {

        int userId = TokenValidator.validAccessToken(jwt);
        ArrayList<UserMedal> medals = (ArrayList<UserMedal>) medalBO.getByUserId(userId);
        return Response.ok(medals).build();
    }

}
