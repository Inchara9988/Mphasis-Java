package com.mphasis.main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        numbers.stream()
                .filter(element -> element%2 ==0)
                .map(element-> element*2)
                .forEach(System.out::println);
        System.out.println( numbers.stream()
                .filter(element -> element%2 ==0)
                .map(element-> element*2)
                .reduce(0,Integer::sum));
        List<Integer> ddoubleNumber=Arrays.asList(1,2,3,4,5,1,2,3,4,5);

        List<Integer> doubleOfeven=ddoubleNumber.stream()
                .filter(element -> element%2==0)
                .map(element -> element*2)
                .collect(Collectors.toList());
        System.out.println(doubleOfeven);

    }
}
