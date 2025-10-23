package com.example.grpcdemo.moderate;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.stream.Collectors;

public class ModerateServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50052)
                .addService(new ModerateServiceImpl())
                .build()
                .start();

        System.out.println("ModerateServer started on port 50052...");
        server.awaitTermination();
    }

    static class ModerateServiceImpl extends ModerateServiceGrpc.ModerateServiceImplBase {
        @Override
        public void processData(ComplexRequest request, StreamObserver<ComplexResponse> responseObserver) {
            String processed = request.getItemsList().stream()
                    .map(item -> item.getName() + " x" + item.getQuantity())
                    .collect(Collectors.joining(", "));

            ComplexResponse response = ComplexResponse.newBuilder()
                    .setStatus("Processed by " + request.getMetadata().getCreatedBy())
                    .addProcessedItems(processed)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
