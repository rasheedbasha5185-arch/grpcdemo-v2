package com.example.grpcdemo.advanced;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class ServerStreamingClient {

    public static void main(String[] args) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50060)
                .usePlaintext()
                .build();

        StreamingServiceGrpc.StreamingServiceStub stub = StreamingServiceGrpc.newStub(channel);

        StreamRequest request = StreamRequest.newBuilder().setMessage("Server Streaming Example").build();

        stub.serverStream(request, new StreamObserver<StreamResponse>() {
            @Override
            public void onNext(StreamResponse value) {
                System.out.println("Received: " + value.getResponse());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error: " + t);
            }

            @Override
            public void onCompleted() {
                System.out.println("Stream completed");
            }
        });

        Thread.sleep(6000);
        channel.shutdown();
    }
}
