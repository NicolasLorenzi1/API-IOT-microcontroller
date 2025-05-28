package com.tcc.iot_mc_api.service;

import java.time.Instant;
import java.time.ZonedDateTime;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.tcc.iot_mc_api.controller.UsuarioDetails;

public class JWTTokenService {
    
    private static final String SECRET_KEY = "5a472fe9fa4f2ebf5ff5470b7610447eda498665c6eb8466458c7f7c4dad52c676ad409de7e3e294e9b53a4fd1fa9d70cf2bf0c853b8f72d36f9d5accea5162cbd7097f86d433d011226b0eb364bc5f5f9edb3e3997a1f82a04c3ea149ba9c237bab5c45ce3d388d3509482a88806c835b0c737d00e411b620921865e720f54db50c0732ebed83f1019f9046822ff676cdd02b1dc2b1e279836b5a377201c1d29d010922fd9f040dc7b2c7a5250d387e3985cf66aad2b55d8f0dcea868794f7f15668fedcadbbf90635a3aaa97d672ec2bb86a90d2498f831150d7613dfcce57fb083f13b02e928202186fa3b29d93f9b28cbf177aad5ccc2b6617ed308abc01";

    private static final String ISSUER = "teste-api";

    public String generateToken(UsuarioDetails usuario) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        try {
            return JWT.create()
            .withIssuer(ISSUER)
            .withIssuedAt(dataCriacao())
            .withExpiresAt(dataExpiracao())
            .withSubject(usuario.getUsername())
            .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new JWTCreationException("Erro ao gerar o token.", e);
        }
    }

    public String getSubjectFromToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            return JWT.require(algorithm)
            .withIssuer(ISSUER)
            .build()
            .verify(token)
            .getSubject();
        } catch (JWTVerificationException e) {
            throw new JWTVerificationException("Token não existe ou foi expirado", e);
        }
    }

    private Instant dataCriacao() {
        return ZonedDateTime.now().toInstant();
    }

    private Instant dataExpiracao() {
        return ZonedDateTime.now().plusHours(4).toInstant();
    }
}
