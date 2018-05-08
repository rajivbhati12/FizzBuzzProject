package com.base;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(PowerMockRunner.class)
public class FizzBuzzIntegrationTest {

    @Rule
    public final TestName testName = new TestName();

    private final Logger fizzBuzzTestLogger = LoggerFactory.getLogger(FizzBuzzIntegrationTest.class);

    @Test
    public void test_fizzbuzz_class_exists() {
        fizzBuzzTestLogger.info(testName.getMethodName());
        try {
            Class.forName("com.base.FizzBuzz");
        } catch (Exception e) {
            Assert.fail("FizzBuzz class not found under package: com.base");
        }
    }

    @Test
    public void test_output_should_produce_contiguous_range_of_integers() throws Throwable {
        String produceResult = (new FizzBuzz(-1, 2)).resultProducer();
        Assert.assertEquals("FizzBuzz failed to produce contiguous range of integers from range: -1 - 2",
                "-1 0 1 2\nfizz: 0 buzz: 0 fizzbuzz: 0 lucky: 0 integer: 4",
                produceResult);
        fizzBuzzTestLogger.info(testName.getMethodName() + "\n" + produceResult);
    }

    @Test
    public void test_multiple_of_3_should_produce_fizz() throws Throwable {
        String produceResult = (new FizzBuzz(6, 8)).resultProducer();
        Assert.assertEquals("FizzBuzz failed to produce fizz for multiples of 3 from range: 6 - 8",
                "fizz 7 8\nfizz: 1 buzz: 0 fizzbuzz: 0 lucky: 0 integer: 2",
                produceResult);
        fizzBuzzTestLogger.info(testName.getMethodName() + "\n" + produceResult);
    }

    @Test
    public void test_multiple_of_5_should_produce_buzz() throws Throwable {
        String produceResult = (new FizzBuzz(4, 5)).resultProducer();
        Assert.assertEquals("FizzBuzz failed to produce buzz for multiples of 5 from range: 4 - 5",
                "4 buzz\nfizz: 0 buzz: 1 fizzbuzz: 0 lucky: 0 integer: 1",
                produceResult);
        fizzBuzzTestLogger.info(testName.getMethodName() + "\n" + produceResult);
    }

    @Test
    public void test_multiple_of_15_should_produce_fizzbuzz() throws Throwable {
        String produceResult = (new FizzBuzz(14, 17)).resultProducer();
        Assert.assertEquals("FizzBuzz failed to produce fizzbuzz for multiples of 15 from range 14 - 17",
                "14 fizzbuzz 16 17\nfizz: 0 buzz: 0 fizzbuzz: 1 lucky: 0 integer: 3",
                produceResult);
        fizzBuzzTestLogger.info(testName.getMethodName() + "\n" + produceResult);
    }

    @Test
    public void test_number_that_contains_3_should_produce_lucky() throws Throwable {
        String produceResult = (new FizzBuzz(1, 3)).resultProducer();
        Assert.assertEquals("FizzBuzz failed to produce lucky for numbers that contains 3 from range: 1 - 3",
                "1 2 lucky\nfizz: 0 buzz: 0 fizzbuzz: 0 lucky: 1 integer: 2",
                produceResult);
        fizzBuzzTestLogger.info(testName.getMethodName() + "\n" + produceResult);
    }

    @Test
    public void test_multiple_of_3_5_15_should_produce_fizz_buzz_fizzbuzz() throws Throwable {
        String produceResult = (new FizzBuzz(1, 20)).resultProducer();
        Assert.assertEquals("FizzBuzz failed to produce fizz, buzz & fizzbuzz for numbers " +
                        "that are multiples of 3, 5, 15 and lucky that contains 3 from range: 1 - 20",
                "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz" +
                        "\nfizz: 4 buzz: 3 fizzbuzz: 1 lucky: 2 integer: 10",
                produceResult);
        fizzBuzzTestLogger.info(testName.getMethodName() + "\n" + produceResult);
    }

}