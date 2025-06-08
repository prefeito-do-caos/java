package br.com.fiap.security;

import io.github.cdimascio.dotenv.Dotenv;
import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtClaimsBuilder;

import jakarta.enterprise.context.ApplicationScoped;

import java.time.Duration;

@ApplicationScoped
public class JwtGenerator {

    private static final String jwtIssue = Dotenv.load().get("JWT_ISSUER");

    public String generateAccessToken(int userId) {
        JwtClaimsBuilder builder = Jwt.issuer(jwtIssue)
                .subject(String.valueOf(userId))
                .expiresIn(Duration.ofMinutes(15))
                .claim("type", "access");

        return builder.sign();
    }

    public String generateRefreshToken(int userId) {
        JwtClaimsBuilder builder = Jwt.issuer(jwtIssue)
                .subject(String.valueOf(userId))
                .expiresIn(Duration.ofDays(30))
                .claim("type", "refresh");

        return builder.sign();
    }

}
