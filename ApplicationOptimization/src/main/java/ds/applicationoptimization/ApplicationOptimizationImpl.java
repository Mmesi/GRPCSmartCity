// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: applicationoptimization.proto

package ds.applicationoptimization;

public final class ApplicationOptimizationImpl {
  private ApplicationOptimizationImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ApplicationOptimization_SetApplianceModeRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ApplicationOptimization_SetApplianceModeRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ApplicationOptimization_SetApplianceModeResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ApplicationOptimization_SetApplianceModeResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ApplicationOptimization_SetApplianceLimitRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ApplicationOptimization_SetApplianceLimitRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ApplicationOptimization_SetApplianceLimitResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ApplicationOptimization_SetApplianceLimitResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ApplicationOptimization_SetApplianceScheduleRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ApplicationOptimization_SetApplianceScheduleRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ApplicationOptimization_SetApplianceScheduleResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ApplicationOptimization_SetApplianceScheduleResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\035applicationoptimization.proto\022\027Applica" +
      "tionOptimization\"O\n\027SetApplianceModeRequ" +
      "est\022\024\n\014appliance_id\030\001 \001(\t\022\014\n\004mode\030\002 \001(\t\022" +
      "\020\n\010location\030\003 \001(\t\";\n\030SetApplianceModeRes" +
      "ponse\022\016\n\006status\030\001 \001(\010\022\017\n\007message\030\002 \001(\t\">" +
      "\n\030SetApplianceLimitRequest\022\023\n\013applianceI" +
      "D\030\001 \001(\t\022\r\n\005limit\030\002 \001(\002\"<\n\031SetApplianceLi" +
      "mitResponse\022\016\n\006status\030\001 \001(\010\022\017\n\007message\030\002" +
      " \001(\t\"Y\n\033SetApplianceScheduleRequest\022\024\n\014a" +
      "ppliance_id\030\001 \001(\t\022\022\n\nstart_time\030\002 \001(\003\022\020\n" +
      "\010end_time\030\003 \001(\003\"/\n\034SetApplianceScheduleR" +
      "esponse\022\017\n\007message\030\001 \001(\t2\236\003\n\027Application" +
      "Optimization\022y\n\020SetApplianceMode\0220.Appli" +
      "cationOptimization.SetApplianceModeReque" +
      "st\0321.ApplicationOptimization.SetApplianc" +
      "eModeResponse\"\000\022|\n\021SetApplianceLimit\0221.A" +
      "pplicationOptimization.SetApplianceLimit" +
      "Request\0322.ApplicationOptimization.SetApp" +
      "lianceLimitResponse\"\000\022\211\001\n\024SetApplianceSc" +
      "hedule\0224.ApplicationOptimization.SetAppl" +
      "ianceScheduleRequest\0325.ApplicationOptimi" +
      "zation.SetApplianceScheduleResponse\"\000(\0010" +
      "\001B;\n\032ds.applicationoptimizationB\033Applica" +
      "tionOptimizationImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_ApplicationOptimization_SetApplianceModeRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ApplicationOptimization_SetApplianceModeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ApplicationOptimization_SetApplianceModeRequest_descriptor,
        new java.lang.String[] { "ApplianceId", "Mode", "Location", });
    internal_static_ApplicationOptimization_SetApplianceModeResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ApplicationOptimization_SetApplianceModeResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ApplicationOptimization_SetApplianceModeResponse_descriptor,
        new java.lang.String[] { "Status", "Message", });
    internal_static_ApplicationOptimization_SetApplianceLimitRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ApplicationOptimization_SetApplianceLimitRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ApplicationOptimization_SetApplianceLimitRequest_descriptor,
        new java.lang.String[] { "ApplianceID", "Limit", });
    internal_static_ApplicationOptimization_SetApplianceLimitResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_ApplicationOptimization_SetApplianceLimitResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ApplicationOptimization_SetApplianceLimitResponse_descriptor,
        new java.lang.String[] { "Status", "Message", });
    internal_static_ApplicationOptimization_SetApplianceScheduleRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_ApplicationOptimization_SetApplianceScheduleRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ApplicationOptimization_SetApplianceScheduleRequest_descriptor,
        new java.lang.String[] { "ApplianceId", "StartTime", "EndTime", });
    internal_static_ApplicationOptimization_SetApplianceScheduleResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_ApplicationOptimization_SetApplianceScheduleResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ApplicationOptimization_SetApplianceScheduleResponse_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}