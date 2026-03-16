package org.example.UC2;

public class QuantityMeasurementApp{
    public static boolean checkFeetEquality(double v1,double v2){
        Feet f1=new Feet(v1);
        Feet f2=new Feet(v2);
        return f1.equals(f2);
    }
    public static boolean checkInchEquality(double v1,double v2){
        Inches i1=new Inches(v1);
        Inches i2=new Inches(v2);
        return i1.equals(i2);
    }
    public static boolean compareFeetAndInches(double feet,double inches){
        Feet f=new Feet(feet);
        Inches i=new Inches(inches);
        return Double.compare(f.toInches(),i.toInches())==0;
    }
}