package com.base;

@SuppressWarnings("WeakerAccess")
public class Main {
    public static void main(String[] args) throws Throwable {
        try {
            FizzBuzz fizzBuzz = new FizzBuzz(
                    Integer.valueOf(args[0]), Integer.valueOf(args[1])
            );
            System.out.println(fizzBuzz.resultProducer());
        }catch (Throwable t){
            System.out.println("Please enter valid non negative integer ranges");
        }
    }
}
