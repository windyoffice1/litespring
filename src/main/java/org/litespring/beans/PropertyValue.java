package org.litespring.beans;

public class PropertyValue {
    private String name;
    private Object value;
    private boolean converted=false;
    private Object ConvertedValue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getConvertedValue() {
        return ConvertedValue;
    }

    public void setConvertedValue(Object convertedValue) {
        ConvertedValue = convertedValue;
    }

    public synchronized  boolean isConverted(){
        return this.converted;
    }
}
