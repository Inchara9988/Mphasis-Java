package com.mphasis.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }


    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Task implements Callable<Point> {
    String name;
    int x;
    int y;

    public Task(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public Point call() {
        System.out.println(Thread.currentThread());
        return new Point(x,y);
    }
}

public class CallableTask {
    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newScheduledThreadPool(coreCount);
        List<Future> allFutures=new ArrayList<Future>();

        for(int i=0;i<10;i++){
            Future<Point> future=service.submit(new Task("Task"+(i+1),i+1,i+2));
            allFutures.add(future);
        }
        for(Future<Point> future:allFutures){
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
           service.shutdown();
    }

}
