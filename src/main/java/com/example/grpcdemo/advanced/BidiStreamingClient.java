package com.example.grpcdemo.advanced;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class BidiStreamingClient {

    public static void main(String[] args) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50062)
                .usePlaintext()
                .build();

        StreamingServiceGrpc.StreamingServiceStub stub = StreamingServiceGrpc.newStub(channel);

        StreamObserver<StreamRequest> requestObserver = stub.biDiStream(new StreamObserver<StreamResponse>() {
            @Override
            public void onNext(StreamResponse value) {
                System.out.println("Server: " + value.getResponse());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error: " + t);
            }

            @Override
            public void onCompleted() {
                System.out.println("BiDi stream complete");
            }
        });

        requestObserver.onNext(StreamRequest.newBuilder().setMessage("Ping 1").build());
        requestObserver.onNext(StreamRequest.newBuilder().setMessage("Ping 2").build());
        requestObserver.onNext(StreamRequest.newBuilder().setMessage("Ping 3").build());
        requestObserver.onCompleted();

        Thread.sleep(3000);
        channel.shutdown();
    }
}
