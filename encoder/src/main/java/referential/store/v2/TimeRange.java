/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package referential.store.v2;  
@SuppressWarnings("all")
/** Range of time */
@org.apache.avro.specific.AvroGenerated
public class TimeRange extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TimeRange\",\"namespace\":\"referential.store.v2\",\"doc\":\"Range of time\",\"fields\":[{\"name\":\"begTime\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"Beginning time\",\"default\":null},{\"name\":\"endTime\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"Ending Time\",\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** Beginning time */
  @Deprecated public java.lang.String begTime;
  /** Ending Time */
  @Deprecated public java.lang.String endTime;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public TimeRange() {}

  /**
   * All-args constructor.
   */
  public TimeRange(java.lang.String begTime, java.lang.String endTime) {
    this.begTime = begTime;
    this.endTime = endTime;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return begTime;
    case 1: return endTime;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: begTime = (java.lang.String)value$; break;
    case 1: endTime = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'begTime' field.
   * Beginning time   */
  public java.lang.String getBegTime() {
    return begTime;
  }

  /**
   * Sets the value of the 'begTime' field.
   * Beginning time   * @param value the value to set.
   */
  public void setBegTime(java.lang.String value) {
    this.begTime = value;
  }

  /**
   * Gets the value of the 'endTime' field.
   * Ending Time   */
  public java.lang.String getEndTime() {
    return endTime;
  }

  /**
   * Sets the value of the 'endTime' field.
   * Ending Time   * @param value the value to set.
   */
  public void setEndTime(java.lang.String value) {
    this.endTime = value;
  }

  /** Creates a new TimeRange RecordBuilder */
  public static referential.store.v2.TimeRange.Builder newBuilder() {
    return new referential.store.v2.TimeRange.Builder();
  }
  
  /** Creates a new TimeRange RecordBuilder by copying an existing Builder */
  public static referential.store.v2.TimeRange.Builder newBuilder(referential.store.v2.TimeRange.Builder other) {
    return new referential.store.v2.TimeRange.Builder(other);
  }
  
  /** Creates a new TimeRange RecordBuilder by copying an existing TimeRange instance */
  public static referential.store.v2.TimeRange.Builder newBuilder(referential.store.v2.TimeRange other) {
    return new referential.store.v2.TimeRange.Builder(other);
  }
  
  /**
   * RecordBuilder for TimeRange instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TimeRange>
    implements org.apache.avro.data.RecordBuilder<TimeRange> {

    private java.lang.String begTime;
    private java.lang.String endTime;

    /** Creates a new Builder */
    private Builder() {
      super(referential.store.v2.TimeRange.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(referential.store.v2.TimeRange.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.begTime)) {
        this.begTime = data().deepCopy(fields()[0].schema(), other.begTime);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.endTime)) {
        this.endTime = data().deepCopy(fields()[1].schema(), other.endTime);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing TimeRange instance */
    private Builder(referential.store.v2.TimeRange other) {
            super(referential.store.v2.TimeRange.SCHEMA$);
      if (isValidValue(fields()[0], other.begTime)) {
        this.begTime = data().deepCopy(fields()[0].schema(), other.begTime);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.endTime)) {
        this.endTime = data().deepCopy(fields()[1].schema(), other.endTime);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'begTime' field */
    public java.lang.String getBegTime() {
      return begTime;
    }
    
    /** Sets the value of the 'begTime' field */
    public referential.store.v2.TimeRange.Builder setBegTime(java.lang.String value) {
      validate(fields()[0], value);
      this.begTime = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'begTime' field has been set */
    public boolean hasBegTime() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'begTime' field */
    public referential.store.v2.TimeRange.Builder clearBegTime() {
      begTime = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'endTime' field */
    public java.lang.String getEndTime() {
      return endTime;
    }
    
    /** Sets the value of the 'endTime' field */
    public referential.store.v2.TimeRange.Builder setEndTime(java.lang.String value) {
      validate(fields()[1], value);
      this.endTime = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'endTime' field has been set */
    public boolean hasEndTime() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'endTime' field */
    public referential.store.v2.TimeRange.Builder clearEndTime() {
      endTime = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public TimeRange build() {
      try {
        TimeRange record = new TimeRange();
        record.begTime = fieldSetFlags()[0] ? this.begTime : (java.lang.String) defaultValue(fields()[0]);
        record.endTime = fieldSetFlags()[1] ? this.endTime : (java.lang.String) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
