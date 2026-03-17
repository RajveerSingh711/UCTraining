package org.example.UC4;

import java.util.*;

public class QuantityLength {
    private final double value;
    private final LengthUnit unit;
    public QuantityLength(double value,LengthUnit unit){
        if(unit==null){
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value=value;
        this.unit=unit;
    }
    public double toInches(){
        return unit.toInches(value);
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(!(obj instanceof QuantityLength)) return false;
        QuantityLength other=(QuantityLength)obj;
        double thisInches=this.toInches();
        double otherInches=other.toInches();
        if(other.unit==null){
            throw new IllegalArgumentException("Unit cannot be null");
        }
        return Math.abs(thisInches-otherInches)<0.0001;
    }
    @Override
    public int hashCode(){
        return Objects.hash(toInches());
    }
}
