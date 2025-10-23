package com.example.grpcdemo.advanced;

import io.grpc.*;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;

public class ObservabilityInterceptor implements ServerInterceptor {

    private static final Tracer tracer =
            GlobalOpenTelemetry.getTracer("grpc-observability");

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> call,
            Metadata headers,
            ServerCallHandler<ReqT, RespT> next) {

        // Start a new trace span for this RPC
        Span span = tracer.spanBuilder("gRPC " + call.getMethodDescriptor().getFullMethodName()).startSpan();
        System.out.println("📊 Observing gRPC call: " + call.getMethodDescriptor().getFullMethodName());

        ServerCall.Listener<ReqT> listener = next.startCall(call, headers);

        // ✅ Fix: Explicit generic type <ReqT> specified here
        return new ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>(listener) {
            @Override
            public void onMessage(ReqT message) {
                System.out.println("📥 Request message: " + message);
                super.onMessage(message);
            }

            @Override
            public void onComplete() {
                span.end();
                System.out.println("✅ Span ended for: " + call.getMethodDescriptor().getFullMethodName());
                super.onComplete();
            }

            @Override
            public void onCancel() {
                span.end();
                System.out.println("❌ Call cancelled: " + call.getMethodDescriptor().getFullMethodName());
                super.onCancel();
            }
        };
    }
}
