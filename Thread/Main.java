package com.mphasis.main;

class Data{
   private int value;

    public void getValue() {
        System.out.println(value);
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class Runner implements Runnable{
    private boolean exit;
    Data data;
    Runner(){
        data=new Data();
    }
    @Override
    public void run() {
        Thread currThread=Thread.currentThread();
        System.out.println(currThread);
        for(int c=0;c<10;c++) {
            if(currThread.getName().equals("producer")){
                synchronized (data) {

                    data.setValue(c + 1);
                    try {
                        data.notify();
                        data.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }else{
                synchronized (data) {
                    data.getValue();
                    try {
                        data.notify();
                        data.wait();
//                        currThread.interrupt();
//                        currThread.stop();
                    } catch (InterruptedException e) {
//                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }
            }
        }
//       currThread.interrupt();
    }
//    public void stop(){
//        exit=true;
//    }
}

public class Main {
    public static void main(String[] args) {
        Thread mainthread=Thread.currentThread();
        Runner runner=new Runner();
        Thread thread1=new Thread(runner,"producer");
        Thread thread2=new Thread(runner,"consumer");
//        thread2.setPriority(10);
        thread1.start();

        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        thread2.stop();
//           thread2.interrupt();
//        thread1.interrupt();
        System.out.println("end");
    }
}
