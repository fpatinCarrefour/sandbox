/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package common.lib.v1;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class GeoLocation extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"GeoLocation\",\"namespace\":\"common.lib.v1\",\"fields\":[{\"name\":\"geoLocType\",\"type\":{\"type\":\"enum\",\"name\":\"GeoLocType\",\"symbols\":[\"GPS\",\"LCC\",\"UTM\"]},\"default\":\"GPS\"},{\"name\":\"geoX\",\"type\":\"double\",\"default\":0},{\"name\":\"geoY\",\"type\":\"double\",\"default\":0}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public common.lib.v1.GeoLocType geoLocType;
  @Deprecated public double geoX;
  @Deprecated public double geoY;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public GeoLocation() {}

  /**
   * All-args constructor.
   */
  public GeoLocation(common.lib.v1.GeoLocType geoLocType, java.lang.Double geoX, java.lang.Double geoY) {
    this.geoLocType = geoLocType;
    this.geoX = geoX;
    this.geoY = geoY;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return geoLocType;
    case 1: return geoX;
    case 2: return geoY;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: geoLocType = (common.lib.v1.GeoLocType)value$; break;
    case 1: geoX = (java.lang.Double)value$; break;
    case 2: geoY = (java.lang.Double)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'geoLocType' field.
   */
  public common.lib.v1.GeoLocType getGeoLocType() {
    return geoLocType;
  }

  /**
   * Sets the value of the 'geoLocType' field.
   * @param value the value to set.
   */
  public void setGeoLocType(common.lib.v1.GeoLocType value) {
    this.geoLocType = value;
  }

  /**
   * Gets the value of the 'geoX' field.
   */
  public java.lang.Double getGeoX() {
    return geoX;
  }

  /**
   * Sets the value of the 'geoX' field.
   * @param value the value to set.
   */
  public void setGeoX(java.lang.Double value) {
    this.geoX = value;
  }

  /**
   * Gets the value of the 'geoY' field.
   */
  public java.lang.Double getGeoY() {
    return geoY;
  }

  /**
   * Sets the value of the 'geoY' field.
   * @param value the value to set.
   */
  public void setGeoY(java.lang.Double value) {
    this.geoY = value;
  }

  /** Creates a new GeoLocation RecordBuilder */
  public static common.lib.v1.GeoLocation.Builder newBuilder() {
    return new common.lib.v1.GeoLocation.Builder();
  }
  
  /** Creates a new GeoLocation RecordBuilder by copying an existing Builder */
  public static common.lib.v1.GeoLocation.Builder newBuilder(common.lib.v1.GeoLocation.Builder other) {
    return new common.lib.v1.GeoLocation.Builder(other);
  }
  
  /** Creates a new GeoLocation RecordBuilder by copying an existing GeoLocation instance */
  public static common.lib.v1.GeoLocation.Builder newBuilder(common.lib.v1.GeoLocation other) {
    return new common.lib.v1.GeoLocation.Builder(other);
  }
  
  /**
   * RecordBuilder for GeoLocation instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<GeoLocation>
    implements org.apache.avro.data.RecordBuilder<GeoLocation> {

    private common.lib.v1.GeoLocType geoLocType;
    private double geoX;
    private double geoY;

    /** Creates a new Builder */
    private Builder() {
      super(common.lib.v1.GeoLocation.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(common.lib.v1.GeoLocation.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.geoLocType)) {
        this.geoLocType = data().deepCopy(fields()[0].schema(), other.geoLocType);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.geoX)) {
        this.geoX = data().deepCopy(fields()[1].schema(), other.geoX);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.geoY)) {
        this.geoY = data().deepCopy(fields()[2].schema(), other.geoY);
        fieldSetFlags()[2] = true;
      }
    }
    
    /** Creates a Builder by copying an existing GeoLocation instance */
    private Builder(common.lib.v1.GeoLocation other) {
            super(common.lib.v1.GeoLocation.SCHEMA$);
      if (isValidValue(fields()[0], other.geoLocType)) {
        this.geoLocType = data().deepCopy(fields()[0].schema(), other.geoLocType);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.geoX)) {
        this.geoX = data().deepCopy(fields()[1].schema(), other.geoX);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.geoY)) {
        this.geoY = data().deepCopy(fields()[2].schema(), other.geoY);
        fieldSetFlags()[2] = true;
      }
    }

    /** Gets the value of the 'geoLocType' field */
    public common.lib.v1.GeoLocType getGeoLocType() {
      return geoLocType;
    }
    
    /** Sets the value of the 'geoLocType' field */
    public common.lib.v1.GeoLocation.Builder setGeoLocType(common.lib.v1.GeoLocType value) {
      validate(fields()[0], value);
      this.geoLocType = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'geoLocType' field has been set */
    public boolean hasGeoLocType() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'geoLocType' field */
    public common.lib.v1.GeoLocation.Builder clearGeoLocType() {
      geoLocType = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'geoX' field */
    public java.lang.Double getGeoX() {
      return geoX;
    }
    
    /** Sets the value of the 'geoX' field */
    public common.lib.v1.GeoLocation.Builder setGeoX(double value) {
      validate(fields()[1], value);
      this.geoX = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'geoX' field has been set */
    public boolean hasGeoX() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'geoX' field */
    public common.lib.v1.GeoLocation.Builder clearGeoX() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'geoY' field */
    public java.lang.Double getGeoY() {
      return geoY;
    }
    
    /** Sets the value of the 'geoY' field */
    public common.lib.v1.GeoLocation.Builder setGeoY(double value) {
      validate(fields()[2], value);
      this.geoY = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'geoY' field has been set */
    public boolean hasGeoY() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'geoY' field */
    public common.lib.v1.GeoLocation.Builder clearGeoY() {
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public GeoLocation build() {
      try {
        GeoLocation record = new GeoLocation();
        record.geoLocType = fieldSetFlags()[0] ? this.geoLocType : (common.lib.v1.GeoLocType) defaultValue(fields()[0]);
        record.geoX = fieldSetFlags()[1] ? this.geoX : (java.lang.Double) defaultValue(fields()[1]);
        record.geoY = fieldSetFlags()[2] ? this.geoY : (java.lang.Double) defaultValue(fields()[2]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
