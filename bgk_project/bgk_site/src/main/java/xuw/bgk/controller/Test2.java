package xuw.bgk.controller;

/**
 * 死锁Demo
 * Created by xuw on 2017/8/8.
 */
public class Test2 {
    public static final String lock = "lock";
    public static void main(String[] args) throws InterruptedException {
        SynchronizeString syncObj = new SynchronizeString();
        Thread thread1 = new Thread(syncObj);
        System.out.println(lock);
        synchronized(lock){
            System.out.println("main in");
            thread1.start();
            thread1.join();
        }
    }
}

class SynchronizeString implements Runnable{
    public static final String lock = "lock";
    @Override
    public void run() {
        synchronized(lock){
            System.out.println(lock);
            System.out.println("run in");
        }
    }
}