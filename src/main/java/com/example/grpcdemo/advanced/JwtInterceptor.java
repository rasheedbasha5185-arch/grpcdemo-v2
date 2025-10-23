package com.example.grpcdemo.advanced;

import io.grpc.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;

public class JwtInterceptor implements ServerInterceptor {

    private static final String SECRET_KEY = "ThisIsASecretKeyForJWTExample12345"; // Should be 32+ chars for HS256

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> call,
            Metadata headers,
            ServerCallHandler<ReqT, RespT> next) {

        // Read "Authorization" header
        Metadata.Key<String> AUTH_KEY = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);
        String token = headers.get(AUTH_KEY);

        if (token == null || !validateJwt(token.replace("Bearer ", ""))) {
            call.close(Status.UNAUTHENTICATED.withDescription("Invalid or missing JWT token"), new Metadata());
            // Return empty listener when authentication fails
            return new ServerCall.Listener<ReqT>() {};
        }

        // If valid, continue processing the call
        return next.startCall(call, headers);
    }

    /**
     * Validates the JWT token using the secret key.
     */
    private boolean validateJwt(String jwt) {
        try {
            Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwt)
                    .getBody();

            System.out.println("✅ JWT validated for subject: " + claims.getSubject());
            return true;
        } catch (Exception e) {
            System.err.println("❌ JWT validation failed: " + e.getMessage());
            return false;
        }
    }
}
