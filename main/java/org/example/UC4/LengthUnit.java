package org.example.UC4;

public enum LengthUnit {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);
    private final double toInches;
    LengthUnit(double toInches){
        this.toInches=toInches;
    }
    public double toInches(double value){
        return value*toInches;
    }
}
