package com.example.grpcdemo.advanced;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class ClientStreamingClient {

    public static void main(String[] args) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50061)
                .usePlaintext()
                .build();

        StreamingServiceGrpc.StreamingServiceStub stub = StreamingServiceGrpc.newStub(channel);

        StreamObserver<StreamRequest> requestObserver = stub.clientStream(new StreamObserver<StreamResponse>() {
            @Override
            public void onNext(StreamResponse value) {
                System.out.println("Server says: " + value.getResponse());
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

        requestObserver.onNext(StreamRequest.newBuilder().setMessage("A").build());
        requestObserver.onNext(StreamRequest.newBuilder().setMessage("B").build());
        requestObserver.onNext(StreamRequest.newBuilder().setMessage("C").build());
        requestObserver.onCompleted();

        Thread.sleep(2000);
        channel.shutdown();
    }
}
