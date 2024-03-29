// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lightingsystem.proto

package ds.lightingsystem;

/**
 * Protobuf type {@code LightingSystem.SetLightScheduleRequest}
 */
public  final class SetLightScheduleRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:LightingSystem.SetLightScheduleRequest)
    SetLightScheduleRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SetLightScheduleRequest.newBuilder() to construct.
  private SetLightScheduleRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SetLightScheduleRequest() {
    systemId_ = "";
    startTime_ = 0L;
    endTime_ = 0L;
    intensity_ = 0F;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SetLightScheduleRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            systemId_ = s;
            break;
          }
          case 16: {

            startTime_ = input.readInt64();
            break;
          }
          case 24: {

            endTime_ = input.readInt64();
            break;
          }
          case 37: {

            intensity_ = input.readFloat();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ds.lightingsystem.LightingSystemImpl.internal_static_LightingSystem_SetLightScheduleRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.lightingsystem.LightingSystemImpl.internal_static_LightingSystem_SetLightScheduleRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.lightingsystem.SetLightScheduleRequest.class, ds.lightingsystem.SetLightScheduleRequest.Builder.class);
  }

  public static final int SYSTEM_ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object systemId_;
  /**
   * <code>string system_id = 1;</code>
   */
  public java.lang.String getSystemId() {
    java.lang.Object ref = systemId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      systemId_ = s;
      return s;
    }
  }
  /**
   * <code>string system_id = 1;</code>
   */
  public com.google.protobuf.ByteString
      getSystemIdBytes() {
    java.lang.Object ref = systemId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      systemId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int START_TIME_FIELD_NUMBER = 2;
  private long startTime_;
  /**
   * <code>int64 start_time = 2;</code>
   */
  public long getStartTime() {
    return startTime_;
  }

  public static final int END_TIME_FIELD_NUMBER = 3;
  private long endTime_;
  /**
   * <code>int64 end_time = 3;</code>
   */
  public long getEndTime() {
    return endTime_;
  }

  public static final int INTENSITY_FIELD_NUMBER = 4;
  private float intensity_;
  /**
   * <code>float intensity = 4;</code>
   */
  public float getIntensity() {
    return intensity_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getSystemIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, systemId_);
    }
    if (startTime_ != 0L) {
      output.writeInt64(2, startTime_);
    }
    if (endTime_ != 0L) {
      output.writeInt64(3, endTime_);
    }
    if (intensity_ != 0F) {
      output.writeFloat(4, intensity_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getSystemIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, systemId_);
    }
    if (startTime_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, startTime_);
    }
    if (endTime_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, endTime_);
    }
    if (intensity_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(4, intensity_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ds.lightingsystem.SetLightScheduleRequest)) {
      return super.equals(obj);
    }
    ds.lightingsystem.SetLightScheduleRequest other = (ds.lightingsystem.SetLightScheduleRequest) obj;

    boolean result = true;
    result = result && getSystemId()
        .equals(other.getSystemId());
    result = result && (getStartTime()
        == other.getStartTime());
    result = result && (getEndTime()
        == other.getEndTime());
    result = result && (
        java.lang.Float.floatToIntBits(getIntensity())
        == java.lang.Float.floatToIntBits(
            other.getIntensity()));
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + SYSTEM_ID_FIELD_NUMBER;
    hash = (53 * hash) + getSystemId().hashCode();
    hash = (37 * hash) + START_TIME_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getStartTime());
    hash = (37 * hash) + END_TIME_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getEndTime());
    hash = (37 * hash) + INTENSITY_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getIntensity());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.lightingsystem.SetLightScheduleRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.lightingsystem.SetLightScheduleRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.lightingsystem.SetLightScheduleRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.lightingsystem.SetLightScheduleRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.lightingsystem.SetLightScheduleRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.lightingsystem.SetLightScheduleRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.lightingsystem.SetLightScheduleRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.lightingsystem.SetLightScheduleRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.lightingsystem.SetLightScheduleRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.lightingsystem.SetLightScheduleRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.lightingsystem.SetLightScheduleRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.lightingsystem.SetLightScheduleRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ds.lightingsystem.SetLightScheduleRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code LightingSystem.SetLightScheduleRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:LightingSystem.SetLightScheduleRequest)
      ds.lightingsystem.SetLightScheduleRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.lightingsystem.LightingSystemImpl.internal_static_LightingSystem_SetLightScheduleRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.lightingsystem.LightingSystemImpl.internal_static_LightingSystem_SetLightScheduleRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.lightingsystem.SetLightScheduleRequest.class, ds.lightingsystem.SetLightScheduleRequest.Builder.class);
    }

    // Construct using ds.lightingsystem.SetLightScheduleRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      systemId_ = "";

      startTime_ = 0L;

      endTime_ = 0L;

      intensity_ = 0F;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.lightingsystem.LightingSystemImpl.internal_static_LightingSystem_SetLightScheduleRequest_descriptor;
    }

    @java.lang.Override
    public ds.lightingsystem.SetLightScheduleRequest getDefaultInstanceForType() {
      return ds.lightingsystem.SetLightScheduleRequest.getDefaultInstance();
    }

    @java.lang.Override
    public ds.lightingsystem.SetLightScheduleRequest build() {
      ds.lightingsystem.SetLightScheduleRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.lightingsystem.SetLightScheduleRequest buildPartial() {
      ds.lightingsystem.SetLightScheduleRequest result = new ds.lightingsystem.SetLightScheduleRequest(this);
      result.systemId_ = systemId_;
      result.startTime_ = startTime_;
      result.endTime_ = endTime_;
      result.intensity_ = intensity_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ds.lightingsystem.SetLightScheduleRequest) {
        return mergeFrom((ds.lightingsystem.SetLightScheduleRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.lightingsystem.SetLightScheduleRequest other) {
      if (other == ds.lightingsystem.SetLightScheduleRequest.getDefaultInstance()) return this;
      if (!other.getSystemId().isEmpty()) {
        systemId_ = other.systemId_;
        onChanged();
      }
      if (other.getStartTime() != 0L) {
        setStartTime(other.getStartTime());
      }
      if (other.getEndTime() != 0L) {
        setEndTime(other.getEndTime());
      }
      if (other.getIntensity() != 0F) {
        setIntensity(other.getIntensity());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ds.lightingsystem.SetLightScheduleRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.lightingsystem.SetLightScheduleRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object systemId_ = "";
    /**
     * <code>string system_id = 1;</code>
     */
    public java.lang.String getSystemId() {
      java.lang.Object ref = systemId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        systemId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string system_id = 1;</code>
     */
    public com.google.protobuf.ByteString
        getSystemIdBytes() {
      java.lang.Object ref = systemId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        systemId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string system_id = 1;</code>
     */
    public Builder setSystemId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      systemId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string system_id = 1;</code>
     */
    public Builder clearSystemId() {
      
      systemId_ = getDefaultInstance().getSystemId();
      onChanged();
      return this;
    }
    /**
     * <code>string system_id = 1;</code>
     */
    public Builder setSystemIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      systemId_ = value;
      onChanged();
      return this;
    }

    private long startTime_ ;
    /**
     * <code>int64 start_time = 2;</code>
     */
    public long getStartTime() {
      return startTime_;
    }
    /**
     * <code>int64 start_time = 2;</code>
     */
    public Builder setStartTime(long value) {
      
      startTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 start_time = 2;</code>
     */
    public Builder clearStartTime() {
      
      startTime_ = 0L;
      onChanged();
      return this;
    }

    private long endTime_ ;
    /**
     * <code>int64 end_time = 3;</code>
     */
    public long getEndTime() {
      return endTime_;
    }
    /**
     * <code>int64 end_time = 3;</code>
     */
    public Builder setEndTime(long value) {
      
      endTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 end_time = 3;</code>
     */
    public Builder clearEndTime() {
      
      endTime_ = 0L;
      onChanged();
      return this;
    }

    private float intensity_ ;
    /**
     * <code>float intensity = 4;</code>
     */
    public float getIntensity() {
      return intensity_;
    }
    /**
     * <code>float intensity = 4;</code>
     */
    public Builder setIntensity(float value) {
      
      intensity_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float intensity = 4;</code>
     */
    public Builder clearIntensity() {
      
      intensity_ = 0F;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:LightingSystem.SetLightScheduleRequest)
  }

  // @@protoc_insertion_point(class_scope:LightingSystem.SetLightScheduleRequest)
  private static final ds.lightingsystem.SetLightScheduleRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.lightingsystem.SetLightScheduleRequest();
  }

  public static ds.lightingsystem.SetLightScheduleRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SetLightScheduleRequest>
      PARSER = new com.google.protobuf.AbstractParser<SetLightScheduleRequest>() {
    @java.lang.Override
    public SetLightScheduleRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SetLightScheduleRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SetLightScheduleRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SetLightScheduleRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.lightingsystem.SetLightScheduleRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

