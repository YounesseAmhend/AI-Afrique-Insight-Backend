package source;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: source.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SourceServiceGrpc {

  private SourceServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "source.SourceService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<source.SourceProto.SourceRequest,
      source.SourceProto.SourceResponse> getAddSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addSource",
      requestType = source.SourceProto.SourceRequest.class,
      responseType = source.SourceProto.SourceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<source.SourceProto.SourceRequest,
      source.SourceProto.SourceResponse> getAddSourceMethod() {
    io.grpc.MethodDescriptor<source.SourceProto.SourceRequest, source.SourceProto.SourceResponse> getAddSourceMethod;
    if ((getAddSourceMethod = SourceServiceGrpc.getAddSourceMethod) == null) {
      synchronized (SourceServiceGrpc.class) {
        if ((getAddSourceMethod = SourceServiceGrpc.getAddSourceMethod) == null) {
          SourceServiceGrpc.getAddSourceMethod = getAddSourceMethod =
              io.grpc.MethodDescriptor.<source.SourceProto.SourceRequest, source.SourceProto.SourceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addSource"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  source.SourceProto.SourceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  source.SourceProto.SourceResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SourceServiceMethodDescriptorSupplier("addSource"))
              .build();
        }
      }
    }
    return getAddSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<source.SourceProto.ScrapeRequest,
      source.SourceProto.ScrapeResponse> getScrapeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "scrape",
      requestType = source.SourceProto.ScrapeRequest.class,
      responseType = source.SourceProto.ScrapeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<source.SourceProto.ScrapeRequest,
      source.SourceProto.ScrapeResponse> getScrapeMethod() {
    io.grpc.MethodDescriptor<source.SourceProto.ScrapeRequest, source.SourceProto.ScrapeResponse> getScrapeMethod;
    if ((getScrapeMethod = SourceServiceGrpc.getScrapeMethod) == null) {
      synchronized (SourceServiceGrpc.class) {
        if ((getScrapeMethod = SourceServiceGrpc.getScrapeMethod) == null) {
          SourceServiceGrpc.getScrapeMethod = getScrapeMethod =
              io.grpc.MethodDescriptor.<source.SourceProto.ScrapeRequest, source.SourceProto.ScrapeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "scrape"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  source.SourceProto.ScrapeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  source.SourceProto.ScrapeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SourceServiceMethodDescriptorSupplier("scrape"))
              .build();
        }
      }
    }
    return getScrapeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SourceServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SourceServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SourceServiceStub>() {
        @java.lang.Override
        public SourceServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SourceServiceStub(channel, callOptions);
        }
      };
    return SourceServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SourceServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SourceServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SourceServiceBlockingStub>() {
        @java.lang.Override
        public SourceServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SourceServiceBlockingStub(channel, callOptions);
        }
      };
    return SourceServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SourceServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SourceServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SourceServiceFutureStub>() {
        @java.lang.Override
        public SourceServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SourceServiceFutureStub(channel, callOptions);
        }
      };
    return SourceServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void addSource(source.SourceProto.SourceRequest request,
        io.grpc.stub.StreamObserver<source.SourceProto.SourceResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddSourceMethod(), responseObserver);
    }

    /**
     */
    default void scrape(source.SourceProto.ScrapeRequest request,
        io.grpc.stub.StreamObserver<source.SourceProto.ScrapeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getScrapeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SourceService.
   */
  public static abstract class SourceServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SourceServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SourceService.
   */
  public static final class SourceServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SourceServiceStub> {
    private SourceServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SourceServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SourceServiceStub(channel, callOptions);
    }

    /**
     */
    public void addSource(source.SourceProto.SourceRequest request,
        io.grpc.stub.StreamObserver<source.SourceProto.SourceResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddSourceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void scrape(source.SourceProto.ScrapeRequest request,
        io.grpc.stub.StreamObserver<source.SourceProto.ScrapeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getScrapeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SourceService.
   */
  public static final class SourceServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SourceServiceBlockingStub> {
    private SourceServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SourceServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SourceServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public source.SourceProto.SourceResponse addSource(source.SourceProto.SourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddSourceMethod(), getCallOptions(), request);
    }

    /**
     */
    public source.SourceProto.ScrapeResponse scrape(source.SourceProto.ScrapeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getScrapeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SourceService.
   */
  public static final class SourceServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SourceServiceFutureStub> {
    private SourceServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SourceServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SourceServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<source.SourceProto.SourceResponse> addSource(
        source.SourceProto.SourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddSourceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<source.SourceProto.ScrapeResponse> scrape(
        source.SourceProto.ScrapeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getScrapeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_SOURCE = 0;
  private static final int METHODID_SCRAPE = 1;

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
        case METHODID_ADD_SOURCE:
          serviceImpl.addSource((source.SourceProto.SourceRequest) request,
              (io.grpc.stub.StreamObserver<source.SourceProto.SourceResponse>) responseObserver);
          break;
        case METHODID_SCRAPE:
          serviceImpl.scrape((source.SourceProto.ScrapeRequest) request,
              (io.grpc.stub.StreamObserver<source.SourceProto.ScrapeResponse>) responseObserver);
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
          getAddSourceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              source.SourceProto.SourceRequest,
              source.SourceProto.SourceResponse>(
                service, METHODID_ADD_SOURCE)))
        .addMethod(
          getScrapeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              source.SourceProto.ScrapeRequest,
              source.SourceProto.ScrapeResponse>(
                service, METHODID_SCRAPE)))
        .build();
  }

  private static abstract class SourceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SourceServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return source.SourceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SourceService");
    }
  }

  private static final class SourceServiceFileDescriptorSupplier
      extends SourceServiceBaseDescriptorSupplier {
    SourceServiceFileDescriptorSupplier() {}
  }

  private static final class SourceServiceMethodDescriptorSupplier
      extends SourceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SourceServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SourceServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SourceServiceFileDescriptorSupplier())
              .addMethod(getAddSourceMethod())
              .addMethod(getScrapeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
