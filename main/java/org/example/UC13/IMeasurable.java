package org.example.UC13;

public interface IMeasurable {
    public double getConversionFactor();
    public double convertToBaseUnit(double value);
    public double convertFromBaseUnit(double baseValue);
    public String getUnitName();
}
