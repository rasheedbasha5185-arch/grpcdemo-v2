package com.example.grpcdemo.moderate;

import io.grpc.*;

public class AuthInterceptor implements ServerInterceptor {

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> call,
            Metadata headers,
            ServerCallHandler<ReqT, RespT> next) {

        String authHeader = headers.get(Metadata.Key.of("auth-token", Metadata.ASCII_STRING_MARSHALLER));

        if (authHeader == null || !authHeader.equals("secret123")) {
            call.close(Status.PERMISSION_DENIED.withDescription("Invalid auth token"), new Metadata());
            // 👇 Fix: explicitly use diamond operator with generic type
            return new ServerCall.Listener<ReqT>() {};
        }

        return next.startCall(call, headers);
    }
}
