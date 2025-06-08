package br.com.fiap.resources;

import br.com.fiap.beans.User;
import br.com.fiap.bo.UserBO;
import br.com.fiap.dto.PublicUser;
import br.com.fiap.dto.UpdatePasswordRequest;
import br.com.fiap.exceptions.*;
import br.com.fiap.security.TokenValidator;

import io.quarkus.security.Authenticated;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import org.eclipse.microprofile.jwt.JsonWebToken;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private final UserBO userBO = new UserBO();

    @Inject
    JsonWebToken jwt;

    @GET
    public Response getUsers() throws SQLException, ConnectionException {
        ArrayList<PublicUser> users = userBO.getAll();
        return Response.ok(users).build();
    }

    @GET
    @Path("/me")
    @Authenticated
    public Response getUser() throws SQLException, ConnectionException {
        int userId = TokenValidator.validAccessToken(jwt);
        PublicUser user = userBO.getById(userId);
        return Response.ok(user).build();
    }

    @POST
    public Response postUser(User user) throws
            SQLException, ConnectionException, UserNameAlreadyExistsException, InsertException {

        PublicUser createdUser = userBO.insert(user);
        return Response
            .status(Response.Status.CREATED)
            .entity(createdUser)
            .build();
    }

    @PUT
    @Path("/me")
    @Authenticated
    public Response putUser(User user) throws
            SQLException, ConnectionException, UserNameAlreadyExistsException, UpdateException {

        int userId = TokenValidator.validAccessToken(jwt);
        PublicUser updatedUser = userBO.update(userId, user);
        return Response
            .ok()
            .entity(updatedUser)
            .build();
    }

    @PUT
    @Path("/me/password")
    @Authenticated
    public Response putUserPassword(UpdatePasswordRequest updatePasswordRequest) throws
            SQLException, ConnectionException, UpdateException, IncorrectPasswordException {

        int userId = TokenValidator.validAccessToken(jwt);
        userBO.updatePassword(userId, updatePasswordRequest.getPassword(), updatePasswordRequest.getNewPassword());
        return Response.ok().build();
    }

}
