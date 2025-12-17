package org.example.nova.user.utils;

import io.jsonwebtoken.*;
        import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtProvider {

    // 🔑 실습용 (운영에서는 환경변수)
    private static final String SECRET = "THIS_IS_TEST_SECRET_KEY_FOR_JWT_EXAMPLE_123456";
    private static final long EXPIRE_MS = 1000 * 60 * 30; // 30분

    private static final Key KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    public static String createToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_MS))
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public static String getUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}