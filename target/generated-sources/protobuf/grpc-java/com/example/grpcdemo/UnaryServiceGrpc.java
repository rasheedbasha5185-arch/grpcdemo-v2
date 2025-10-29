package com.example.grpcdemo;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: unaryservice.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UnaryServiceGrpc {

  private UnaryServiceGrpc() {}

  public static final String SERVICE_NAME = "UnaryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpcdemo.MessageRequest,
      com.example.grpcdemo.MessageResponse> getSendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendMessage",
      requestType = com.example.grpcdemo.MessageRequest.class,
      responseType = com.example.grpcdemo.MessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpcdemo.MessageRequest,
      com.example.grpcdemo.MessageResponse> getSendMessageMethod() {
    io.grpc.MethodDescriptor<com.example.grpcdemo.MessageRequest, com.example.grpcdemo.MessageResponse> getSendMessageMethod;
    if ((getSendMessageMethod = UnaryServiceGrpc.getSendMessageMethod) == null) {
      synchronized (UnaryServiceGrpc.class) {
        if ((getSendMessageMethod = UnaryServiceGrpc.getSendMessageMethod) == null) {
          UnaryServiceGrpc.getSendMessageMethod = getSendMessageMethod =
              io.grpc.MethodDescriptor.<com.example.grpcdemo.MessageRequest, com.example.grpcdemo.MessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcdemo.MessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcdemo.MessageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UnaryServiceMethodDescriptorSupplier("SendMessage"))
              .build();
        }
      }
    }
    return getSendMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UnaryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UnaryServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UnaryServiceStub>() {
        @java.lang.Override
        public UnaryServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UnaryServiceStub(channel, callOptions);
        }
      };
    return UnaryServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UnaryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UnaryServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UnaryServiceBlockingStub>() {
        @java.lang.Override
        public UnaryServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UnaryServiceBlockingStub(channel, callOptions);
        }
      };
    return UnaryServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UnaryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UnaryServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UnaryServiceFutureStub>() {
        @java.lang.Override
        public UnaryServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UnaryServiceFutureStub(channel, callOptions);
        }
      };
    return UnaryServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void sendMessage(com.example.grpcdemo.MessageRequest request,
        io.grpc.stub.StreamObserver<com.example.grpcdemo.MessageResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendMessageMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service UnaryService.
   */
  public static abstract class UnaryServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return UnaryServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service UnaryService.
   */
  public static final class UnaryServiceStub
      extends io.grpc.stub.AbstractAsyncStub<UnaryServiceStub> {
    private UnaryServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UnaryServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UnaryServiceStub(channel, callOptions);
    }

    /**
     */
    public void sendMessage(com.example.grpcdemo.MessageRequest request,
        io.grpc.stub.StreamObserver<com.example.grpcdemo.MessageResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service UnaryService.
   */
  public static final class UnaryServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<UnaryServiceBlockingStub> {
    private UnaryServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UnaryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UnaryServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpcdemo.MessageResponse sendMessage(com.example.grpcdemo.MessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service UnaryService.
   */
  public static final class UnaryServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<UnaryServiceFutureStub> {
    private UnaryServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UnaryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UnaryServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpcdemo.MessageResponse> sendMessage(
        com.example.grpcdemo.MessageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_MESSAGE = 0;

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
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((com.example.grpcdemo.MessageRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpcdemo.MessageResponse>) responseObserver);
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
          getSendMessageMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpcdemo.MessageRequest,
              com.example.grpcdemo.MessageResponse>(
                service, METHODID_SEND_MESSAGE)))
        .build();
  }

  private static abstract class UnaryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UnaryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpcdemo.UnaryServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UnaryService");
    }
  }

  private static final class UnaryServiceFileDescriptorSupplier
      extends UnaryServiceBaseDescriptorSupplier {
    UnaryServiceFileDescriptorSupplier() {}
  }

  private static final class UnaryServiceMethodDescriptorSupplier
      extends UnaryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UnaryServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UnaryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UnaryServiceFileDescriptorSupplier())
              .addMethod(getSendMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
