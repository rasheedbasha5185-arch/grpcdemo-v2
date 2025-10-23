package com.example.grpcdemo.advanced;

import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;

import javax.net.ssl.SSLException;
import java.io.File;
import java.io.IOException;

public class AdvancedServerWithTLS {

    public static void main(String[] args) throws IOException, InterruptedException, SSLException {
        // ✅ Correct paths — make sure you have these cert files in your project
        File certChain = new File("src/main/resources/certs/server.crt");
        File privateKey = new File("src/main/resources/certs/server.pem");

        // ✅ Build a secure gRPC server with TLS enabled
        Server server = NettyServerBuilder.forPort(50070)
                .addService(new BidiStreamingServer.BidiStreamingImpl())  // or your desired service
                .sslContext(GrpcSslContexts.forServer(certChain, privateKey).build())
                .build()
                .start();

        System.out.println("🔒 TLS-secured gRPC server started on port 50070...");
        server.awaitTermination();
    }
}
