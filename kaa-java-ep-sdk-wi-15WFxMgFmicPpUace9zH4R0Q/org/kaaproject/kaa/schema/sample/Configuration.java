/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package org.kaaproject.kaa.schema.sample;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Configuration extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Configuration\",\"namespace\":\"org.kaaproject.kaa.schema.sample\",\"fields\":[{\"name\":\"samplePeriod\",\"type\":\"int\",\"by_default\":1}],\"version\":1}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
   private int samplePeriod;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use {@link \#newBuilder()}. 
   */
  public Configuration() {}

  /**
   * All-args constructor.
   */
  public Configuration(java.lang.Integer samplePeriod) {
    this.samplePeriod = samplePeriod;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return samplePeriod;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: samplePeriod = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'samplePeriod' field.
   */
  public java.lang.Integer getSamplePeriod() {
    return samplePeriod;
  }

  /**
   * Sets the value of the 'samplePeriod' field.
   * @param value the value to set.
   */
  public void setSamplePeriod(java.lang.Integer value) {
    this.samplePeriod = value;
  }

  /** Creates a new Configuration RecordBuilder */
  public static org.kaaproject.kaa.schema.sample.Configuration.Builder newBuilder() {
    return new org.kaaproject.kaa.schema.sample.Configuration.Builder();
  }
  
  /** Creates a new Configuration RecordBuilder by copying an existing Builder */
  public static org.kaaproject.kaa.schema.sample.Configuration.Builder newBuilder(org.kaaproject.kaa.schema.sample.Configuration.Builder other) {
    return new org.kaaproject.kaa.schema.sample.Configuration.Builder(other);
  }
  
  /** Creates a new Configuration RecordBuilder by copying an existing Configuration instance */
  public static org.kaaproject.kaa.schema.sample.Configuration.Builder newBuilder(org.kaaproject.kaa.schema.sample.Configuration other) {
    return new org.kaaproject.kaa.schema.sample.Configuration.Builder(other);
  }
  
  /**
   * RecordBuilder for Configuration instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Configuration>
    implements org.apache.avro.data.RecordBuilder<Configuration> {

    private int samplePeriod;

    /** Creates a new Builder */
    private Builder() {
      super(org.kaaproject.kaa.schema.sample.Configuration.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(org.kaaproject.kaa.schema.sample.Configuration.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.samplePeriod)) {
        this.samplePeriod = data().deepCopy(fields()[0].schema(), other.samplePeriod);
        fieldSetFlags()[0] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Configuration instance */
    private Builder(org.kaaproject.kaa.schema.sample.Configuration other) {
            super(org.kaaproject.kaa.schema.sample.Configuration.SCHEMA$);
      if (isValidValue(fields()[0], other.samplePeriod)) {
        this.samplePeriod = data().deepCopy(fields()[0].schema(), other.samplePeriod);
        fieldSetFlags()[0] = true;
      }
    }

    /** Gets the value of the 'samplePeriod' field */
    public java.lang.Integer getSamplePeriod() {
      return samplePeriod;
    }
    
    /** Sets the value of the 'samplePeriod' field */
    public org.kaaproject.kaa.schema.sample.Configuration.Builder setSamplePeriod(int value) {
      validate(fields()[0], value);
      this.samplePeriod = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'samplePeriod' field has been set */
    public boolean hasSamplePeriod() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'samplePeriod' field */
    public org.kaaproject.kaa.schema.sample.Configuration.Builder clearSamplePeriod() {
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    public Configuration build() {
      try {
        Configuration record = new Configuration();
        record.samplePeriod = fieldSetFlags()[0] ? this.samplePeriod : (java.lang.Integer) defaultValue(fields()[0]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}