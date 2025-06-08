package br.com.fiap.resources;

import br.com.fiap.bo.UserBO;
import br.com.fiap.dto.AuthResponse;
import br.com.fiap.dto.PublicUser;
import br.com.fiap.exceptions.ConnectionException;
import br.com.fiap.security.AuthService;
import br.com.fiap.security.JwtGenerator;

import io.smallrye.jwt.auth.principal.JWTParser;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import org.eclipse.microprofile.jwt.JsonWebToken;

import java.sql.SQLException;
import java.time.Duration;
import java.util.Map;

@Path("/auth")
public class AuthResource {

    @Inject
    JwtGenerator jwtGenerator;

    @Inject
    JWTParser jwtParser;

    @POST
    @Path("/token")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticate(
            @FormParam("username") String username,
            @FormParam("password") String password
    ) throws SQLException, ConnectionException {

        PublicUser user = AuthService.validUser(username, password);
        if (user == null) {
            return Response
                .status(Response.Status.UNAUTHORIZED)
                .entity(Map.of("detail", "Incorrect username or password"))
                .build();
        }

        String accessToken = jwtGenerator.generateAccessToken(user.getId());
        String refreshToken = jwtGenerator.generateRefreshToken(user.getId());

        AuthResponse authResponse = new AuthResponse(accessToken, "Bearer");
        authResponse.setUser(user);

        NewCookie refreshTokenCookie = new NewCookie.Builder("refresh_token")
            .value(refreshToken)
            .path("/")
            .maxAge((int) Duration.ofDays(30).getSeconds())
            .httpOnly(true)
            .secure(true)
            .sameSite(NewCookie.SameSite.STRICT)
            .build();

        return Response.ok(authResponse).cookie(refreshTokenCookie).build();
    }

    @POST
    @Path("/refresh")
    @Produces(MediaType.APPLICATION_JSON)
    public Response refreshToken(@CookieParam("refresh_token") String refreshToken) {

        if (refreshToken == null || refreshToken.isBlank()) {
            return Response.status(Response.Status.UNAUTHORIZED)
                .entity(Map.of("detail", "Missing refresh token"))
                .build();
        }

        try {
            var claims = jwtParser.parse(refreshToken);
            String type = ((JsonWebToken) claims).getClaim("type").toString();
            if (!"refresh".equals(type)) {
                return Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity(Map.of("detail", "Invalid token type"))
                    .build();
            }

            int userId = Integer.parseInt(claims.getSubject());
            PublicUser user = new UserBO().getById(userId);

            String newAccessToken = jwtGenerator.generateAccessToken(userId);
            AuthResponse authResponse = new AuthResponse(newAccessToken, "Bearer");
            authResponse.setUser(user);

            return Response.ok(authResponse).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response
                .status(Response.Status.UNAUTHORIZED)
                .entity(Map.of("detail", "Invalid or expired refresh token"))
                .build();
        }
    }

}
