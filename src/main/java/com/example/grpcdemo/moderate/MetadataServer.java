package com.example.grpcdemo.moderate;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class MetadataServer {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50053)
                .addService(new ModerateServer.ModerateServiceImpl())
                .intercept(new AuthInterceptor())
                .build()
                .start();

        System.out.println("MetadataServer started on port 50053...");
        server.awaitTermination();
    }
}
