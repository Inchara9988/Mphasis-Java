package com.mphasis.main;

import java.util.Arrays;
import java.util.List;

public class StreamEx1 {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9);
        numbers.forEach(System.out::println);

        numbers.stream()
                .map(e -> e*2)
                .forEach(System.out::println);
        numbers.stream()
                .map(e -> e*3.0 )
                .forEach(System.out::println);
        numbers.stream()
                .map(String::valueOf)
                .forEach(System.out::println);
        System.out.println( numbers.stream()
                .reduce(0,(total,e)->Integer.sum(total,e)));

        System.out.println( numbers.stream()
                .map(e->String.valueOf(e))
                .reduce("",(contString,str)->contString.concat(str)));

    }
}
