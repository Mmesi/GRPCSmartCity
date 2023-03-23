package ds.lightingsystem;

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
    comments = "Source: lightingsystem.proto")
public final class LightingSystemGrpc {

  private LightingSystemGrpc() {}

  public static final String SERVICE_NAME = "LightingSystem.LightingSystem";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.lightingsystem.SetLightLevelsRequest,
      ds.lightingsystem.SetLightLevelsResponse> getSetLightLevelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetLightLevels",
      requestType = ds.lightingsystem.SetLightLevelsRequest.class,
      responseType = ds.lightingsystem.SetLightLevelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.lightingsystem.SetLightLevelsRequest,
      ds.lightingsystem.SetLightLevelsResponse> getSetLightLevelsMethod() {
    io.grpc.MethodDescriptor<ds.lightingsystem.SetLightLevelsRequest, ds.lightingsystem.SetLightLevelsResponse> getSetLightLevelsMethod;
    if ((getSetLightLevelsMethod = LightingSystemGrpc.getSetLightLevelsMethod) == null) {
      synchronized (LightingSystemGrpc.class) {
        if ((getSetLightLevelsMethod = LightingSystemGrpc.getSetLightLevelsMethod) == null) {
          LightingSystemGrpc.getSetLightLevelsMethod = getSetLightLevelsMethod = 
              io.grpc.MethodDescriptor.<ds.lightingsystem.SetLightLevelsRequest, ds.lightingsystem.SetLightLevelsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "LightingSystem.LightingSystem", "SetLightLevels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.lightingsystem.SetLightLevelsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.lightingsystem.SetLightLevelsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightingSystemMethodDescriptorSupplier("SetLightLevels"))
                  .build();
          }
        }
     }
     return getSetLightLevelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.lightingsystem.SwitchLightRequest,
      ds.lightingsystem.SwitchLightResponse> getSwitchLightMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SwitchLight",
      requestType = ds.lightingsystem.SwitchLightRequest.class,
      responseType = ds.lightingsystem.SwitchLightResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.lightingsystem.SwitchLightRequest,
      ds.lightingsystem.SwitchLightResponse> getSwitchLightMethod() {
    io.grpc.MethodDescriptor<ds.lightingsystem.SwitchLightRequest, ds.lightingsystem.SwitchLightResponse> getSwitchLightMethod;
    if ((getSwitchLightMethod = LightingSystemGrpc.getSwitchLightMethod) == null) {
      synchronized (LightingSystemGrpc.class) {
        if ((getSwitchLightMethod = LightingSystemGrpc.getSwitchLightMethod) == null) {
          LightingSystemGrpc.getSwitchLightMethod = getSwitchLightMethod = 
              io.grpc.MethodDescriptor.<ds.lightingsystem.SwitchLightRequest, ds.lightingsystem.SwitchLightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "LightingSystem.LightingSystem", "SwitchLight"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.lightingsystem.SwitchLightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.lightingsystem.SwitchLightResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightingSystemMethodDescriptorSupplier("SwitchLight"))
                  .build();
          }
        }
     }
     return getSwitchLightMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.lightingsystem.SetLightScheduleRequest,
      ds.lightingsystem.SetLightScheduleResponse> getSetLightScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetLightSchedule",
      requestType = ds.lightingsystem.SetLightScheduleRequest.class,
      responseType = ds.lightingsystem.SetLightScheduleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.lightingsystem.SetLightScheduleRequest,
      ds.lightingsystem.SetLightScheduleResponse> getSetLightScheduleMethod() {
    io.grpc.MethodDescriptor<ds.lightingsystem.SetLightScheduleRequest, ds.lightingsystem.SetLightScheduleResponse> getSetLightScheduleMethod;
    if ((getSetLightScheduleMethod = LightingSystemGrpc.getSetLightScheduleMethod) == null) {
      synchronized (LightingSystemGrpc.class) {
        if ((getSetLightScheduleMethod = LightingSystemGrpc.getSetLightScheduleMethod) == null) {
          LightingSystemGrpc.getSetLightScheduleMethod = getSetLightScheduleMethod = 
              io.grpc.MethodDescriptor.<ds.lightingsystem.SetLightScheduleRequest, ds.lightingsystem.SetLightScheduleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "LightingSystem.LightingSystem", "SetLightSchedule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.lightingsystem.SetLightScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.lightingsystem.SetLightScheduleResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightingSystemMethodDescriptorSupplier("SetLightSchedule"))
                  .build();
          }
        }
     }
     return getSetLightScheduleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightingSystemStub newStub(io.grpc.Channel channel) {
    return new LightingSystemStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LightingSystemBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LightingSystemBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LightingSystemFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LightingSystemFutureStub(channel);
  }

  /**
   * <pre>
   *Service Definition
   * </pre>
   */
  public static abstract class LightingSystemImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<ds.lightingsystem.SetLightLevelsRequest> setLightLevels(
        io.grpc.stub.StreamObserver<ds.lightingsystem.SetLightLevelsResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSetLightLevelsMethod(), responseObserver);
    }

    /**
     */
    public void switchLight(ds.lightingsystem.SwitchLightRequest request,
        io.grpc.stub.StreamObserver<ds.lightingsystem.SwitchLightResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSwitchLightMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.lightingsystem.SetLightScheduleRequest> setLightSchedule(
        io.grpc.stub.StreamObserver<ds.lightingsystem.SetLightScheduleResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSetLightScheduleMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetLightLevelsMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.lightingsystem.SetLightLevelsRequest,
                ds.lightingsystem.SetLightLevelsResponse>(
                  this, METHODID_SET_LIGHT_LEVELS)))
          .addMethod(
            getSwitchLightMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.lightingsystem.SwitchLightRequest,
                ds.lightingsystem.SwitchLightResponse>(
                  this, METHODID_SWITCH_LIGHT)))
          .addMethod(
            getSetLightScheduleMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.lightingsystem.SetLightScheduleRequest,
                ds.lightingsystem.SetLightScheduleResponse>(
                  this, METHODID_SET_LIGHT_SCHEDULE)))
          .build();
    }
  }

  /**
   * <pre>
   *Service Definition
   * </pre>
   */
  public static final class LightingSystemStub extends io.grpc.stub.AbstractStub<LightingSystemStub> {
    private LightingSystemStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightingSystemStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightingSystemStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightingSystemStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.lightingsystem.SetLightLevelsRequest> setLightLevels(
        io.grpc.stub.StreamObserver<ds.lightingsystem.SetLightLevelsResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getSetLightLevelsMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void switchLight(ds.lightingsystem.SwitchLightRequest request,
        io.grpc.stub.StreamObserver<ds.lightingsystem.SwitchLightResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSwitchLightMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.lightingsystem.SetLightScheduleRequest> setLightSchedule(
        io.grpc.stub.StreamObserver<ds.lightingsystem.SetLightScheduleResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getSetLightScheduleMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *Service Definition
   * </pre>
   */
  public static final class LightingSystemBlockingStub extends io.grpc.stub.AbstractStub<LightingSystemBlockingStub> {
    private LightingSystemBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightingSystemBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightingSystemBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightingSystemBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.lightingsystem.SwitchLightResponse switchLight(ds.lightingsystem.SwitchLightRequest request) {
      return blockingUnaryCall(
          getChannel(), getSwitchLightMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *Service Definition
   * </pre>
   */
  public static final class LightingSystemFutureStub extends io.grpc.stub.AbstractStub<LightingSystemFutureStub> {
    private LightingSystemFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightingSystemFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightingSystemFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightingSystemFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.lightingsystem.SwitchLightResponse> switchLight(
        ds.lightingsystem.SwitchLightRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSwitchLightMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SWITCH_LIGHT = 0;
  private static final int METHODID_SET_LIGHT_LEVELS = 1;
  private static final int METHODID_SET_LIGHT_SCHEDULE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LightingSystemImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LightingSystemImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SWITCH_LIGHT:
          serviceImpl.switchLight((ds.lightingsystem.SwitchLightRequest) request,
              (io.grpc.stub.StreamObserver<ds.lightingsystem.SwitchLightResponse>) responseObserver);
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
        case METHODID_SET_LIGHT_LEVELS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.setLightLevels(
              (io.grpc.stub.StreamObserver<ds.lightingsystem.SetLightLevelsResponse>) responseObserver);
        case METHODID_SET_LIGHT_SCHEDULE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.setLightSchedule(
              (io.grpc.stub.StreamObserver<ds.lightingsystem.SetLightScheduleResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LightingSystemBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightingSystemBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.lightingsystem.LightingSystemImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LightingSystem");
    }
  }

  private static final class LightingSystemFileDescriptorSupplier
      extends LightingSystemBaseDescriptorSupplier {
    LightingSystemFileDescriptorSupplier() {}
  }

  private static final class LightingSystemMethodDescriptorSupplier
      extends LightingSystemBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LightingSystemMethodDescriptorSupplier(String methodName) {
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
      synchronized (LightingSystemGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LightingSystemFileDescriptorSupplier())
              .addMethod(getSetLightLevelsMethod())
              .addMethod(getSwitchLightMethod())
              .addMethod(getSetLightScheduleMethod())
              .build();
        }
      }
    }
    return result;
  }
}
