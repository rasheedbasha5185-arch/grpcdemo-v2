package com.example.grpcdemo.moderate;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;

public class MetadataClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053)
                .usePlaintext()
                .build();

        Metadata metadata = new Metadata();
        Metadata.Key<String> key = Metadata.Key.of("auth-token", Metadata.ASCII_STRING_MARSHALLER);
        metadata.put(key, "secret123");

        ModerateServiceGrpc.ModerateServiceBlockingStub stub =
                MetadataUtils.attachHeaders(ModerateServiceGrpc.newBlockingStub(channel), metadata);

        ComplexRequest request = ComplexRequest.newBuilder()
                .setRequestId("REQ-999")
                .build();

        ComplexResponse response = stub.processData(request);
        System.out.println("Response: " + response);

        channel.shutdown();
    }
}
