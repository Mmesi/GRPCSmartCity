// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: applianceoptimization.proto

package ds.applicationoptimization;

/**
 * Protobuf type {@code ApplicationOptimization.SetApplianceLimitRequest}
 */
public  final class SetApplianceLimitRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ApplicationOptimization.SetApplianceLimitRequest)
    SetApplianceLimitRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SetApplianceLimitRequest.newBuilder() to construct.
  private SetApplianceLimitRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SetApplianceLimitRequest() {
    applianceID_ = "";
    limit_ = 0F;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SetApplianceLimitRequest(
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

            applianceID_ = s;
            break;
          }
          case 21: {

            limit_ = input.readFloat();
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
    return ds.applicationoptimization.ApplicationOptimizationImpl.internal_static_ApplicationOptimization_SetApplianceLimitRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.applicationoptimization.ApplicationOptimizationImpl.internal_static_ApplicationOptimization_SetApplianceLimitRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.applicationoptimization.SetApplianceLimitRequest.class, ds.applicationoptimization.SetApplianceLimitRequest.Builder.class);
  }

  public static final int APPLIANCEID_FIELD_NUMBER = 1;
  private volatile java.lang.Object applianceID_;
  /**
   * <code>string applianceID = 1;</code>
   */
  public java.lang.String getApplianceID() {
    java.lang.Object ref = applianceID_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      applianceID_ = s;
      return s;
    }
  }
  /**
   * <code>string applianceID = 1;</code>
   */
  public com.google.protobuf.ByteString
      getApplianceIDBytes() {
    java.lang.Object ref = applianceID_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      applianceID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LIMIT_FIELD_NUMBER = 2;
  private float limit_;
  /**
   * <code>float limit = 2;</code>
   */
  public float getLimit() {
    return limit_;
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
    if (!getApplianceIDBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, applianceID_);
    }
    if (limit_ != 0F) {
      output.writeFloat(2, limit_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getApplianceIDBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, applianceID_);
    }
    if (limit_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(2, limit_);
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
    if (!(obj instanceof ds.applicationoptimization.SetApplianceLimitRequest)) {
      return super.equals(obj);
    }
    ds.applicationoptimization.SetApplianceLimitRequest other = (ds.applicationoptimization.SetApplianceLimitRequest) obj;

    boolean result = true;
    result = result && getApplianceID()
        .equals(other.getApplianceID());
    result = result && (
        java.lang.Float.floatToIntBits(getLimit())
        == java.lang.Float.floatToIntBits(
            other.getLimit()));
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
    hash = (37 * hash) + APPLIANCEID_FIELD_NUMBER;
    hash = (53 * hash) + getApplianceID().hashCode();
    hash = (37 * hash) + LIMIT_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getLimit());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.applicationoptimization.SetApplianceLimitRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.applicationoptimization.SetApplianceLimitRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.applicationoptimization.SetApplianceLimitRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.applicationoptimization.SetApplianceLimitRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.applicationoptimization.SetApplianceLimitRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.applicationoptimization.SetApplianceLimitRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.applicationoptimization.SetApplianceLimitRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.applicationoptimization.SetApplianceLimitRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.applicationoptimization.SetApplianceLimitRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.applicationoptimization.SetApplianceLimitRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.applicationoptimization.SetApplianceLimitRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.applicationoptimization.SetApplianceLimitRequest parseFrom(
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
  public static Builder newBuilder(ds.applicationoptimization.SetApplianceLimitRequest prototype) {
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
   * Protobuf type {@code ApplicationOptimization.SetApplianceLimitRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ApplicationOptimization.SetApplianceLimitRequest)
      ds.applicationoptimization.SetApplianceLimitRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.applicationoptimization.ApplicationOptimizationImpl.internal_static_ApplicationOptimization_SetApplianceLimitRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.applicationoptimization.ApplicationOptimizationImpl.internal_static_ApplicationOptimization_SetApplianceLimitRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.applicationoptimization.SetApplianceLimitRequest.class, ds.applicationoptimization.SetApplianceLimitRequest.Builder.class);
    }

    // Construct using ds.applicationoptimization.SetApplianceLimitRequest.newBuilder()
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
      applianceID_ = "";

      limit_ = 0F;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.applicationoptimization.ApplicationOptimizationImpl.internal_static_ApplicationOptimization_SetApplianceLimitRequest_descriptor;
    }

    @java.lang.Override
    public ds.applicationoptimization.SetApplianceLimitRequest getDefaultInstanceForType() {
      return ds.applicationoptimization.SetApplianceLimitRequest.getDefaultInstance();
    }

    @java.lang.Override
    public ds.applicationoptimization.SetApplianceLimitRequest build() {
      ds.applicationoptimization.SetApplianceLimitRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.applicationoptimization.SetApplianceLimitRequest buildPartial() {
      ds.applicationoptimization.SetApplianceLimitRequest result = new ds.applicationoptimization.SetApplianceLimitRequest(this);
      result.applianceID_ = applianceID_;
      result.limit_ = limit_;
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
      if (other instanceof ds.applicationoptimization.SetApplianceLimitRequest) {
        return mergeFrom((ds.applicationoptimization.SetApplianceLimitRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.applicationoptimization.SetApplianceLimitRequest other) {
      if (other == ds.applicationoptimization.SetApplianceLimitRequest.getDefaultInstance()) return this;
      if (!other.getApplianceID().isEmpty()) {
        applianceID_ = other.applianceID_;
        onChanged();
      }
      if (other.getLimit() != 0F) {
        setLimit(other.getLimit());
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
      ds.applicationoptimization.SetApplianceLimitRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.applicationoptimization.SetApplianceLimitRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object applianceID_ = "";
    /**
     * <code>string applianceID = 1;</code>
     */
    public java.lang.String getApplianceID() {
      java.lang.Object ref = applianceID_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        applianceID_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string applianceID = 1;</code>
     */
    public com.google.protobuf.ByteString
        getApplianceIDBytes() {
      java.lang.Object ref = applianceID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        applianceID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string applianceID = 1;</code>
     */
    public Builder setApplianceID(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      applianceID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string applianceID = 1;</code>
     */
    public Builder clearApplianceID() {
      
      applianceID_ = getDefaultInstance().getApplianceID();
      onChanged();
      return this;
    }
    /**
     * <code>string applianceID = 1;</code>
     */
    public Builder setApplianceIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      applianceID_ = value;
      onChanged();
      return this;
    }

    private float limit_ ;
    /**
     * <code>float limit = 2;</code>
     */
    public float getLimit() {
      return limit_;
    }
    /**
     * <code>float limit = 2;</code>
     */
    public Builder setLimit(float value) {
      
      limit_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float limit = 2;</code>
     */
    public Builder clearLimit() {
      
      limit_ = 0F;
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


    // @@protoc_insertion_point(builder_scope:ApplicationOptimization.SetApplianceLimitRequest)
  }

  // @@protoc_insertion_point(class_scope:ApplicationOptimization.SetApplianceLimitRequest)
  private static final ds.applicationoptimization.SetApplianceLimitRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.applicationoptimization.SetApplianceLimitRequest();
  }

  public static ds.applicationoptimization.SetApplianceLimitRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SetApplianceLimitRequest>
      PARSER = new com.google.protobuf.AbstractParser<SetApplianceLimitRequest>() {
    @java.lang.Override
    public SetApplianceLimitRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SetApplianceLimitRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SetApplianceLimitRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SetApplianceLimitRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.applicationoptimization.SetApplianceLimitRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

