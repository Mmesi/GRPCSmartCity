package ds.applicationoptimization;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 *Service Definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: applicationoptimization.proto")
public final class ApplicationOptimizationGrpc {

  private ApplicationOptimizationGrpc() {}

  public static final String SERVICE_NAME = "ApplicationOptimization.ApplicationOptimization";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.applicationoptimization.SetApplianceModeRequest,
      ds.applicationoptimization.SetApplianceModeResponse> getSetApplianceModeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetApplianceMode",
      requestType = ds.applicationoptimization.SetApplianceModeRequest.class,
      responseType = ds.applicationoptimization.SetApplianceModeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.applicationoptimization.SetApplianceModeRequest,
      ds.applicationoptimization.SetApplianceModeResponse> getSetApplianceModeMethod() {
    io.grpc.MethodDescriptor<ds.applicationoptimization.SetApplianceModeRequest, ds.applicationoptimization.SetApplianceModeResponse> getSetApplianceModeMethod;
    if ((getSetApplianceModeMethod = ApplicationOptimizationGrpc.getSetApplianceModeMethod) == null) {
      synchronized (ApplicationOptimizationGrpc.class) {
        if ((getSetApplianceModeMethod = ApplicationOptimizationGrpc.getSetApplianceModeMethod) == null) {
          ApplicationOptimizationGrpc.getSetApplianceModeMethod = getSetApplianceModeMethod = 
              io.grpc.MethodDescriptor.<ds.applicationoptimization.SetApplianceModeRequest, ds.applicationoptimization.SetApplianceModeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ApplicationOptimization.ApplicationOptimization", "SetApplianceMode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.applicationoptimization.SetApplianceModeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.applicationoptimization.SetApplianceModeResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ApplicationOptimizationMethodDescriptorSupplier("SetApplianceMode"))
                  .build();
          }
        }
     }
     return getSetApplianceModeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.applicationoptimization.SetApplianceLimitRequest,
      ds.applicationoptimization.SetApplianceLimitResponse> getSetApplianceLimitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetApplianceLimit",
      requestType = ds.applicationoptimization.SetApplianceLimitRequest.class,
      responseType = ds.applicationoptimization.SetApplianceLimitResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.applicationoptimization.SetApplianceLimitRequest,
      ds.applicationoptimization.SetApplianceLimitResponse> getSetApplianceLimitMethod() {
    io.grpc.MethodDescriptor<ds.applicationoptimization.SetApplianceLimitRequest, ds.applicationoptimization.SetApplianceLimitResponse> getSetApplianceLimitMethod;
    if ((getSetApplianceLimitMethod = ApplicationOptimizationGrpc.getSetApplianceLimitMethod) == null) {
      synchronized (ApplicationOptimizationGrpc.class) {
        if ((getSetApplianceLimitMethod = ApplicationOptimizationGrpc.getSetApplianceLimitMethod) == null) {
          ApplicationOptimizationGrpc.getSetApplianceLimitMethod = getSetApplianceLimitMethod = 
              io.grpc.MethodDescriptor.<ds.applicationoptimization.SetApplianceLimitRequest, ds.applicationoptimization.SetApplianceLimitResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ApplicationOptimization.ApplicationOptimization", "SetApplianceLimit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.applicationoptimization.SetApplianceLimitRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.applicationoptimization.SetApplianceLimitResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ApplicationOptimizationMethodDescriptorSupplier("SetApplianceLimit"))
                  .build();
          }
        }
     }
     return getSetApplianceLimitMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.applicationoptimization.SetApplianceScheduleRequest,
      ds.applicationoptimization.SetApplianceScheduleResponse> getSetApplianceScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetApplianceSchedule",
      requestType = ds.applicationoptimization.SetApplianceScheduleRequest.class,
      responseType = ds.applicationoptimization.SetApplianceScheduleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.applicationoptimization.SetApplianceScheduleRequest,
      ds.applicationoptimization.SetApplianceScheduleResponse> getSetApplianceScheduleMethod() {
    io.grpc.MethodDescriptor<ds.applicationoptimization.SetApplianceScheduleRequest, ds.applicationoptimization.SetApplianceScheduleResponse> getSetApplianceScheduleMethod;
    if ((getSetApplianceScheduleMethod = ApplicationOptimizationGrpc.getSetApplianceScheduleMethod) == null) {
      synchronized (ApplicationOptimizationGrpc.class) {
        if ((getSetApplianceScheduleMethod = ApplicationOptimizationGrpc.getSetApplianceScheduleMethod) == null) {
          ApplicationOptimizationGrpc.getSetApplianceScheduleMethod = getSetApplianceScheduleMethod = 
              io.grpc.MethodDescriptor.<ds.applicationoptimization.SetApplianceScheduleRequest, ds.applicationoptimization.SetApplianceScheduleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ApplicationOptimization.ApplicationOptimization", "SetApplianceSchedule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.applicationoptimization.SetApplianceScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.applicationoptimization.SetApplianceScheduleResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ApplicationOptimizationMethodDescriptorSupplier("SetApplianceSchedule"))
                  .build();
          }
        }
     }
     return getSetApplianceScheduleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ApplicationOptimizationStub newStub(io.grpc.Channel channel) {
    return new ApplicationOptimizationStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ApplicationOptimizationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ApplicationOptimizationBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ApplicationOptimizationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ApplicationOptimizationFutureStub(channel);
  }

  /**
   * <pre>
   *Service Definition
   * </pre>
   */
  public static abstract class ApplicationOptimizationImplBase implements io.grpc.BindableService {

    /**
     */
    public void setApplianceMode(ds.applicationoptimization.SetApplianceModeRequest request,
        io.grpc.stub.StreamObserver<ds.applicationoptimization.SetApplianceModeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetApplianceModeMethod(), responseObserver);
    }

    /**
     */
    public void setApplianceLimit(ds.applicationoptimization.SetApplianceLimitRequest request,
        io.grpc.stub.StreamObserver<ds.applicationoptimization.SetApplianceLimitResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetApplianceLimitMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.applicationoptimization.SetApplianceScheduleRequest> setApplianceSchedule(
        io.grpc.stub.StreamObserver<ds.applicationoptimization.SetApplianceScheduleResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSetApplianceScheduleMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetApplianceModeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.applicationoptimization.SetApplianceModeRequest,
                ds.applicationoptimization.SetApplianceModeResponse>(
                  this, METHODID_SET_APPLIANCE_MODE)))
          .addMethod(
            getSetApplianceLimitMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.applicationoptimization.SetApplianceLimitRequest,
                ds.applicationoptimization.SetApplianceLimitResponse>(
                  this, METHODID_SET_APPLIANCE_LIMIT)))
          .addMethod(
            getSetApplianceScheduleMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.applicationoptimization.SetApplianceScheduleRequest,
                ds.applicationoptimization.SetApplianceScheduleResponse>(
                  this, METHODID_SET_APPLIANCE_SCHEDULE)))
          .build();
    }
  }

  /**
   * <pre>
   *Service Definition
   * </pre>
   */
  public static final class ApplicationOptimizationStub extends io.grpc.stub.AbstractStub<ApplicationOptimizationStub> {
    private ApplicationOptimizationStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ApplicationOptimizationStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApplicationOptimizationStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ApplicationOptimizationStub(channel, callOptions);
    }

    /**
     */
    public void setApplianceMode(ds.applicationoptimization.SetApplianceModeRequest request,
        io.grpc.stub.StreamObserver<ds.applicationoptimization.SetApplianceModeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetApplianceModeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setApplianceLimit(ds.applicationoptimization.SetApplianceLimitRequest request,
        io.grpc.stub.StreamObserver<ds.applicationoptimization.SetApplianceLimitResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetApplianceLimitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.applicationoptimization.SetApplianceScheduleRequest> setApplianceSchedule(
        io.grpc.stub.StreamObserver<ds.applicationoptimization.SetApplianceScheduleResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSetApplianceScheduleMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *Service Definition
   * </pre>
   */
  public static final class ApplicationOptimizationBlockingStub extends io.grpc.stub.AbstractStub<ApplicationOptimizationBlockingStub> {
    private ApplicationOptimizationBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ApplicationOptimizationBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApplicationOptimizationBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ApplicationOptimizationBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.applicationoptimization.SetApplianceModeResponse setApplianceMode(ds.applicationoptimization.SetApplianceModeRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetApplianceModeMethod(), getCallOptions(), request);
    }

    /**
     */
    public ds.applicationoptimization.SetApplianceLimitResponse setApplianceLimit(ds.applicationoptimization.SetApplianceLimitRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetApplianceLimitMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *Service Definition
   * </pre>
   */
  public static final class ApplicationOptimizationFutureStub extends io.grpc.stub.AbstractStub<ApplicationOptimizationFutureStub> {
    private ApplicationOptimizationFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ApplicationOptimizationFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApplicationOptimizationFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ApplicationOptimizationFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.applicationoptimization.SetApplianceModeResponse> setApplianceMode(
        ds.applicationoptimization.SetApplianceModeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetApplianceModeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.applicationoptimization.SetApplianceLimitResponse> setApplianceLimit(
        ds.applicationoptimization.SetApplianceLimitRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetApplianceLimitMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_APPLIANCE_MODE = 0;
  private static final int METHODID_SET_APPLIANCE_LIMIT = 1;
  private static final int METHODID_SET_APPLIANCE_SCHEDULE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ApplicationOptimizationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ApplicationOptimizationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_APPLIANCE_MODE:
          serviceImpl.setApplianceMode((ds.applicationoptimization.SetApplianceModeRequest) request,
              (io.grpc.stub.StreamObserver<ds.applicationoptimization.SetApplianceModeResponse>) responseObserver);
          break;
        case METHODID_SET_APPLIANCE_LIMIT:
          serviceImpl.setApplianceLimit((ds.applicationoptimization.SetApplianceLimitRequest) request,
              (io.grpc.stub.StreamObserver<ds.applicationoptimization.SetApplianceLimitResponse>) responseObserver);
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
        case METHODID_SET_APPLIANCE_SCHEDULE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.setApplianceSchedule(
              (io.grpc.stub.StreamObserver<ds.applicationoptimization.SetApplianceScheduleResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ApplicationOptimizationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ApplicationOptimizationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.applicationoptimization.ApplicationOptimizationImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ApplicationOptimization");
    }
  }

  private static final class ApplicationOptimizationFileDescriptorSupplier
      extends ApplicationOptimizationBaseDescriptorSupplier {
    ApplicationOptimizationFileDescriptorSupplier() {}
  }

  private static final class ApplicationOptimizationMethodDescriptorSupplier
      extends ApplicationOptimizationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ApplicationOptimizationMethodDescriptorSupplier(String methodName) {
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
      synchronized (ApplicationOptimizationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ApplicationOptimizationFileDescriptorSupplier())
              .addMethod(getSetApplianceModeMethod())
              .addMethod(getSetApplianceLimitMethod())
              .addMethod(getSetApplianceScheduleMethod())
              .build();
        }
      }
    }
    return result;
  }
}
