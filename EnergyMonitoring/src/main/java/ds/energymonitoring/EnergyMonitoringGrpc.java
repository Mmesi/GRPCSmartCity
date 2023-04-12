package ds.energymonitoring;

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
    comments = "Source: energymonitoring.proto")
public final class EnergyMonitoringGrpc {

  private EnergyMonitoringGrpc() {}

  public static final String SERVICE_NAME = "EnergyMonitoring.EnergyMonitoring";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.energymonitoring.GetEnergyUsageRequest,
      ds.energymonitoring.GetEnergyUsageResponse> getGetEnergyUsageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEnergyUsage",
      requestType = ds.energymonitoring.GetEnergyUsageRequest.class,
      responseType = ds.energymonitoring.GetEnergyUsageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.energymonitoring.GetEnergyUsageRequest,
      ds.energymonitoring.GetEnergyUsageResponse> getGetEnergyUsageMethod() {
    io.grpc.MethodDescriptor<ds.energymonitoring.GetEnergyUsageRequest, ds.energymonitoring.GetEnergyUsageResponse> getGetEnergyUsageMethod;
    if ((getGetEnergyUsageMethod = EnergyMonitoringGrpc.getGetEnergyUsageMethod) == null) {
      synchronized (EnergyMonitoringGrpc.class) {
        if ((getGetEnergyUsageMethod = EnergyMonitoringGrpc.getGetEnergyUsageMethod) == null) {
          EnergyMonitoringGrpc.getGetEnergyUsageMethod = getGetEnergyUsageMethod = 
              io.grpc.MethodDescriptor.<ds.energymonitoring.GetEnergyUsageRequest, ds.energymonitoring.GetEnergyUsageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "EnergyMonitoring.EnergyMonitoring", "GetEnergyUsage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.energymonitoring.GetEnergyUsageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.energymonitoring.GetEnergyUsageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EnergyMonitoringMethodDescriptorSupplier("GetEnergyUsage"))
                  .build();
          }
        }
     }
     return getGetEnergyUsageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.energymonitoring.UsageBySourceRequest,
      ds.energymonitoring.UsageBySourceResponse> getGetEnergyUsageBySourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEnergyUsageBySource",
      requestType = ds.energymonitoring.UsageBySourceRequest.class,
      responseType = ds.energymonitoring.UsageBySourceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.energymonitoring.UsageBySourceRequest,
      ds.energymonitoring.UsageBySourceResponse> getGetEnergyUsageBySourceMethod() {
    io.grpc.MethodDescriptor<ds.energymonitoring.UsageBySourceRequest, ds.energymonitoring.UsageBySourceResponse> getGetEnergyUsageBySourceMethod;
    if ((getGetEnergyUsageBySourceMethod = EnergyMonitoringGrpc.getGetEnergyUsageBySourceMethod) == null) {
      synchronized (EnergyMonitoringGrpc.class) {
        if ((getGetEnergyUsageBySourceMethod = EnergyMonitoringGrpc.getGetEnergyUsageBySourceMethod) == null) {
          EnergyMonitoringGrpc.getGetEnergyUsageBySourceMethod = getGetEnergyUsageBySourceMethod = 
              io.grpc.MethodDescriptor.<ds.energymonitoring.UsageBySourceRequest, ds.energymonitoring.UsageBySourceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "EnergyMonitoring.EnergyMonitoring", "GetEnergyUsageBySource"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.energymonitoring.UsageBySourceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.energymonitoring.UsageBySourceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EnergyMonitoringMethodDescriptorSupplier("GetEnergyUsageBySource"))
                  .build();
          }
        }
     }
     return getGetEnergyUsageBySourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.energymonitoring.GetEnergyUsageHistoryRequest,
      ds.energymonitoring.EnergyUsageHistoryData> getGetEnergyUsageHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEnergyUsageHistory",
      requestType = ds.energymonitoring.GetEnergyUsageHistoryRequest.class,
      responseType = ds.energymonitoring.EnergyUsageHistoryData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.energymonitoring.GetEnergyUsageHistoryRequest,
      ds.energymonitoring.EnergyUsageHistoryData> getGetEnergyUsageHistoryMethod() {
    io.grpc.MethodDescriptor<ds.energymonitoring.GetEnergyUsageHistoryRequest, ds.energymonitoring.EnergyUsageHistoryData> getGetEnergyUsageHistoryMethod;
    if ((getGetEnergyUsageHistoryMethod = EnergyMonitoringGrpc.getGetEnergyUsageHistoryMethod) == null) {
      synchronized (EnergyMonitoringGrpc.class) {
        if ((getGetEnergyUsageHistoryMethod = EnergyMonitoringGrpc.getGetEnergyUsageHistoryMethod) == null) {
          EnergyMonitoringGrpc.getGetEnergyUsageHistoryMethod = getGetEnergyUsageHistoryMethod = 
              io.grpc.MethodDescriptor.<ds.energymonitoring.GetEnergyUsageHistoryRequest, ds.energymonitoring.EnergyUsageHistoryData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "EnergyMonitoring.EnergyMonitoring", "GetEnergyUsageHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.energymonitoring.GetEnergyUsageHistoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.energymonitoring.EnergyUsageHistoryData.getDefaultInstance()))
                  .setSchemaDescriptor(new EnergyMonitoringMethodDescriptorSupplier("GetEnergyUsageHistory"))
                  .build();
          }
        }
     }
     return getGetEnergyUsageHistoryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EnergyMonitoringStub newStub(io.grpc.Channel channel) {
    return new EnergyMonitoringStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EnergyMonitoringBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EnergyMonitoringBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EnergyMonitoringFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EnergyMonitoringFutureStub(channel);
  }

  /**
   * <pre>
   *Service Definition
   * </pre>
   */
  public static abstract class EnergyMonitoringImplBase implements io.grpc.BindableService {

    /**
     */
    public void getEnergyUsage(ds.energymonitoring.GetEnergyUsageRequest request,
        io.grpc.stub.StreamObserver<ds.energymonitoring.GetEnergyUsageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetEnergyUsageMethod(), responseObserver);
    }

    /**
     */
    public void getEnergyUsageBySource(ds.energymonitoring.UsageBySourceRequest request,
        io.grpc.stub.StreamObserver<ds.energymonitoring.UsageBySourceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetEnergyUsageBySourceMethod(), responseObserver);
    }

    /**
     */
    public void getEnergyUsageHistory(ds.energymonitoring.GetEnergyUsageHistoryRequest request,
        io.grpc.stub.StreamObserver<ds.energymonitoring.EnergyUsageHistoryData> responseObserver) {
      asyncUnimplementedUnaryCall(getGetEnergyUsageHistoryMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetEnergyUsageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.energymonitoring.GetEnergyUsageRequest,
                ds.energymonitoring.GetEnergyUsageResponse>(
                  this, METHODID_GET_ENERGY_USAGE)))
          .addMethod(
            getGetEnergyUsageBySourceMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.energymonitoring.UsageBySourceRequest,
                ds.energymonitoring.UsageBySourceResponse>(
                  this, METHODID_GET_ENERGY_USAGE_BY_SOURCE)))
          .addMethod(
            getGetEnergyUsageHistoryMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.energymonitoring.GetEnergyUsageHistoryRequest,
                ds.energymonitoring.EnergyUsageHistoryData>(
                  this, METHODID_GET_ENERGY_USAGE_HISTORY)))
          .build();
    }
  }

  /**
   * <pre>
   *Service Definition
   * </pre>
   */
  public static final class EnergyMonitoringStub extends io.grpc.stub.AbstractStub<EnergyMonitoringStub> {
    private EnergyMonitoringStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EnergyMonitoringStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnergyMonitoringStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EnergyMonitoringStub(channel, callOptions);
    }

    /**
     */
    public void getEnergyUsage(ds.energymonitoring.GetEnergyUsageRequest request,
        io.grpc.stub.StreamObserver<ds.energymonitoring.GetEnergyUsageResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetEnergyUsageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getEnergyUsageBySource(ds.energymonitoring.UsageBySourceRequest request,
        io.grpc.stub.StreamObserver<ds.energymonitoring.UsageBySourceResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetEnergyUsageBySourceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getEnergyUsageHistory(ds.energymonitoring.GetEnergyUsageHistoryRequest request,
        io.grpc.stub.StreamObserver<ds.energymonitoring.EnergyUsageHistoryData> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetEnergyUsageHistoryMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *Service Definition
   * </pre>
   */
  public static final class EnergyMonitoringBlockingStub extends io.grpc.stub.AbstractStub<EnergyMonitoringBlockingStub> {
    private EnergyMonitoringBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EnergyMonitoringBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnergyMonitoringBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EnergyMonitoringBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.energymonitoring.GetEnergyUsageResponse getEnergyUsage(ds.energymonitoring.GetEnergyUsageRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetEnergyUsageMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ds.energymonitoring.UsageBySourceResponse> getEnergyUsageBySource(
        ds.energymonitoring.UsageBySourceRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetEnergyUsageBySourceMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ds.energymonitoring.EnergyUsageHistoryData> getEnergyUsageHistory(
        ds.energymonitoring.GetEnergyUsageHistoryRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetEnergyUsageHistoryMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *Service Definition
   * </pre>
   */
  public static final class EnergyMonitoringFutureStub extends io.grpc.stub.AbstractStub<EnergyMonitoringFutureStub> {
    private EnergyMonitoringFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EnergyMonitoringFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnergyMonitoringFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EnergyMonitoringFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.energymonitoring.GetEnergyUsageResponse> getEnergyUsage(
        ds.energymonitoring.GetEnergyUsageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetEnergyUsageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ENERGY_USAGE = 0;
  private static final int METHODID_GET_ENERGY_USAGE_BY_SOURCE = 1;
  private static final int METHODID_GET_ENERGY_USAGE_HISTORY = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EnergyMonitoringImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EnergyMonitoringImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ENERGY_USAGE:
          serviceImpl.getEnergyUsage((ds.energymonitoring.GetEnergyUsageRequest) request,
              (io.grpc.stub.StreamObserver<ds.energymonitoring.GetEnergyUsageResponse>) responseObserver);
          break;
        case METHODID_GET_ENERGY_USAGE_BY_SOURCE:
          serviceImpl.getEnergyUsageBySource((ds.energymonitoring.UsageBySourceRequest) request,
              (io.grpc.stub.StreamObserver<ds.energymonitoring.UsageBySourceResponse>) responseObserver);
          break;
        case METHODID_GET_ENERGY_USAGE_HISTORY:
          serviceImpl.getEnergyUsageHistory((ds.energymonitoring.GetEnergyUsageHistoryRequest) request,
              (io.grpc.stub.StreamObserver<ds.energymonitoring.EnergyUsageHistoryData>) responseObserver);
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

  private static abstract class EnergyMonitoringBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EnergyMonitoringBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.energymonitoring.EnergyMonitoringImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EnergyMonitoring");
    }
  }

  private static final class EnergyMonitoringFileDescriptorSupplier
      extends EnergyMonitoringBaseDescriptorSupplier {
    EnergyMonitoringFileDescriptorSupplier() {}
  }

  private static final class EnergyMonitoringMethodDescriptorSupplier
      extends EnergyMonitoringBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EnergyMonitoringMethodDescriptorSupplier(String methodName) {
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
      synchronized (EnergyMonitoringGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EnergyMonitoringFileDescriptorSupplier())
              .addMethod(getGetEnergyUsageMethod())
              .addMethod(getGetEnergyUsageBySourceMethod())
              .addMethod(getGetEnergyUsageHistoryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
