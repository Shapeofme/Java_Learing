package niu.java.多线程学习.线程的同步_02;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author niu Email:2377540437@qq.com
 */

/*
* 线程安全方式三：
*   1.创建对象 Reentrantlock
*   2.锁定 lock方法
*   3.解锁 unlock方法
*
*/
class ImpleThread01 implements Runnable{

    private int num = 100;

    //1.创建对象
    //有参构造器-->fair 公平 先进先出
    //private ReentrantLock lock = new ReentrantLock(true);

    //无参构造器-->默认false
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                //2.锁定
                lock.lock();

                if (num > 0) {

                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + num + "号票");
                    num--;
                } else {
                    break;
                }
            }finally {
                //3.解锁
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        ImpleThread01 impleThread01 = new ImpleThread01();

        Thread th1 = new Thread(impleThread01);
        th1.setName("窗口一：");
        Thread th2 = new Thread(impleThread01);
        th2.setName("窗口二：");
        Thread th3 = new Thread(impleThread01);
        th3.setName("窗口三：");

        th1.start();
        th2.start();
        th3.start();
    }
}
