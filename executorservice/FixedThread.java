package com.mphasis.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Runner implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread());
    }
}


public class FixedThread {
    public static void main(String[] args) {
        int coreCount=Runtime.getRuntime().availableProcessors();
        ExecutorService service= Executors.newFixedThreadPool(coreCount);
        for(int i=0;i<10;i++){
            service.execute(new Runner());
        }
        service.shutdown();
    }
}
