package com.bazusoft.autounit;

/**
 * Created by BSaladra on 31.12.2016.
 */
public class MockField {


    private final Class<Integer> fieldClass;
    private final String fieldName;

    public MockField(Class fieldClass, String fieldName) {

        this.fieldClass = fieldClass;
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return "MockField{" +
                "fieldClass=" + fieldClass +
                ", fieldName='" + fieldName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MockField mockField = (MockField) o;

        if (fieldClass != null ? !fieldClass.equals(mockField.fieldClass) : mockField.fieldClass != null) return false;
        return fieldName != null ? fieldName.equals(mockField.fieldName) : mockField.fieldName == null;

    }

    @Override
    public int hashCode() {
        int result = fieldClass != null ? fieldClass.hashCode() : 0;
        result = 31 * result + (fieldName != null ? fieldName.hashCode() : 0);
        return result;
    }
}
