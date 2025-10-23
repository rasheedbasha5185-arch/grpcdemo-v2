package com.example.grpcdemo;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class ProducerConsumerServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50051)
                .addService(new UnaryServiceImpl())
                .build();

        System.out.println("Server started on port 50051...");
        server.start();
        server.awaitTermination();
    }

    static class UnaryServiceImpl extends UnaryServiceGrpc.UnaryServiceImplBase {
        @Override
        public void sendMessage(MessageRequest request, StreamObserver<MessageResponse> responseObserver) {
            String message = request.getMessage();
            String responseText = "Server received: " + message;
            MessageResponse response = MessageResponse.newBuilder().setResponse(responseText).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
