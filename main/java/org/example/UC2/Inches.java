package org.example.UC2;

public class Inches{
    private double value;
    public Inches(double value){
        this.value=value;
    }
    public double toInches(){
        return value;
    }

    @Override
    public boolean equals(Object obj){
        if (this==obj) return true;
        if (obj==null || getClass()!=obj.getClass()) return false;
        Inches inches=(Inches) obj;
        return Double.compare(inches.value,value)==0;
    }
}