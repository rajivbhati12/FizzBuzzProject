package com.base;


import java.util.Arrays;
import java.util.Collections;

@SuppressWarnings("WeakerAccess")
public class FizzBuzz
{
    private Integer lowerValue, upperValue;
    private String result;

    public FizzBuzz(Integer lowerValue, Integer upperValue){
        this.lowerValue = lowerValue;
        this.upperValue = upperValue;
    }

    public String resultProducer()throws Throwable{
        this.result = fizzBuzzResolver(this.lowerValue);
        for(int currentValue = this.lowerValue + 1; currentValue<=this.upperValue; currentValue++){
            this.result = this.result + " " + fizzBuzzResolver(currentValue);
        }

        return this.result + "\n" + produceReport();
    }

    private String fizzBuzzResolver(int thisValue){
        String returnValue = "";
        if(String.valueOf(thisValue).contains("3"))
            returnValue = "lucky";
        else{
            if(thisValue % 3 == 0 && thisValue != 0)
                returnValue = "fizz";
            if(thisValue % 5 == 0 && thisValue != 0)
                returnValue = returnValue + "buzz";
            if(returnValue.equalsIgnoreCase(""))
                returnValue = String.valueOf(thisValue);
        }

        return returnValue;
    }

    private Integer getCount(String keyword){
        return Collections.frequency(Arrays.asList(this.result.split(" ")),keyword);
    }

    private String produceReport() {
        String report =  "fizz: 0 buzz: 0 fizzbuzz: 0 lucky: 0 integer: 0";
        if(this.result != null && ! this.result.isEmpty()) {
            Integer fizzCount = this.getCount("fizz");
            Integer buzzCount = this.getCount("buzz");
            Integer fizzbuzzCount = this.getCount("fizzbuzz");
            Integer luckyCount = this.getCount("lucky");
            Integer integerCount = this.result.split("\\s+").length -
                    (fizzCount + buzzCount + fizzbuzzCount + luckyCount);
            report =  "fizz: " + fizzCount + " buzz: " + buzzCount + " fizzbuzz: " +
                    fizzbuzzCount + " lucky: " + luckyCount + " integer: " + integerCount;
        }
        return report;
    }
}
