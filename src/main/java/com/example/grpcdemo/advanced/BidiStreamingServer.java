package com.example.grpcdemo.advanced;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class BidiStreamingServer {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50062)
                .addService(new BidiStreamingImpl())
                .build()
                .start();

        System.out.println("BidiStreamingServer started on port 50062...");
        server.awaitTermination();
    }

    static class BidiStreamingImpl extends StreamingServiceGrpc.StreamingServiceImplBase {
        @Override
        public StreamObserver<StreamRequest> biDiStream(StreamObserver<StreamResponse> responseObserver) {
            return new StreamObserver<StreamRequest>() {
                @Override
                public void onNext(StreamRequest value) {
                    responseObserver.onNext(StreamResponse.newBuilder()
                            .setResponse("Echo: " + value.getMessage())
                            .build());
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Error: " + t);
                }

                @Override
                public void onCompleted() {
                    responseObserver.onCompleted();
                }
            };
        }
    }
}
