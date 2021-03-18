package com.mphasis.com;

import java.util.concurrent.*;

public class CompletableFutureWelcomeText
 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> welcomeText = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Annie";
        }).thenApply(name -> {
            return "Hello " + name;
        }).thenApply(greeting -> {
            return greeting + ", Welcome to Java";
        });

        System.out.println(welcomeText.get());
    }
}
