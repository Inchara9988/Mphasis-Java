package com.mphasis.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Run implements  Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread());
    }
}
public class CachedThread {
    public static void main(String[] args) {
        int c=Runtime.getRuntime().availableProcessors();
        ExecutorService service= Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            service.execute(new Runner());
        }
        service.shutdown();
    }
}
