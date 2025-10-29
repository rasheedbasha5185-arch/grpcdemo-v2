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

        System.out.println("🚀 BidiStreamingServer started on port 50062...");
        server.awaitTermination();
    }

    static class BidiStreamingImpl extends StreamingServiceGrpc.StreamingServiceImplBase {

        @Override
        public StreamObserver<StreamRequest> biDiStream(final StreamObserver<StreamResponse> responseObserver) {

            return new StreamObserver<StreamRequest>() {

                @Override
                public void onNext(StreamRequest value) {
                    String msg = value.getMessage();
                    System.out.println("📩 Received from client: " + msg);

                    StreamResponse response = StreamResponse.newBuilder()
                            .setResponse("Echo: " + msg)
                            .build();

                    responseObserver.onNext(response);
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("❌ Stream error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("✅ Client finished streaming.");
                    responseObserver.onCompleted();
                }
            };
        }
    }
}
