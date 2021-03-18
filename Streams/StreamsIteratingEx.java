package com.mphasis.main;

import java.util.stream.Stream;

public class StreamsIteratingEx {
        public static void main(String[] args){
           //iterating through elements and limit the number of element
            Stream.iterate(1, element->element+1)
                    .filter(element->element%5==0)
                    .limit(5)
                    .forEach(System.out::println);
        }
    }

