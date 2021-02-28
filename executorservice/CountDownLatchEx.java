package com.mphasis.main;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task1 implements Runnable{
    CountDownLatch latch;

    public Task1(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
        System.out.println("progress...");
        }
    }
//}
public class CountDownLatchEx {
    public static void main(String[] args) throws InterruptedException {
        int coreCount=Runtime.getRuntime().availableProcessors();
        ExecutorService service= Executors.newFixedThreadPool(coreCount);

    CountDownLatch latch=new CountDownLatch(3);
    service.submit(new Task1(latch));
    service.submit(new Task1(latch));
    service.submit(new Task1(latch));
    latch.await();

        System.out.println("initiating shutdown");
        service.shutdown();
        System.out.println("shutdown initiated");

    }


}
