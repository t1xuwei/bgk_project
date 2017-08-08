package xuw.bgk.controller;

/**
 * Created by admin on 2017/8/8.
 */
public class SynchronizedObj implements Runnable {
    static final String lock = "lock";

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void say(String h) throws InterruptedException {
        synchronized (SynchronizedObj.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println(h);
                Thread.sleep(1000);
            }
        }
    }

    public static synchronized void see(String h) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(h);
            Thread.sleep(1000);
        }
    }

    public static void fight(String h) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(h);
            Thread.sleep(1000);
        }
    }

    public void synchronizedObj(String h) throws InterruptedException {
        synchronized (lock) {
            System.out.println(h);
            Thread.sleep(1000);
        }
    }
}
