package pubsub;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: pubsub.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PubSubServiceGrpc {

  private PubSubServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "pubsub.PubSubService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<pubsub.GetTopicRequest,
      pubsub.GetTopicResponse> getGetTopicMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTopic",
      requestType = pubsub.GetTopicRequest.class,
      responseType = pubsub.GetTopicResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pubsub.GetTopicRequest,
      pubsub.GetTopicResponse> getGetTopicMethod() {
    io.grpc.MethodDescriptor<pubsub.GetTopicRequest, pubsub.GetTopicResponse> getGetTopicMethod;
    if ((getGetTopicMethod = PubSubServiceGrpc.getGetTopicMethod) == null) {
      synchronized (PubSubServiceGrpc.class) {
        if ((getGetTopicMethod = PubSubServiceGrpc.getGetTopicMethod) == null) {
          PubSubServiceGrpc.getGetTopicMethod = getGetTopicMethod =
              io.grpc.MethodDescriptor.<pubsub.GetTopicRequest, pubsub.GetTopicResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTopic"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pubsub.GetTopicRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pubsub.GetTopicResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PubSubServiceMethodDescriptorSupplier("GetTopic"))
              .build();
        }
      }
    }
    return getGetTopicMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PubSubServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PubSubServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PubSubServiceStub>() {
        @java.lang.Override
        public PubSubServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PubSubServiceStub(channel, callOptions);
        }
      };
    return PubSubServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PubSubServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PubSubServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PubSubServiceBlockingStub>() {
        @java.lang.Override
        public PubSubServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PubSubServiceBlockingStub(channel, callOptions);
        }
      };
    return PubSubServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PubSubServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PubSubServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PubSubServiceFutureStub>() {
        @java.lang.Override
        public PubSubServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PubSubServiceFutureStub(channel, callOptions);
        }
      };
    return PubSubServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getTopic(pubsub.GetTopicRequest request,
        io.grpc.stub.StreamObserver<pubsub.GetTopicResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTopicMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PubSubService.
   */
  public static abstract class PubSubServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PubSubServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PubSubService.
   */
  public static final class PubSubServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PubSubServiceStub> {
    private PubSubServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PubSubServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PubSubServiceStub(channel, callOptions);
    }

    /**
     */
    public void getTopic(pubsub.GetTopicRequest request,
        io.grpc.stub.StreamObserver<pubsub.GetTopicResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTopicMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PubSubService.
   */
  public static final class PubSubServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PubSubServiceBlockingStub> {
    private PubSubServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PubSubServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PubSubServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public pubsub.GetTopicResponse getTopic(pubsub.GetTopicRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTopicMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PubSubService.
   */
  public static final class PubSubServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PubSubServiceFutureStub> {
    private PubSubServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PubSubServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PubSubServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pubsub.GetTopicResponse> getTopic(
        pubsub.GetTopicRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTopicMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TOPIC = 0;

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
        case METHODID_GET_TOPIC:
          serviceImpl.getTopic((pubsub.GetTopicRequest) request,
              (io.grpc.stub.StreamObserver<pubsub.GetTopicResponse>) responseObserver);
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
          getGetTopicMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              pubsub.GetTopicRequest,
              pubsub.GetTopicResponse>(
                service, METHODID_GET_TOPIC)))
        .build();
  }

  private static abstract class PubSubServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PubSubServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return pubsub.Pubsub.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PubSubService");
    }
  }

  private static final class PubSubServiceFileDescriptorSupplier
      extends PubSubServiceBaseDescriptorSupplier {
    PubSubServiceFileDescriptorSupplier() {}
  }

  private static final class PubSubServiceMethodDescriptorSupplier
      extends PubSubServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PubSubServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PubSubServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PubSubServiceFileDescriptorSupplier())
              .addMethod(getGetTopicMethod())
              .build();
        }
      }
    }
    return result;
  }
}
