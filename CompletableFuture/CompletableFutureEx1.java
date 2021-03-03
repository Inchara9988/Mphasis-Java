package com.mphasis.com;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureEx1 {
    public static CompletableFuture<Integer> create(){
        return CompletableFuture.supplyAsync(()->compute());
    }
    public static CompletableFuture<Integer> create(int number){
        return CompletableFuture.supplyAsync(()->number);
    }

    public static int compute(){
        System.out.println("inside compute"+ Thread.currentThread());
        return 2;
    }
    public static void print(int data){
        System.out.println("inside print"+ Thread.currentThread());
        System.out.println(data);

    }

    public static void main(String[] args) {
//        create().thenAccept(value-> System.out.println(value));
        create().thenAccept(value->print(value))
        .thenRun(()-> System.out.println("1"))
                .thenRun(()-> System.out.println("2"))
                .thenRun(()-> System.out.println("3"));

       CompletableFuture<Integer> cf=new CompletableFuture<>();
       process(cf);
       cf.complete(4);
       create(2).thenCombine(create(3),(result1,result2)->result1+result2)
       .thenAccept(sumResult-> System.out.println(sumResult));
    }

    private static void process(CompletableFuture<Integer> cf) {

                cf.thenApply(v-> v/0)
                        .exceptionally(throwable -> handle(throwable))
                .thenAccept(result-> System.out.println(result));
    }

    private static Integer handle(Throwable throwable) {
        System.out.println("error"+throwable);
        return 1;

    }
}
