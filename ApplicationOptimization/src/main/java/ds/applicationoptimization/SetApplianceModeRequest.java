// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: applianceoptimization.proto

package ds.applicationoptimization;

/**
 * Protobuf type {@code ApplicationOptimization.SetApplianceModeRequest}
 */
public  final class SetApplianceModeRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ApplicationOptimization.SetApplianceModeRequest)
    SetApplianceModeRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SetApplianceModeRequest.newBuilder() to construct.
  private SetApplianceModeRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SetApplianceModeRequest() {
    applianceId_ = "";
    mode_ = "";
    location_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SetApplianceModeRequest(
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

            applianceId_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            mode_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            location_ = s;
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
    return ds.applicationoptimization.ApplicationOptimizationImpl.internal_static_ApplicationOptimization_SetApplianceModeRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.applicationoptimization.ApplicationOptimizationImpl.internal_static_ApplicationOptimization_SetApplianceModeRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.applicationoptimization.SetApplianceModeRequest.class, ds.applicationoptimization.SetApplianceModeRequest.Builder.class);
  }

  public static final int APPLIANCE_ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object applianceId_;
  /**
   * <code>string appliance_id = 1;</code>
   */
  public java.lang.String getApplianceId() {
    java.lang.Object ref = applianceId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      applianceId_ = s;
      return s;
    }
  }
  /**
   * <code>string appliance_id = 1;</code>
   */
  public com.google.protobuf.ByteString
      getApplianceIdBytes() {
    java.lang.Object ref = applianceId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      applianceId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int MODE_FIELD_NUMBER = 2;
  private volatile java.lang.Object mode_;
  /**
   * <code>string mode = 2;</code>
   */
  public java.lang.String getMode() {
    java.lang.Object ref = mode_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      mode_ = s;
      return s;
    }
  }
  /**
   * <code>string mode = 2;</code>
   */
  public com.google.protobuf.ByteString
      getModeBytes() {
    java.lang.Object ref = mode_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      mode_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LOCATION_FIELD_NUMBER = 3;
  private volatile java.lang.Object location_;
  /**
   * <code>string location = 3;</code>
   */
  public java.lang.String getLocation() {
    java.lang.Object ref = location_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      location_ = s;
      return s;
    }
  }
  /**
   * <code>string location = 3;</code>
   */
  public com.google.protobuf.ByteString
      getLocationBytes() {
    java.lang.Object ref = location_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      location_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getApplianceIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, applianceId_);
    }
    if (!getModeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, mode_);
    }
    if (!getLocationBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, location_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getApplianceIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, applianceId_);
    }
    if (!getModeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, mode_);
    }
    if (!getLocationBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, location_);
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
    if (!(obj instanceof ds.applicationoptimization.SetApplianceModeRequest)) {
      return super.equals(obj);
    }
    ds.applicationoptimization.SetApplianceModeRequest other = (ds.applicationoptimization.SetApplianceModeRequest) obj;

    boolean result = true;
    result = result && getApplianceId()
        .equals(other.getApplianceId());
    result = result && getMode()
        .equals(other.getMode());
    result = result && getLocation()
        .equals(other.getLocation());
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
    hash = (37 * hash) + APPLIANCE_ID_FIELD_NUMBER;
    hash = (53 * hash) + getApplianceId().hashCode();
    hash = (37 * hash) + MODE_FIELD_NUMBER;
    hash = (53 * hash) + getMode().hashCode();
    hash = (37 * hash) + LOCATION_FIELD_NUMBER;
    hash = (53 * hash) + getLocation().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.applicationoptimization.SetApplianceModeRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.applicationoptimization.SetApplianceModeRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.applicationoptimization.SetApplianceModeRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.applicationoptimization.SetApplianceModeRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.applicationoptimization.SetApplianceModeRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.applicationoptimization.SetApplianceModeRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.applicationoptimization.SetApplianceModeRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.applicationoptimization.SetApplianceModeRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.applicationoptimization.SetApplianceModeRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.applicationoptimization.SetApplianceModeRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.applicationoptimization.SetApplianceModeRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.applicationoptimization.SetApplianceModeRequest parseFrom(
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
  public static Builder newBuilder(ds.applicationoptimization.SetApplianceModeRequest prototype) {
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
   * Protobuf type {@code ApplicationOptimization.SetApplianceModeRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ApplicationOptimization.SetApplianceModeRequest)
      ds.applicationoptimization.SetApplianceModeRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.applicationoptimization.ApplicationOptimizationImpl.internal_static_ApplicationOptimization_SetApplianceModeRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.applicationoptimization.ApplicationOptimizationImpl.internal_static_ApplicationOptimization_SetApplianceModeRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.applicationoptimization.SetApplianceModeRequest.class, ds.applicationoptimization.SetApplianceModeRequest.Builder.class);
    }

    // Construct using ds.applicationoptimization.SetApplianceModeRequest.newBuilder()
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
      applianceId_ = "";

      mode_ = "";

      location_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.applicationoptimization.ApplicationOptimizationImpl.internal_static_ApplicationOptimization_SetApplianceModeRequest_descriptor;
    }

    @java.lang.Override
    public ds.applicationoptimization.SetApplianceModeRequest getDefaultInstanceForType() {
      return ds.applicationoptimization.SetApplianceModeRequest.getDefaultInstance();
    }

    @java.lang.Override
    public ds.applicationoptimization.SetApplianceModeRequest build() {
      ds.applicationoptimization.SetApplianceModeRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.applicationoptimization.SetApplianceModeRequest buildPartial() {
      ds.applicationoptimization.SetApplianceModeRequest result = new ds.applicationoptimization.SetApplianceModeRequest(this);
      result.applianceId_ = applianceId_;
      result.mode_ = mode_;
      result.location_ = location_;
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
      if (other instanceof ds.applicationoptimization.SetApplianceModeRequest) {
        return mergeFrom((ds.applicationoptimization.SetApplianceModeRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.applicationoptimization.SetApplianceModeRequest other) {
      if (other == ds.applicationoptimization.SetApplianceModeRequest.getDefaultInstance()) return this;
      if (!other.getApplianceId().isEmpty()) {
        applianceId_ = other.applianceId_;
        onChanged();
      }
      if (!other.getMode().isEmpty()) {
        mode_ = other.mode_;
        onChanged();
      }
      if (!other.getLocation().isEmpty()) {
        location_ = other.location_;
        onChanged();
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
      ds.applicationoptimization.SetApplianceModeRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.applicationoptimization.SetApplianceModeRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object applianceId_ = "";
    /**
     * <code>string appliance_id = 1;</code>
     */
    public java.lang.String getApplianceId() {
      java.lang.Object ref = applianceId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        applianceId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string appliance_id = 1;</code>
     */
    public com.google.protobuf.ByteString
        getApplianceIdBytes() {
      java.lang.Object ref = applianceId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        applianceId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string appliance_id = 1;</code>
     */
    public Builder setApplianceId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      applianceId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string appliance_id = 1;</code>
     */
    public Builder clearApplianceId() {
      
      applianceId_ = getDefaultInstance().getApplianceId();
      onChanged();
      return this;
    }
    /**
     * <code>string appliance_id = 1;</code>
     */
    public Builder setApplianceIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      applianceId_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object mode_ = "";
    /**
     * <code>string mode = 2;</code>
     */
    public java.lang.String getMode() {
      java.lang.Object ref = mode_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        mode_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string mode = 2;</code>
     */
    public com.google.protobuf.ByteString
        getModeBytes() {
      java.lang.Object ref = mode_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        mode_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string mode = 2;</code>
     */
    public Builder setMode(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      mode_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string mode = 2;</code>
     */
    public Builder clearMode() {
      
      mode_ = getDefaultInstance().getMode();
      onChanged();
      return this;
    }
    /**
     * <code>string mode = 2;</code>
     */
    public Builder setModeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      mode_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object location_ = "";
    /**
     * <code>string location = 3;</code>
     */
    public java.lang.String getLocation() {
      java.lang.Object ref = location_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        location_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string location = 3;</code>
     */
    public com.google.protobuf.ByteString
        getLocationBytes() {
      java.lang.Object ref = location_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        location_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string location = 3;</code>
     */
    public Builder setLocation(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      location_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string location = 3;</code>
     */
    public Builder clearLocation() {
      
      location_ = getDefaultInstance().getLocation();
      onChanged();
      return this;
    }
    /**
     * <code>string location = 3;</code>
     */
    public Builder setLocationBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      location_ = value;
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


    // @@protoc_insertion_point(builder_scope:ApplicationOptimization.SetApplianceModeRequest)
  }

  // @@protoc_insertion_point(class_scope:ApplicationOptimization.SetApplianceModeRequest)
  private static final ds.applicationoptimization.SetApplianceModeRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.applicationoptimization.SetApplianceModeRequest();
  }

  public static ds.applicationoptimization.SetApplianceModeRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SetApplianceModeRequest>
      PARSER = new com.google.protobuf.AbstractParser<SetApplianceModeRequest>() {
    @java.lang.Override
    public SetApplianceModeRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SetApplianceModeRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SetApplianceModeRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SetApplianceModeRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.applicationoptimization.SetApplianceModeRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

