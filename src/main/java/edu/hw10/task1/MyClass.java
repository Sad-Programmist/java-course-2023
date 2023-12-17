package edu.hw10.task1;

import java.util.Objects;

public class MyClass {

    private int intValue;
    private String stringValue;

    public MyClass() {
    }

    public static MyClass create() {
        return new MyClass();
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return "MyClass{"
            + "intValue=" + intValue
            + ", stringValue=" + stringValue
            + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyClass myClass = (MyClass) o;
        return intValue == myClass.intValue && Objects.equals(stringValue, myClass.stringValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intValue, stringValue);
    }
}
