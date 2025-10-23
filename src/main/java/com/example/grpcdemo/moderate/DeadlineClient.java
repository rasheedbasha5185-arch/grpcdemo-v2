package com.example.grpcdemo.moderate;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;

public class DeadlineClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext()
                .build();

        ModerateServiceGrpc.ModerateServiceBlockingStub stub = ModerateServiceGrpc.newBlockingStub(channel)
                .withDeadlineAfter(1, TimeUnit.SECONDS); // client timeout

        try {
            ComplexRequest request = ComplexRequest.newBuilder()
                    .setRequestId("REQ-123")
                    .setDescription("Test deadline")
                    .build();

            System.out.println(stub.processData(request));
        } catch (StatusRuntimeException e) {
            System.err.println("Deadline exceeded: " + e.getStatus());
        }

        channel.shutdown();
    }
}
