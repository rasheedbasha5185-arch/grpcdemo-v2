package com.example.grpcdemo;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;

public class ProducerConsumerServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Create and start the gRPC server
        Server server = ServerBuilder.forPort(50051)
                .addService(new UnaryServiceImpl())
                .build();

        System.out.println("🚀 Server started on port 50051...");
        server.start();
        server.awaitTermination();
    }

    // Inner service class implementing the gRPC service
    static class UnaryServiceImpl extends UnaryServiceGrpc.UnaryServiceImplBase {

        @Override
        public void sendMessage(MessageRequest request, StreamObserver<MessageResponse> responseObserver) {
            // Extract message from request
            String message = request.getMessage();
            String responseText = "Server received: " + message;

            // Build the response message
            MessageResponse response = MessageResponse.newBuilder()
                    .setResponse(responseText)   // field name: 'response'
                    .build();

            // Send the response
            responseObserver.onNext(response);
            responseObserver.onCompleted();

            System.out.println("✅ Handled client message: " + message);
        }
    }
}
