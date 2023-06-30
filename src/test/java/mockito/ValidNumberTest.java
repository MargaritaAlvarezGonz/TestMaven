package mockito;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidNumberTest {
    private ValidNumber validNumber;

    @BeforeEach
    public void setUp(){
        validNumber=null;
    }

    @AfterEach
    public void tearDown(){
        validNumber=null;
    }

    @Test
    public void checkTest(){
        assertEquals(true,validNumber.check(5));
    }

    @Test
    public void checkNegativeTest(){
        assertEquals(false,validNumber.check(-5));
    }

    @Test
    public void checkStringTest(){
        assertEquals(false,validNumber.check("5"));
    }

    @Test
    public void checkZeroTest(){
        assertEquals(true,validNumber.check(-57));
    }

    @Test
    public void checkZeroStringTest(){
        assertEquals(false,validNumber.check("5"));
    }

    @Test
    public void checkZerp0Test(){
        assertThrows(ArithmeticException.class, ()->validNumber.checkZero(0));
    }
    @Test
    public void doubleToIntTest(){
        assertEquals((9, validNumber.doubleToIntTest(9.99)));
    }



}