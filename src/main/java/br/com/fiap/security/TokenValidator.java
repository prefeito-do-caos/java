package br.com.fiap.security;

import io.quarkus.security.UnauthorizedException;

import org.eclipse.microprofile.jwt.JsonWebToken;

public class TokenValidator {

    public static int validAccessToken(JsonWebToken jwt) {
        String tokenType = jwt.getClaim("type").toString();

        if (!"access".equals(tokenType)) {
            throw new UnauthorizedException("Invalid token type");
        }

        return Integer.parseInt(jwt.getSubject());
    }

}
