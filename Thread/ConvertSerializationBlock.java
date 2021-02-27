package com.mphasis.main;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class WorkerMethodsSynchronized {

    private Random random = new Random();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public List<Integer> getList1() {
        return list1;
    }

    public void setList1(List<Integer> list1) {
        this.list1 = list1;
    }

    public List<Integer> getList2() {
        return list2;
    }

    public void setList2(List<Integer> list2) {
        this.list2 = list2;
    }

    /**
     * synchronized, methods use different data (list1 list2) so by synchronized
     * methods if one thread runs the stageOne other thread cannot run stageTwo
     * at the same time because that same locks are used. Solution is using two
     * lock Object for two shared data.
     */
    public void stageOne() {

        list1.add(random.nextInt(100));
    }

    public void stageTwo() {

        list2.add(random.nextInt(100));
    }

}

    class Task implements Runnable {
        WorkerMethodsSynchronized worker2;

        Task() {
            worker2 = new WorkerMethodsSynchronized();
        }

        @Override
        public void run() {
            Thread currThread = Thread.currentThread();
            System.out.println(currThread);
            for (int i = 0; i < 1000; i++) {
                if (currThread.getName().equals("one")) {

                    synchronized (worker2) {
                        worker2.stageOne();
                        try {
                            worker2.notify();
                            worker2.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    synchronized (worker2) {
                        worker2.stageTwo();
                        try {
                            worker2.notify();
                            worker2.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
    }


    public class ConvertSerializationBlock {
        public static void main(String[] args) {
            Task task = new Task();

            System.out.println("Synchronized Methods: ");
            WorkerMethodsSynchronized worker = new WorkerMethodsSynchronized();
            System.out.println("Starting ...");
            long start = System.currentTimeMillis();
            Thread t1 = new Thread(task, "one");
            Thread t2 = new Thread(task, "two");

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException ignored) {
            }

            long end = System.currentTimeMillis();

            System.out.println("Time taken: " + (end - start));
            System.out.println("List1: " + worker.getList1().size() + "; List2: " + worker.getList2().size());
            System.out.println("end");
        }
    }


