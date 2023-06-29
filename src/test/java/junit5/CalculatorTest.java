package junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private  Calculator calculator;

    @Test
    public void calculatorNotNullTest(){
        assertNull(calculator);
    }

}

