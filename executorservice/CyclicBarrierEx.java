package com.mphasis.main;

import java.util.TreeMap;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Mytask class which implements runnable
class MyTask implements Runnable{
    CyclicBarrier barrier;

    public MyTask(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("process....");
    }
}

//class which creating the cyclic barrier
public class CyclicBarrierEx {
    public static void main(String[] args) {
        int coreCount=Runtime.getRuntime().availableProcessors();
        ExecutorService service= Executors.newFixedThreadPool(coreCount);

        CyclicBarrier barrier=new CyclicBarrier(3);
        service.submit(new MyTask(barrier));
        service.submit(new MyTask(barrier));
        service.submit(new MyTask(barrier));

        System.out.println("initiating shutdown");
        service.shutdown();
        System.out.println("shutdown initiated");

    }

}
