package com.mphasis.com;


interface Printer{
    public void print(String str);
}

public class LambdaEX {
    public static void main(String[] args) {
//        Printer printer= (text)->System.out.println(text);

        Printer printer1=System.out::println;
//        System.out.println("hi");
       printer1.print("abcd");
    }
}
