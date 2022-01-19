package com.laoshige;

public class LocalVariableTest {
    public static void  main(String[] args) {
        MovingAverage ma = new MovingAverage();
        int num1 = 1;
        int num2 = 2;
        int num3 = 10;
        ma.submit(num1);
        ma.submit(num2);
        ma.submit(num3);
        double avg = ma.getAvg();
    }
}
