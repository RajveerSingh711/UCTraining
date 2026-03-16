package UC2;
import org.example.UC2.QuantityMeasurementApp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest{
    @Test
    void testEquality_SameValue(){
        assertTrue(QuantityMeasurementApp.checkFeetEquality(1.0,1.0));
        assertTrue(QuantityMeasurementApp.checkInchEquality(1.0,1.0));
    }
    @Test
    void testEquality_DifferentValue(){
        assertFalse(QuantityMeasurementApp.checkFeetEquality(1.0,2.0));
        assertFalse(QuantityMeasurementApp.checkInchEquality(1.0,2.0));
    }
    @Test
    void testEquality_NullComparison(){
        assertThrows(NullPointerException.class,()->new org.example.UC2.Feet(Double.parseDouble(null)));
    }
    @Test
    void testEquality_SameReference(){
        org.example.UC2.Feet f=new org.example.UC2.Feet(1.0);
        assertTrue(f.equals(f));
    }
    @Test
    void testFeetToInchComparison(){
        assertTrue(QuantityMeasurementApp.compareFeetAndInches(1.0,12.0));
    }
}