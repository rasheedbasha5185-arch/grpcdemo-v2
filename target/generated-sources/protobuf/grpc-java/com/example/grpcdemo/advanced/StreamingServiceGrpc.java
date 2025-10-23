package com.example.grpcdemo.advanced;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: advanced.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class StreamingServiceGrpc {

  private StreamingServiceGrpc() {}

  public static final String SERVICE_NAME = "StreamingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpcdemo.advanced.StreamRequest,
      com.example.grpcdemo.advanced.StreamResponse> getServerStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ServerStream",
      requestType = com.example.grpcdemo.advanced.StreamRequest.class,
      responseType = com.example.grpcdemo.advanced.StreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpcdemo.advanced.StreamRequest,
      com.example.grpcdemo.advanced.StreamResponse> getServerStreamMethod() {
    io.grpc.MethodDescriptor<com.example.grpcdemo.advanced.StreamRequest, com.example.grpcdemo.advanced.StreamResponse> getServerStreamMethod;
    if ((getServerStreamMethod = StreamingServiceGrpc.getServerStreamMethod) == null) {
      synchronized (StreamingServiceGrpc.class) {
        if ((getServerStreamMethod = StreamingServiceGrpc.getServerStreamMethod) == null) {
          StreamingServiceGrpc.getServerStreamMethod = getServerStreamMethod =
              io.grpc.MethodDescriptor.<com.example.grpcdemo.advanced.StreamRequest, com.example.grpcdemo.advanced.StreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ServerStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcdemo.advanced.StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcdemo.advanced.StreamResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StreamingServiceMethodDescriptorSupplier("ServerStream"))
              .build();
        }
      }
    }
    return getServerStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpcdemo.advanced.StreamRequest,
      com.example.grpcdemo.advanced.StreamResponse> getClientStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ClientStream",
      requestType = com.example.grpcdemo.advanced.StreamRequest.class,
      responseType = com.example.grpcdemo.advanced.StreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpcdemo.advanced.StreamRequest,
      com.example.grpcdemo.advanced.StreamResponse> getClientStreamMethod() {
    io.grpc.MethodDescriptor<com.example.grpcdemo.advanced.StreamRequest, com.example.grpcdemo.advanced.StreamResponse> getClientStreamMethod;
    if ((getClientStreamMethod = StreamingServiceGrpc.getClientStreamMethod) == null) {
      synchronized (StreamingServiceGrpc.class) {
        if ((getClientStreamMethod = StreamingServiceGrpc.getClientStreamMethod) == null) {
          StreamingServiceGrpc.getClientStreamMethod = getClientStreamMethod =
              io.grpc.MethodDescriptor.<com.example.grpcdemo.advanced.StreamRequest, com.example.grpcdemo.advanced.StreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ClientStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcdemo.advanced.StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcdemo.advanced.StreamResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StreamingServiceMethodDescriptorSupplier("ClientStream"))
              .build();
        }
      }
    }
    return getClientStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpcdemo.advanced.StreamRequest,
      com.example.grpcdemo.advanced.StreamResponse> getBiDiStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BiDiStream",
      requestType = com.example.grpcdemo.advanced.StreamRequest.class,
      responseType = com.example.grpcdemo.advanced.StreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpcdemo.advanced.StreamRequest,
      com.example.grpcdemo.advanced.StreamResponse> getBiDiStreamMethod() {
    io.grpc.MethodDescriptor<com.example.grpcdemo.advanced.StreamRequest, com.example.grpcdemo.advanced.StreamResponse> getBiDiStreamMethod;
    if ((getBiDiStreamMethod = StreamingServiceGrpc.getBiDiStreamMethod) == null) {
      synchronized (StreamingServiceGrpc.class) {
        if ((getBiDiStreamMethod = StreamingServiceGrpc.getBiDiStreamMethod) == null) {
          StreamingServiceGrpc.getBiDiStreamMethod = getBiDiStreamMethod =
              io.grpc.MethodDescriptor.<com.example.grpcdemo.advanced.StreamRequest, com.example.grpcdemo.advanced.StreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BiDiStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcdemo.advanced.StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpcdemo.advanced.StreamResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StreamingServiceMethodDescriptorSupplier("BiDiStream"))
              .build();
        }
      }
    }
    return getBiDiStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StreamingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StreamingServiceStub>() {
        @java.lang.Override
        public StreamingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StreamingServiceStub(channel, callOptions);
        }
      };
    return StreamingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StreamingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StreamingServiceBlockingStub>() {
        @java.lang.Override
        public StreamingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StreamingServiceBlockingStub(channel, callOptions);
        }
      };
    return StreamingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StreamingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StreamingServiceFutureStub>() {
        @java.lang.Override
        public StreamingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StreamingServiceFutureStub(channel, callOptions);
        }
      };
    return StreamingServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void serverStream(com.example.grpcdemo.advanced.StreamRequest request,
        io.grpc.stub.StreamObserver<com.example.grpcdemo.advanced.StreamResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getServerStreamMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<com.example.grpcdemo.advanced.StreamRequest> clientStream(
        io.grpc.stub.StreamObserver<com.example.grpcdemo.advanced.StreamResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getClientStreamMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<com.example.grpcdemo.advanced.StreamRequest> biDiStream(
        io.grpc.stub.StreamObserver<com.example.grpcdemo.advanced.StreamResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getBiDiStreamMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service StreamingService.
   */
  public static abstract class StreamingServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return StreamingServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service StreamingService.
   */
  public static final class StreamingServiceStub
      extends io.grpc.stub.AbstractAsyncStub<StreamingServiceStub> {
    private StreamingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamingServiceStub(channel, callOptions);
    }

    /**
     */
    public void serverStream(com.example.grpcdemo.advanced.StreamRequest request,
        io.grpc.stub.StreamObserver<com.example.grpcdemo.advanced.StreamResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getServerStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.grpcdemo.advanced.StreamRequest> clientStream(
        io.grpc.stub.StreamObserver<com.example.grpcdemo.advanced.StreamResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getClientStreamMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.grpcdemo.advanced.StreamRequest> biDiStream(
        io.grpc.stub.StreamObserver<com.example.grpcdemo.advanced.StreamResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getBiDiStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service StreamingService.
   */
  public static final class StreamingServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<StreamingServiceBlockingStub> {
    private StreamingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.example.grpcdemo.advanced.StreamResponse> serverStream(
        com.example.grpcdemo.advanced.StreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getServerStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service StreamingService.
   */
  public static final class StreamingServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<StreamingServiceFutureStub> {
    private StreamingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamingServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SERVER_STREAM = 0;
  private static final int METHODID_CLIENT_STREAM = 1;
  private static final int METHODID_BI_DI_STREAM = 2;

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
        case METHODID_SERVER_STREAM:
          serviceImpl.serverStream((com.example.grpcdemo.advanced.StreamRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpcdemo.advanced.StreamResponse>) responseObserver);
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
        case METHODID_CLIENT_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.clientStream(
              (io.grpc.stub.StreamObserver<com.example.grpcdemo.advanced.StreamResponse>) responseObserver);
        case METHODID_BI_DI_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.biDiStream(
              (io.grpc.stub.StreamObserver<com.example.grpcdemo.advanced.StreamResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getServerStreamMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.example.grpcdemo.advanced.StreamRequest,
              com.example.grpcdemo.advanced.StreamResponse>(
                service, METHODID_SERVER_STREAM)))
        .addMethod(
          getClientStreamMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.example.grpcdemo.advanced.StreamRequest,
              com.example.grpcdemo.advanced.StreamResponse>(
                service, METHODID_CLIENT_STREAM)))
        .addMethod(
          getBiDiStreamMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.example.grpcdemo.advanced.StreamRequest,
              com.example.grpcdemo.advanced.StreamResponse>(
                service, METHODID_BI_DI_STREAM)))
        .build();
  }

  private static abstract class StreamingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StreamingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpcdemo.advanced.AdvancedProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StreamingService");
    }
  }

  private static final class StreamingServiceFileDescriptorSupplier
      extends StreamingServiceBaseDescriptorSupplier {
    StreamingServiceFileDescriptorSupplier() {}
  }

  private static final class StreamingServiceMethodDescriptorSupplier
      extends StreamingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StreamingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (StreamingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StreamingServiceFileDescriptorSupplier())
              .addMethod(getServerStreamMethod())
              .addMethod(getClientStreamMethod())
              .addMethod(getBiDiStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
