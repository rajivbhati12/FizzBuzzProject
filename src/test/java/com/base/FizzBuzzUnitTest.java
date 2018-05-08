package com.base;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.reset;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FizzBuzz.class)
public class FizzBuzzUnitTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void setUp(){
        fizzBuzz = mock(FizzBuzz.class,CALLS_REAL_METHODS);
    }

    @Test
    public void test_fizzbuzz_class_exists() {
        try {
            Class.forName("com.base.FizzBuzz");
        } catch (Exception e) {
            Assert.fail("FizzBuzz class not found under package: com.base");
        }
    }


    @Test
    public void test_resultProducer_should_return_valid_response() throws Throwable{
        when(fizzBuzz,"fizzBuzzResolver",anyInt()).thenReturn("1","2","lucky","4","buzz","fizz");
        when(fizzBuzz,"produceReport").thenReturn("fizz: 1 buzz: 1 fizzbuzz: 0 lucky: 1 integer: 3");
        Whitebox.setInternalState(fizzBuzz,"lowerValue",1);
        Whitebox.setInternalState(fizzBuzz,"upperValue",6);
        Assert.assertEquals("1 2 lucky 4 buzz fizz\nfizz: 1 buzz: 1 fizzbuzz: 0 lucky: 1 integer: 3",
                fizzBuzz.resultProducer());
        reset(fizzBuzz);
    }

    @Test
    public void test_fizzBuzzResolver_should_return_lucky() throws Throwable{
        Assert.assertEquals("lucky", Whitebox.invokeMethod(fizzBuzz,"fizzBuzzResolver",3));
        reset(fizzBuzz);
    }

    @Test
    public void test_fizzBuzzResolver_should_return_fizz() throws Throwable{
        Assert.assertEquals("fizz", Whitebox.invokeMethod(fizzBuzz,"fizzBuzzResolver",6));
        reset(fizzBuzz);
    }

    @Test
    public void test_fizzBuzzResolver_should_return_buzz() throws Throwable{
        Assert.assertEquals("buzz", Whitebox.invokeMethod(fizzBuzz,"fizzBuzzResolver",5));
        reset(fizzBuzz);
    }

    @Test
    public void test_fizzBuzzResolver_should_return_fizzbuzz() throws Throwable{
        Assert.assertEquals("fizzbuzz", Whitebox.invokeMethod(fizzBuzz,"fizzBuzzResolver",15));
        reset(fizzBuzz);
    }

    @Test
    public void test_fizzBuzzResolver_should_return_integer() throws Throwable{
        Assert.assertEquals("1", Whitebox.invokeMethod(fizzBuzz,"fizzBuzzResolver",1));
        reset(fizzBuzz);
    }

    @Test
    public void test_fizzBuzzResolver_should_return_zero() throws Throwable{
        Assert.assertEquals("0", Whitebox.invokeMethod(fizzBuzz,"fizzBuzzResolver",0));
        reset(fizzBuzz);
    }

    @Test
    public void test_getCount_should_return_number_of_occurance_for_fizz() throws Throwable{
        Whitebox.setInternalState(fizzBuzz,"result","1 2 lucky 4 buzz fizz 7 8 fizz fizzbuzz");
        Assert.assertEquals((Object) 2 , Whitebox.invokeMethod(fizzBuzz,"getCount","fizz"));
        reset(fizzBuzz);
    }

    @Test
    public void test_getCount_should_return_number_of_occurance_for_buzz() throws Throwable{
        Whitebox.setInternalState(fizzBuzz,"result","1 2 lucky 4 fizz 7 8 fizz fizzbuzz");
        Assert.assertEquals((Object) 0 , Whitebox.invokeMethod(fizzBuzz,"getCount","buzz"));
        reset(fizzBuzz);
    }

    @Test
    public void test_getCount_should_return_number_of_occurance_for_fizzbuzz() throws Throwable{
        Whitebox.setInternalState(fizzBuzz,"result","1 2 lucky 4 buzz fizz 7 8 fizz fizzbuzz");
        Assert.assertEquals((Object) 1 , Whitebox.invokeMethod(fizzBuzz,"getCount","fizzbuzz"));
        reset(fizzBuzz);
    }

    @Test
    public void test_getCount_should_return_zero_for_empty_result() throws Throwable{
        Whitebox.setInternalState(fizzBuzz,"result","");
        Assert.assertEquals((Object) 0 , Whitebox.invokeMethod(fizzBuzz,"getCount","fizzbuzz"));
        reset(fizzBuzz);
    }

    @Test
    public void test_produceReport_should_return_valid_report() throws Throwable{
        Whitebox.setInternalState(fizzBuzz,"result","1 2 lucky 4 buzz fizz 7 8 fizz fizzbuzz");
        when(fizzBuzz,"getCount","fizz").thenReturn(2);
        when(fizzBuzz,"getCount","buzz").thenReturn(1);
        when(fizzBuzz,"getCount","fizzbuzz").thenReturn(1);
        when(fizzBuzz,"getCount","lucky").thenReturn(1);
        Assert.assertEquals("fizz: 2 buzz: 1 fizzbuzz: 1 lucky: 1 integer: 5" ,
                Whitebox.invokeMethod(fizzBuzz,"produceReport"));
        reset(fizzBuzz);
    }

    @Test
    public void test_produceReport_should_return_empty_report_for_empty_result() throws Throwable{
        Whitebox.setInternalState(fizzBuzz,"result","");
        Assert.assertEquals("fizz: 0 buzz: 0 fizzbuzz: 0 lucky: 0 integer: 0" ,
                Whitebox.invokeMethod(fizzBuzz,"produceReport"));
        reset(fizzBuzz);
    }
}