package com.example.grpcdemo.moderate;

import com.example.grpcdemo.UnaryServiceGrpc;
import com.example.grpcdemo.MessageRequest;
import com.example.grpcdemo.MessageResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Context;
import io.grpc.stub.StreamObserver;
import com.google.common.util.concurrent.MoreExecutors;

public class CancellationClient {

    public static void main(String[] args) throws InterruptedException {

        // 1️⃣ Connect to your gRPC server microservice
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9090)  // adjust if your server runs elsewhere
                .usePlaintext()
                .build();

        // 2️⃣ Create an async stub (non-blocking)
        UnaryServiceGrpc.UnaryServiceStub stub = UnaryServiceGrpc.newStub(channel);

        // 3️⃣ Create a cancellable context
        Context.CancellableContext cancellableContext = Context.current().withCancellation();

        // 4️⃣ Run the RPC within the cancellable context
        cancellableContext.run(() -> {

            // Response observer (handles replies from server)
            StreamObserver<MessageResponse> responseObserver = new StreamObserver<MessageResponse>() {
                @Override
                public void onNext(MessageResponse response) {
                    System.out.println("✅ Response from server: " + response.getResponse());
                }

                @Override
                public void onError(Throwable t) {
                    System.out.println("❌ RPC cancelled or failed: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("🎯 RPC completed successfully.");
                }
            };


            // 5️⃣ Start the RPC call
            System.out.println("➡️ Sending request to server...");
            stub.sendMessage(
                    MessageRequest.newBuilder()
                            .setMessage("This call will be cancelled soon")
                            .build(),
                    responseObserver
            );

            // 6️⃣ Wait for 1 second and cancel
            try {
                Thread.sleep(1000);
                System.out.println("🚨 Cancelling the call manually...");
                cancellableContext.cancel(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 7️⃣ Give time for cancellation to take effect before closing channel
        Thread.sleep(1500);
        channel.shutdownNow();
    }
}
