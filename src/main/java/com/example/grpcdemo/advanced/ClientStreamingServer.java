package com.example.grpcdemo.advanced;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ClientStreamingServer {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50061)
                .addService(new ClientStreamingImpl())
                .build()
                .start();

        System.out.println("ClientStreamingServer started on port 50061...");
        server.awaitTermination();
    }

    static class ClientStreamingImpl extends StreamingServiceGrpc.StreamingServiceImplBase {
        @Override
        public StreamObserver<StreamRequest> clientStream(StreamObserver<StreamResponse> responseObserver) {
            return new StreamObserver<StreamRequest>() {
                StringBuilder allMessages = new StringBuilder();

                @Override
                public void onNext(StreamRequest value) {
                    allMessages.append(value.getMessage()).append(" | ");
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Error: " + t);
                }

                @Override
                public void onCompleted() {
                    responseObserver.onNext(StreamResponse.newBuilder()
                            .setResponse("Received messages: " + allMessages)
                            .build());
                    responseObserver.onCompleted();
                }
            };
        }
    }
}
