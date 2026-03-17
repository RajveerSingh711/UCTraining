package UC4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.UC4.*;

public class QuantityLengthTest{
    @Test
    void testEquality_YardToYard_SameValue(){
        QuantityLength q1=new QuantityLength(1.0,LengthUnit.YARDS);
        QuantityLength q2=new QuantityLength(1.0,LengthUnit.YARDS);
        assertEquals(q1,q2);
    }
    @Test
    void testEquality_YardToYard_DifferentValue(){
        QuantityLength q1=new QuantityLength(1.0,LengthUnit.YARDS);
        QuantityLength q2=new QuantityLength(2.0,LengthUnit.YARDS);
        assertNotEquals(q1,q2);
    }
    @Test
    void testEquality_YardToFeet_EquivalentValue(){
        QuantityLength yard=new QuantityLength(1.0,LengthUnit.YARDS);
        QuantityLength feet=new QuantityLength(3.0,LengthUnit.FEET);
        assertEquals(yard,feet);
    }
    @Test
    void testEquality_FeetToYard_EquivalentValue(){
        QuantityLength feet=new QuantityLength(3.0,LengthUnit.FEET);
        QuantityLength yard=new QuantityLength(1.0,LengthUnit.YARDS);
        assertEquals(feet,yard);
    }
    @Test
    void testEquality_YardToInches_EquivalentValue(){
        QuantityLength yard=new QuantityLength(1.0,LengthUnit.YARDS);
        QuantityLength inches=new QuantityLength(36.0,LengthUnit.INCHES);
        assertEquals(yard,inches);
    }

    @Test
    void testEquality_InchesToYard_EquivalentValue(){
        QuantityLength inches=new QuantityLength(36.0,LengthUnit.INCHES);
        QuantityLength yard=new QuantityLength(1.0,LengthUnit.YARDS);
        assertEquals(inches,yard);
    }
    @Test
    void testEquality_YardToFeet_NonEquivalentValue(){
        QuantityLength yard=new QuantityLength(1.0,LengthUnit.YARDS);
        QuantityLength feet=new QuantityLength(2.0,LengthUnit.FEET);
        assertNotEquals(yard,feet);
    }
    @Test
    void testEquality_CentimeterToCentimeter_SameValue(){
        QuantityLength c1=new QuantityLength(2.0,LengthUnit.CENTIMETERS);
        QuantityLength c2=new QuantityLength(2.0,LengthUnit.CENTIMETERS);
        assertEquals(c1,c2);
    }
    @Test
    void testEquality_CentimeterToCentimeter_DifferentValue(){
        QuantityLength c1=new QuantityLength(1.0,LengthUnit.CENTIMETERS);
        QuantityLength c2=new QuantityLength(2.0,LengthUnit.CENTIMETERS);
        assertNotEquals(c1,c2);
    }
    @Test
    void testEquality_CentimeterToInches_EquivalentValue(){
        QuantityLength cm=new QuantityLength(1.0,LengthUnit.CENTIMETERS);
        QuantityLength inches=new QuantityLength(0.393701,LengthUnit.INCHES);
        assertEquals(cm,inches);
    }
    @Test
    void testEquality_CentimeterToFeet_NonEquivalentValue(){
        QuantityLength cm=new QuantityLength(1.0,LengthUnit.CENTIMETERS);
        QuantityLength feet=new QuantityLength(1.0,LengthUnit.FEET);
        assertNotEquals(cm,feet);
    }
    @Test
    void testEquality_MultiUnit_TransitiveProperty(){
        QuantityLength yard=new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength feet=new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength inches=new QuantityLength(36.0, LengthUnit.INCHES);
        assertEquals(yard,feet);
        assertEquals(feet,inches);
        assertEquals(yard,inches);
    }
    @Test
    void testEquality_YardSameReference(){
        QuantityLength yard=new QuantityLength(1.0,LengthUnit.YARDS);
        assertEquals(yard,yard);
    }
    @Test
    void testEquality_YardNullComparison(){
        QuantityLength yard=new QuantityLength(1.0,LengthUnit.YARDS);
        assertNotEquals(yard,null);
    }
    @Test
    void testEquality_YardWithNullUnit(){
        QuantityLength yard=new QuantityLength(1.0,LengthUnit.YARDS);
        assertNotEquals(yard,null);
    }
    @Test
    void testEquality_CentimeterSameReference(){
        QuantityLength cm=new QuantityLength(2.0,LengthUnit.CENTIMETERS);
        assertEquals(cm,cm);
    }
    @Test
    void testEquality_CentimeterNullComparison(){
        QuantityLength cm=new QuantityLength(2.0,LengthUnit.CENTIMETERS);
        assertNotEquals(cm,null);
    }
    @Test
    void testConstructor_CentimeterWithNullUnit_ShouldThrowException(){
        assertThrows(IllegalArgumentException.class,()->{
            new QuantityLength(1.0,null);
        });
    }
    @Test
    void testEquality_AllUnits_ComplexScenario(){
        QuantityLength yard=new QuantityLength(2.0,LengthUnit.YARDS);
        QuantityLength feet=new QuantityLength(6.0,LengthUnit.FEET);
        QuantityLength inches=new QuantityLength(72.0,LengthUnit.INCHES);
        assertEquals(yard,feet);
        assertEquals(feet,inches);
        assertEquals(yard,inches);
    }
}