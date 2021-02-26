package com.mphasis.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

class RunThread implements  Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        Logger logger=Logger.getLogger(RunThread.class.getName());
        logger.log(Level.INFO,"task1");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class ShedulerThread {
    public static void main(String[] args) {
        Logger logger=Logger.getLogger(RunThread.class.getName());
        logger.log(Level.INFO,"start");
        int c=Runtime.getRuntime().availableProcessors();
        ScheduledExecutorService service= Executors.newScheduledThreadPool(c);
         service.scheduleWithFixedDelay(new RunThread(),5,10, TimeUnit.SECONDS);

//        service.shutdown();
    }
}
