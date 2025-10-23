package com.example.grpcdemo;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ProducerConsumerClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        UnaryServiceGrpc.UnaryServiceBlockingStub stub = UnaryServiceGrpc.newBlockingStub(channel);

        MessageRequest request = MessageRequest.newBuilder()
                .setMessage("Hello from Client!")
                .build();

        MessageResponse response = stub.sendMessage(request);

        System.out.println("Response from server: " + response.getResponse());

        channel.shutdown();
    }
}
