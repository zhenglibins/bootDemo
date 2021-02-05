package com.example.test.thread;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock(true);
        myThread th1 = new myThread(100,lock,"线程1");
        th1.start();
        Thread.sleep(1000);
        myThread th2 = new myThread(2,lock,"线程2");
        myThread th3 = new myThread(2,lock,"线程3");
        myThread th4 = new myThread(2,lock,"线程4");
        myThread th5 = new myThread(2,lock,"线程5");
        myThread th6 = new myThread(2,lock,"线程6");
        myThread th7 = new myThread(2,lock,"线程7");
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th6.start();
        th7.start();
        th1.setTime(5);

    }
}

class myThread extends Thread{
    private int time ;
    private ReentrantLock lock;
    private String name;
    public myThread(int time,ReentrantLock lock,String name){
        this.time = time;
        this.lock = lock;
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public void run() {
        lock.lock();
        while(time>0){
            System.out.println("当前线程="+name+",当前时间="+ time);
            time--;
            try {
                this.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.unlock();
    }
}
