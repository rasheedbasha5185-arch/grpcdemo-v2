package com.example.grpcdemo.advanced;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ServerStreamingServer {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50060)
                .addService(new StreamingServiceImpl())
                .build()
                .start();

        System.out.println("ServerStreamingServer started on port 50060...");
        server.awaitTermination();
    }

    static class StreamingServiceImpl extends StreamingServiceGrpc.StreamingServiceImplBase {
        @Override
        public void serverStream(StreamRequest request, StreamObserver<StreamResponse> responseObserver) {
            for (int i = 1; i <= 5; i++) {
                String message = "Response " + i + " for: " + request.getMessage();
                responseObserver.onNext(StreamResponse.newBuilder().setResponse(message).build());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            responseObserver.onCompleted();
        }
    }
}
