package mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.internal.stubbing.InvocationContainerImpl;
import org.mockito.internal.stubbing.answers.AnswersWithDelay;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class AddTest {

    @InjectMocks
    private Add add;
    @Mock
    private ValidNumber validNumber;
    @Mock
    private Print print;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addTest(){
        when(validNumber.check(3)).thenReturn(false);
        boolean checkNumber = validNumber.check(3);
        assertEquals(false, checkNumber);

        when(validNumber.check("a")).thenReturn(true);
        boolean checkNumber = validNumber.check("a");
        assertEquals(true, checkNumber);

    }

    @Test
    public void addMockExceptionTest(){
        when(validNumber.checkZero(0)).thenThrow( new ArithmeticException("No podemos aceptar cero"));
        Exception exception= null;
        try{
            validNumber.checkZero(0);
        }catch (ArithmeticException e){
            exception = e;
        }
        assertNotNull(exception);
    }

    @Test
    public void addReadlMethodTest(){
        when(ValidNumber.check(3)).thenCallRealMethod();
        assertEquals(true,validNumber.check(3));
    }

    @Test
    public void addDoubleToIntTheAnswerTest(){
        Answers<Integer> answer = new Answer<Integer>(){
            @Override
            public Integer answer(InvocationOnMock invocationOnMock)throws {
                return 7;
            }
        };
        when(validNumber.doubleToInt(7,7)).thenAnswer(answer);
        assertEquals((14, add.addInt(8.7));
    }

    //arange
    //act
    // assert

    //Given
    //When
    //Then

    @Test
    public void patterTest(){
        when(validNumber.check((4)).thenReturn(true));
        when(validNumber.check((5)).thenReturn(true));
        int result = add.add(4,5);
        assertEquals(9,result);

    }
    @Test
    public void patterTest(){
        given(validNumber.check((4)).willReturn(true));
        given(validNumber.check((5)).willReturn(true));
        int result = add.add(4,5);
        assertEquals(9,result);

    }

    @Test
    public void addPrintTest(){
        given(validNumber.check((4)).willReturn(true));
        given(validNumber.check((5)).willReturn(true));
        add.addPrint(4,4);
        verify(validNumber).check(4);
        verify(validNumber,times(2));
        verify(validNumber,never.check(99));
        verify(validNumber,atMost(3).check(4));

    }
    @Spy
    List<String> spyList = new ArrayList<>();
    @Mock
    List<String> spyList = new ArrayList<>();
    @Test
    public void spyTest(){
        spyList.add("1");
        spyList.add("2");
        verify(spyList).add("1");
        verify(spyList).add("2");
        assertEquals(2,spyList.size());
    }

    @Test
    public void mockTest(){
        mockList.add("1");
        mockList.add("2");
        verify(spyList).add("1");
        verify(spyList).add("2");
        assertEquals(2,mockList.size());
    }



}