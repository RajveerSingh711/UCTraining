package org.example.UC10;

public interface IMeasurable {
    public double getConversionFactor();
    public double convertToBaseUnit(double value);
    public double convertFromBaseUnit(double baseValue);
    public String getUnitName();
}
