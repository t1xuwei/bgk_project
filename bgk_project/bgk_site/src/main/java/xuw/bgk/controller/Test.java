package xuw.bgk.controller;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

/**
 * Created by admin on 2017/8/8.
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        SynchronizedObj obj = new SynchronizedObj();
        SynchronizedObj obj2 = new SynchronizedObj();

        Thread thread1 = new Thread(obj,"111111111");
        Thread thread2 = new Thread(obj2,"2222222222");
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    SynchronizedObj obj3 = new SynchronizedObj();
                    obj3.say("3333333333");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    SynchronizedObj obj4 = new SynchronizedObj();
                    obj4.see("4444444444");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    SynchronizedObj obj5 = new SynchronizedObj();
                    obj5.fight("fightfightfight");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread3.start();
        thread4.start();
//        thread5.start();
//        thread1.start();
//        thread2.start();


    }
}
