/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package org.kaaproject.kaa.schema.sample;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class DataCollection extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"DataCollection\",\"namespace\":\"org.kaaproject.kaa.schema.sample\",\"fields\":[{\"name\":\"power\",\"type\":\"double\"}],\"version\":1}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
   private double power;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use {@link \#newBuilder()}. 
   */
  public DataCollection() {}

  /**
   * All-args constructor.
   */
  public DataCollection(java.lang.Double power) {
    this.power = power;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return power;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: power = (java.lang.Double)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'power' field.
   */
  public java.lang.Double getPower() {
    return power;
  }

  /**
   * Sets the value of the 'power' field.
   * @param value the value to set.
   */
  public void setPower(java.lang.Double value) {
    this.power = value;
  }

  /** Creates a new DataCollection RecordBuilder */
  public static org.kaaproject.kaa.schema.sample.DataCollection.Builder newBuilder() {
    return new org.kaaproject.kaa.schema.sample.DataCollection.Builder();
  }
  
  /** Creates a new DataCollection RecordBuilder by copying an existing Builder */
  public static org.kaaproject.kaa.schema.sample.DataCollection.Builder newBuilder(org.kaaproject.kaa.schema.sample.DataCollection.Builder other) {
    return new org.kaaproject.kaa.schema.sample.DataCollection.Builder(other);
  }
  
  /** Creates a new DataCollection RecordBuilder by copying an existing DataCollection instance */
  public static org.kaaproject.kaa.schema.sample.DataCollection.Builder newBuilder(org.kaaproject.kaa.schema.sample.DataCollection other) {
    return new org.kaaproject.kaa.schema.sample.DataCollection.Builder(other);
  }
  
  /**
   * RecordBuilder for DataCollection instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<DataCollection>
    implements org.apache.avro.data.RecordBuilder<DataCollection> {

    private double power;

    /** Creates a new Builder */
    private Builder() {
      super(org.kaaproject.kaa.schema.sample.DataCollection.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(org.kaaproject.kaa.schema.sample.DataCollection.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.power)) {
        this.power = data().deepCopy(fields()[0].schema(), other.power);
        fieldSetFlags()[0] = true;
      }
    }
    
    /** Creates a Builder by copying an existing DataCollection instance */
    private Builder(org.kaaproject.kaa.schema.sample.DataCollection other) {
            super(org.kaaproject.kaa.schema.sample.DataCollection.SCHEMA$);
      if (isValidValue(fields()[0], other.power)) {
        this.power = data().deepCopy(fields()[0].schema(), other.power);
        fieldSetFlags()[0] = true;
      }
    }

    /** Gets the value of the 'power' field */
    public java.lang.Double getPower() {
      return power;
    }
    
    /** Sets the value of the 'power' field */
    public org.kaaproject.kaa.schema.sample.DataCollection.Builder setPower(double value) {
      validate(fields()[0], value);
      this.power = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'power' field has been set */
    public boolean hasPower() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'power' field */
    public org.kaaproject.kaa.schema.sample.DataCollection.Builder clearPower() {
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    public DataCollection build() {
      try {
        DataCollection record = new DataCollection();
        record.power = fieldSetFlags()[0] ? this.power : (java.lang.Double) defaultValue(fields()[0]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
