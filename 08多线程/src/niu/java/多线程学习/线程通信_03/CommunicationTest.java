package niu.java.多线程学习.线程通信_03;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author niu Email:2377540437@qq.com
 */
/*
 * 线程通信：使用两个线程打印 1-100 。线程1, 线程2交替打印*/

/*三个方法：
    wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。
 * notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级高的那个。
 * notifyAll():一旦执行此方法，就会唤醒所有被wait的线程。*/
/*说明：
*1.wait()，notify()，notifyAll()三个方法必须使用在同步代码块或同步方法中。
 *2.wait()，notify()，notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器。
 *否则，会出现IllegalMonitorStateException异常
 *3.wait()，notify()，notifyAll()三个方法是定义在java.lang.Object类中.
 *
 */
class Number implements Runnable {
    private int num = 1;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {

//            调用者必须是同步代码块或同步方法中的同步监视器。
            //synchronized (obj) {//java.lang.IllegalMonitorStateException

            synchronized (this) {
                notify();
                if (num < 101) {
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();

        Thread th1 = new Thread(number);
        Thread th2 = new Thread(number);

        th1.setName("线程一");
        th2.setName("线程四");

        th1.start();
        th2.start();
    }
}
