package junit5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperaturaCalculatorTest {
    private TemperaturaCalculator temperaturaCalculator;

    @BeforeEach
    public void setUp(){
        temperaturaCalculator = new TemperaturaCalculator();
        System.out.println("@BeforeEach -> setUp()");
    }

    @AfterEach
    public void tearDown(){
        temperaturaCalculator=null;
        System.out.println("@AfterEach -> tearDown()");
    }

    @Test
    public void toFahreheitTest(){
        assertEquals(-9.4, temperaturaCalculator.toFahrenheit(-23, 0.01));
    }
}