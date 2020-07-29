package niu.java.多线程学习.线程的同步_02;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author niu Email:2377540437@qq.com
 */

//方式三：Lock锁
class Thread00 extends Thread {
    private static int num = 100;
    //1.创建实现Lock接口的对象
    private  static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (num > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(this.getName() + ":" + num);
                    num--;
                } else {
                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}

class ImThread01 implements Runnable{
    private int num = 100;
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while(true) {
            lock.lock();
            if(num >0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+":"+num);
                num--;
            }else {
                break;
            }
            lock.unlock();
        }
    }
}

public class LockTest02 {
    public static void main(String[] args) {
        Thread thread = new Thread00();
        thread.setName("窗口一：");
        thread.start();

        Thread thread1 = new Thread00();
        thread1.setName("窗口二：");
        thread1.start();

        /*ImThread01 impleThread01 = new ImThread01();
        Thread thread = new Thread(impleThread01);
        thread.setName("窗口一");
        Thread thread2 = new Thread(impleThread01);
        thread2.setName("窗口二");

        thread.start();
        thread2.start();*/
    }
}
