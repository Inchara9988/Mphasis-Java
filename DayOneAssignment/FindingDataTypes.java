package com.mphasis.com;

public class DataTypes
 {
    public static void main(String args[]) {
        byte d = 42;
        char f = 'a';
        short i = 1024;
        int s = 50000;
        float c = 5.67f;
        double b = .1234;
        double result = (c * d) + (s / f) - (b * i);
        System.out.println((c * d) + " + " + (s / f) + " - " + (b * i));
        System.out.println("result = " + result);
    }

}
