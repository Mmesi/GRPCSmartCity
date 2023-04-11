package ds.energymonitoring;

/**
 * Protobuf type {@code EnergyMonitoring.EnergyUsageHistoryData}
 */
public  final class EnergyUsageHistoryData extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:EnergyMonitoring.EnergyUsageHistoryData)
    EnergyUsageHistoryDataOrBuilder {
private static final long serialVersionUID = 0L;
  // Use EnergyUsageHistoryData.newBuilder() to construct.
  private EnergyUsageHistoryData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private EnergyUsageHistoryData() {
    dateTime_ = 0L;
    energyUsage_ = 0F;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private EnergyUsageHistoryData(
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
          case 8: {

            dateTime_ = input.readInt64();
            break;
          }
          case 21: {

            energyUsage_ = input.readFloat();
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
    return ds.energymonitoring.EnergyMonitoringImpl.internal_static_EnergyMonitoring_EnergyUsageHistoryData_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.energymonitoring.EnergyMonitoringImpl.internal_static_EnergyMonitoring_EnergyUsageHistoryData_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.energymonitoring.EnergyUsageHistoryData.class, ds.energymonitoring.EnergyUsageHistoryData.Builder.class);
  }

  public static final int DATE_TIME_FIELD_NUMBER = 1;
  private long dateTime_;
  /**
   * <code>int64 date_time = 1;</code>
   */
  public long getDateTime() {
    return dateTime_;
  }

  public static final int ENERGY_USAGE_FIELD_NUMBER = 2;
  private float energyUsage_;
  /**
   * <code>float energy_usage = 2;</code>
   */
  public float getEnergyUsage() {
    return energyUsage_;
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
    if (dateTime_ != 0L) {
      output.writeInt64(1, dateTime_);
    }
    if (energyUsage_ != 0F) {
      output.writeFloat(2, energyUsage_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (dateTime_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, dateTime_);
    }
    if (energyUsage_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(2, energyUsage_);
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
    if (!(obj instanceof ds.energymonitoring.EnergyUsageHistoryData)) {
      return super.equals(obj);
    }
    ds.energymonitoring.EnergyUsageHistoryData other = (ds.energymonitoring.EnergyUsageHistoryData) obj;

    boolean result = true;
    result = result && (getDateTime()
        == other.getDateTime());
    result = result && (
        java.lang.Float.floatToIntBits(getEnergyUsage())
        == java.lang.Float.floatToIntBits(
            other.getEnergyUsage()));
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
    hash = (37 * hash) + DATE_TIME_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getDateTime());
    hash = (37 * hash) + ENERGY_USAGE_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getEnergyUsage());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.energymonitoring.EnergyUsageHistoryData parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.energymonitoring.EnergyUsageHistoryData parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.energymonitoring.EnergyUsageHistoryData parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.energymonitoring.EnergyUsageHistoryData parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.energymonitoring.EnergyUsageHistoryData parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.energymonitoring.EnergyUsageHistoryData parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.energymonitoring.EnergyUsageHistoryData parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.energymonitoring.EnergyUsageHistoryData parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.energymonitoring.EnergyUsageHistoryData parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.energymonitoring.EnergyUsageHistoryData parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.energymonitoring.EnergyUsageHistoryData parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.energymonitoring.EnergyUsageHistoryData parseFrom(
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
  public static Builder newBuilder(ds.energymonitoring.EnergyUsageHistoryData prototype) {
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
   * Protobuf type {@code EnergyMonitoring.EnergyUsageHistoryData}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:EnergyMonitoring.EnergyUsageHistoryData)
      ds.energymonitoring.EnergyUsageHistoryDataOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.energymonitoring.EnergyMonitoringImpl.internal_static_EnergyMonitoring_EnergyUsageHistoryData_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.energymonitoring.EnergyMonitoringImpl.internal_static_EnergyMonitoring_EnergyUsageHistoryData_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.energymonitoring.EnergyUsageHistoryData.class, ds.energymonitoring.EnergyUsageHistoryData.Builder.class);
    }

    // Construct using ds.energymonitoring.EnergyUsageHistoryData.newBuilder()
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
      dateTime_ = 0L;

      energyUsage_ = 0F;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.energymonitoring.EnergyMonitoringImpl.internal_static_EnergyMonitoring_EnergyUsageHistoryData_descriptor;
    }

    @java.lang.Override
    public ds.energymonitoring.EnergyUsageHistoryData getDefaultInstanceForType() {
      return ds.energymonitoring.EnergyUsageHistoryData.getDefaultInstance();
    }

    @java.lang.Override
    public ds.energymonitoring.EnergyUsageHistoryData build() {
      ds.energymonitoring.EnergyUsageHistoryData result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.energymonitoring.EnergyUsageHistoryData buildPartial() {
      ds.energymonitoring.EnergyUsageHistoryData result = new ds.energymonitoring.EnergyUsageHistoryData(this);
      result.dateTime_ = dateTime_;
      result.energyUsage_ = energyUsage_;
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
      if (other instanceof ds.energymonitoring.EnergyUsageHistoryData) {
        return mergeFrom((ds.energymonitoring.EnergyUsageHistoryData)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.energymonitoring.EnergyUsageHistoryData other) {
      if (other == ds.energymonitoring.EnergyUsageHistoryData.getDefaultInstance()) return this;
      if (other.getDateTime() != 0L) {
        setDateTime(other.getDateTime());
      }
      if (other.getEnergyUsage() != 0F) {
        setEnergyUsage(other.getEnergyUsage());
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
      ds.energymonitoring.EnergyUsageHistoryData parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.energymonitoring.EnergyUsageHistoryData) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long dateTime_ ;
    /**
     * <code>int64 date_time = 1;</code>
     */
    public long getDateTime() {
      return dateTime_;
    }
    /**
     * <code>int64 date_time = 1;</code>
     */
    public Builder setDateTime(long value) {
      
      dateTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 date_time = 1;</code>
     */
    public Builder clearDateTime() {
      
      dateTime_ = 0L;
      onChanged();
      return this;
    }

    private float energyUsage_ ;
    /**
     * <code>float energy_usage = 2;</code>
     */
    public float getEnergyUsage() {
      return energyUsage_;
    }
    /**
     * <code>float energy_usage = 2;</code>
     */
    public Builder setEnergyUsage(float value) {
      
      energyUsage_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float energy_usage = 2;</code>
     */
    public Builder clearEnergyUsage() {
      
      energyUsage_ = 0F;
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


    // @@protoc_insertion_point(builder_scope:EnergyMonitoring.EnergyUsageHistoryData)
  }

  // @@protoc_insertion_point(class_scope:EnergyMonitoring.EnergyUsageHistoryData)
  private static final ds.energymonitoring.EnergyUsageHistoryData DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.energymonitoring.EnergyUsageHistoryData();
  }

  public static ds.energymonitoring.EnergyUsageHistoryData getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<EnergyUsageHistoryData>
      PARSER = new com.google.protobuf.AbstractParser<EnergyUsageHistoryData>() {
    @java.lang.Override
    public EnergyUsageHistoryData parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new EnergyUsageHistoryData(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<EnergyUsageHistoryData> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<EnergyUsageHistoryData> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.energymonitoring.EnergyUsageHistoryData getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
