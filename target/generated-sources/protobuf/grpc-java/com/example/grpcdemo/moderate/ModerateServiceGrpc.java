package com.example.grpcdemo.moderate;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: moderate.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ModerateServiceGrpc {

  private ModerateServiceGrpc() {}

  public static final String SERVICE_NAME = "ModerateService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpcdemo.moderate.ComplexRequest,
      com.example.grpcdemo.moderate.ComplexResponse> getProcessDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProcessData",
      requestType = com.example.grpcdemo.moderate.ComplexRequest.class,
      responseType = com.example.grpcdemo.moderate.ComplexResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpcdemo.moderate.ComplexRequest,
      com.example.grpcdemo.moderate.ComplexResponse> getProcessDataMethod() {
    io.grpc.MethodDescriptor<com.example.grpcdemo.moderate.ComplexRequest, com.example.grpcdemo.moderate.ComplexResponse> getProcessDataMethod;
    if ((getProcessDataMethod = ModerateServiceGrpc.getProcessDataMethod) == null) {
      synchronized (ModerateServiceGrpc.class) {
        if ((getProcessDataMethod = ModerateServiceGrpc.getProcessDataMethod) == null) {
          ModerateServiceGrpc.getProcessDataMethod = getProcessDataMethod =
              io.grpc.MethodDescriptor.<com.example.grpcdemo.moderate.ComplexRequest, com.example.grpcdemo.moderate.ComplexResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProcessData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcdemo.moderate.ComplexRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcdemo.moderate.ComplexResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ModerateServiceMethodDescriptorSupplier("ProcessData"))
              .build();
        }
      }
    }
    return getProcessDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ModerateServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModerateServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ModerateServiceStub>() {
        @java.lang.Override
        public ModerateServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ModerateServiceStub(channel, callOptions);
        }
      };
    return ModerateServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ModerateServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModerateServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ModerateServiceBlockingStub>() {
        @java.lang.Override
        public ModerateServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ModerateServiceBlockingStub(channel, callOptions);
        }
      };
    return ModerateServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ModerateServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModerateServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ModerateServiceFutureStub>() {
        @java.lang.Override
        public ModerateServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ModerateServiceFutureStub(channel, callOptions);
        }
      };
    return ModerateServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void processData(com.example.grpcdemo.moderate.ComplexRequest request,
        io.grpc.stub.StreamObserver<com.example.grpcdemo.moderate.ComplexResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProcessDataMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ModerateService.
   */
  public static abstract class ModerateServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ModerateServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ModerateService.
   */
  public static final class ModerateServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ModerateServiceStub> {
    private ModerateServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModerateServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModerateServiceStub(channel, callOptions);
    }

    /**
     */
    public void processData(com.example.grpcdemo.moderate.ComplexRequest request,
        io.grpc.stub.StreamObserver<com.example.grpcdemo.moderate.ComplexResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProcessDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ModerateService.
   */
  public static final class ModerateServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ModerateServiceBlockingStub> {
    private ModerateServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModerateServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModerateServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpcdemo.moderate.ComplexResponse processData(com.example.grpcdemo.moderate.ComplexRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProcessDataMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ModerateService.
   */
  public static final class ModerateServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ModerateServiceFutureStub> {
    private ModerateServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModerateServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModerateServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpcdemo.moderate.ComplexResponse> processData(
        com.example.grpcdemo.moderate.ComplexRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProcessDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PROCESS_DATA = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PROCESS_DATA:
          serviceImpl.processData((com.example.grpcdemo.moderate.ComplexRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpcdemo.moderate.ComplexResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getProcessDataMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpcdemo.moderate.ComplexRequest,
              com.example.grpcdemo.moderate.ComplexResponse>(
                service, METHODID_PROCESS_DATA)))
        .build();
  }

  private static abstract class ModerateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ModerateServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpcdemo.moderate.ModerateProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ModerateService");
    }
  }

  private static final class ModerateServiceFileDescriptorSupplier
      extends ModerateServiceBaseDescriptorSupplier {
    ModerateServiceFileDescriptorSupplier() {}
  }

  private static final class ModerateServiceMethodDescriptorSupplier
      extends ModerateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ModerateServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ModerateServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ModerateServiceFileDescriptorSupplier())
              .addMethod(getProcessDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
