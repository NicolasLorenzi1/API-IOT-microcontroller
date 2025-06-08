package com.tcc.iot_mc_api.infra.security;

import java.time.Instant;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.tcc.iot_mc_api.model.user.User;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String key;

    private final String ISSUER = "teste-api";
    
    public String generateToken(User user) {
        try {

            Algorithm algorithm = Algorithm.HMAC256(key);
            return JWT.create()
            .withIssuer(ISSUER)
            .withExpiresAt(expirationDate())
            .withSubject(user.getEmail())
            .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new JWTCreationException("Erro ao gerar o token.", e);
        }
    }

    public String getSubjectFromToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(key);
            return JWT.require(algorithm)
            .withIssuer(ISSUER)
            .build()
            .verify(token)
            .getSubject();
        } catch (JWTVerificationException e) {
            throw new JWTVerificationException("Token não existe ou foi expirado", e);
        }
    }

    private Instant expirationDate() {
        return ZonedDateTime.now().plusHours(4).toInstant();
    }
}
