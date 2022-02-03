package com.utcn.se.project.factory;

import com.utcn.se.project.model.AuthenticatedUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.stereotype.Component;

@Component
public class UserJWTGenerator {
    private static final String SECRET_KEY = "Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=";

    public String generate(AuthenticatedUser authenticatedUser) {
        return Jwts.builder()
                .setClaims(generateClaimsForUserJWT(authenticatedUser))
                .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.decode(SECRET_KEY))
                .compact();
    }

    private Claims generateClaimsForUserJWT(AuthenticatedUser authenticatedUser) {
        Claims claims = Jwts.claims();
        claims.put("userId", authenticatedUser.getUserId());
        claims.put("email", authenticatedUser.getEmail());
        claims.put("role", authenticatedUser.getRole());
        return claims;
    }
}
