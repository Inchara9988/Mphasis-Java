package com.mphasis.main;

import java.util.Arrays;
import java.util.List;

public class StreamCompare {
    public static void main(String[] args) {


        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
       pMonitor.code(()-> System.out.println( numbers.stream()
                .filter(element -> element % 2 == 0)
                .mapToInt(StreamCompare::compute)
                .sum()));

        pMonitor.code(()-> System.out.println( numbers.parallelStream()
                .filter(element -> element % 2 == 0)
                .mapToInt(StreamCompare::compute)
                .sum()));

    }

    public static int compute(int number) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number * 2;
    }
}

    class pMonitor {
        public static void code(Runnable text) {
            long start=System.currentTimeMillis();
            try {
                text.run();
            }
            finally {
                long end=System.currentTimeMillis();
                System.out.println("time taken" +(end-start)/1.0e9);

            }
        }

    }


