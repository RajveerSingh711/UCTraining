package org.example.UC2;

public class Feet {

    private double value;

    public Feet(double value) {
        this.value = value;
    }

    public double toInches() {
        return value * 12;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Feet feet = (Feet) obj;
        return Double.compare(feet.value, value) == 0;
    }
}