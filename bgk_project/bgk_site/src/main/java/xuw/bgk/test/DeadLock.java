package xuw.bgk.test;

/**
 * 死锁Demo
 * Created by xuw on 2017/8/9.
 */
public class DeadLock {
    public static final Object X = new Object();
    public static final Object Y = new Object();

    public static void main(String[] args){

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (X){
                    System.out.println("thread 1 get x lock");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(Y){
                        System.out.println("thread 1 get y lock");
                    }
                }

            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(Y){
                    System.out.println("thread2 get y lock");
                    synchronized(X){
                        System.out.println("thread1 get x lock");
                    }
                }

            }
        });
        thread1.start();
        thread2.start();
    }
}


