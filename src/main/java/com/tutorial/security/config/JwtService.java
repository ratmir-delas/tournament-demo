package com.tutorial.security.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.hibernate.annotations.DialectOverride;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "81cb1c6f22512ee206b3e036613daa7b789c2a080793591ded73a34ef1344bdc";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetail) {
        return generateToken(new HashMap<>(), userDetail);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetail) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetail.getUsername())
                .setIssuedAt(new java.util.Date(System.currentTimeMillis()))
                //.setExpiration(new java.util.Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .setExpiration(new java.util.Date(System.currentTimeMillis() + 1000 * 60 * 60 * 5))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Boolean isTokenValid(String token, UserDetails userDetail) {
        final String username = extractUsername(token);
        return (username.equals(userDetail.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        assert extractExpiration(token) != null;
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigningKey() {
        byte[] secretKeyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(secretKeyBytes);
    }
}