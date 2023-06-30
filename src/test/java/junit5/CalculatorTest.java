package junit5;

import org.junit.After;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private  Calculator calculator;
    private Calculator calculatorNull;
    private static Calculator calculatorStatic;

    @BeforeAll
    public static void beforeAllTest(){
        calculatorStatic = new Calculator();
        System.out.println("@BeforeAll -> beforeAllTest()");

    }

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
        System.out.println("@BeforeEach -> setUp()");
    }

    /*@AfterEach
    public void tearDown(){
        calculator=null;
        System.out.println("@AfterEach -> tearDown()");
    }*/

    @AfterAll
    public static void afterAllTest(){
        calculatorStatic = null;
        System.out.println("@AfterAll -> afterAllTest()");

    }

    @Test
    public void calculatorNotNullTest(){
        calculator=new Calculator();
        assertNotNull(calculator);
        System.out.println("@Test -> calculatorNotNullTest()");
    }
    @Test
    public void setCalculatorTest(){
        assertNull(calculatorNull);
        System.out.println("@Test -> calculatorNullTest()");

    }

    @Test
    public void addAssertTest(){
        //1.SetUp
        Calculator calculatorAssert = new Calculator();
        int resultadoEsperado = 30;
        int resultadoActual;
        //2. Action
        resultadoActual= calculatorAssert.add(10,20);
        //3.Assert
        assertEquals(resultadoEsperado, resultadoActual);
        System.out.println("@Test -> addAsertTest()");
    }
    @Test
    public void addTest(){
        assertEquals(30, calculator.add(10,20));
    }

    @Test
    public void assertTypesTest(){
        assertTrue(1 == 1);
        //assertTrue(1==2);

        assertNull(calculatorNull);
        assertNotNull(calculator);

        Calculator calculator1 = new Calculator();
        Calculator calculator2 = new Calculator();
        //Calculator calculator3 = new calculator1;

        //assertSame(calculator1,calculator3);
        assertSame(calculator1,calculator2);
        //assertNotSame(calculator1,calculator3);

        assertEquals("alberto", "alberto");
        //assertEquals("alberto", "alberto", "Ha fallado nuestro metodo String");

        assertEquals(1,1.4, 0.5);
        //assertEquals(1,1.6, 0.5); Este falla porque viene 1.6
    }
    @Test
    public void add_ValidInput_ValidExpected_Test(){
        assertEquals(11, calculator.add(7,4));
    }
    @Test
    public void substract_ValidInput_ValidExpected_Test(){
        assertEquals(11, calculator.substract(15,4));
    }
    @Test
    public void substract_ValidNegativeResultExpected_Test(){
        assertEquals(-10, calculator.substract(15,4));
    }
    @Test
    public void divide_ValidInput_ValidResultExpected_Test(){
        assertEquals(2, calculator.divide(10,5));
    }

    @Test
    public void divide_InValidInput_Test(){
        fail("Fallo detectado manualmente - No se puede dividir por cero");
        calculator.divide(10,0);
    }

    @Test
    public void divide_InValidInput_ExpectedException_Test(){
        fail("Fallo detectado manualmente - No se puede dividir por cero");
        calculator.divide(10,0);
    }
    @Test
    public void divide_InValid_ExpectedException_Test(){
        assertThrows(ArithmeticException.class,()->calculator.divideByZero(2,0),"No se puede dividir entre cero");
    }

    @Disabled("Disabled unitl bug 23 be resolve")
    @Test
    public void divide_InvalidInput_Test_Tes(){
        assertEquals(2, calculator.divide(5,0));
    }

    @Test
    @DisplayName("Método Dividir -> Funciona😊")
    public void divide_ValidInput_ValidResultExpected_Name_Test(){
        assertEquals(2, calculator.divide(10,5));
    }

    @Test
    public void add_Assert_All_Test(){
        assertAll(
                ()->assertEquals(31,calculator.add(11,20)),
                ()->assertEquals(20,calculator.add(10,20)),
                ()->assertEquals(2,calculator.add(1,1))
        );
    }
    @Nested
    class AddTest{
        @Test
        public void add_Positive_Test(){
            assertEquals(30,calculator.add(15,15));
        }
        @Test
        public void add_Negative_Test(){
            assertEquals(-30,calculator.add(-15,-15));
        }
        @Test
        public void add_Zero_Test(){
            assertEquals(0,calculator.add(0,0));
        }

        @ParameterizedTest(name= "{index} => a ={0}, b={1}, sum={2}")
        @MethodSource("addProviderData")
        public void addParameterizedTest(int a, int b, int sum){
            assertEquals(sum, calculator.add(a,b));
        }

        private static Stream<Arguments> addProviderData(){
            return Stream.of(
            Arguments.of(6,2,8),
                    Arguments.of(-6,-2,-8),
                    Arguments.of(6,-2,4),
                    Arguments.of(-6,2,-4),
                    Arguments.of(6,0,6)
                    );
        }

        /*@Test
        public void timeOut_Test(){
            assertTimeout(Duration.ofMillis(500), () ->{
                calculator.longTaskOperation();
            });
        }*/

    }
}

