package com.v1.app.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Base64;
import java.util.Map;
import java.util.function.Function;

@Service //to make it a managed bean
public class JwtService {
    @Value("${application.security.jwt.secret-key}")
    private String SECRET_KEY;

    public String extractUsername(String token) {
        return extractClaim(token , Claims::getSubject);
    }

    // here just to extract 1 claim
    public <T> T extractClaim(String token , Function<Claims , T> claimsTFunction) {
        final Claims claims = extractAllClaims(token);
        return  claimsTFunction.apply(claims);
    }



    // Token handling and generating
    //[ToDo] add the refresh token .
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignInkey() , SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }






    //here is to extract all the claims
    public Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInkey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInkey() {
        //this should be added to the application.yml
//        String SECRET_KEY = "ceb59c2946c17462990c15a4e83e6b4abc567c17288790f33742ec05a0787024ae067e1c6dfcc1e048b97a3f554dbaafe56472bf22da33a82adf1f4fc4984e9035716ed99f444233e96005d614e31ec5bb9e913acca29aaed8d64d17fb00d53062b3bdb7325bce5cbcadfa815c5dfeceb037c6cfc245019da03a6d3011a0e1eb233df0536d445ab7c86038a9a7538eb055b6259628f4c3a123ca269a65ef5b8d9f5643e0c83f2a60a68c3c217245d0fa67a4b35ef002b258a9493f22c81969adfd21a1ea8d31c8b25847260abcef7e74d37fc5531b5cdd7d79230f4e2472168188bf32dbf63682a807bd9434daf28032e71271666d26a66ad9b24755ed159c45";
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
