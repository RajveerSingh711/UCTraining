package UC4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.UC4.*;

public class QuantityLengthTest{
    @Test
    void testYardToFeet(){
        assertEquals(
                new QuantityLength(1,LengthUnit.YARDS),
                new QuantityLength(3,LengthUnit.FEET)
        );
    }
    @Test
    void testCmToInches(){
        assertEquals(
                new QuantityLength(1,LengthUnit.CENTIMETERS),
                new QuantityLength(0.393701,LengthUnit.INCHES)
        );
    }
    @Test
    void testNotEqual(){
        assertNotEquals(
                new QuantityLength(1,LengthUnit.CENTIMETERS),
                new QuantityLength(1,LengthUnit.FEET)
        );
    }
}