package niu.java.多线程学习.线程的创建和使用_01;

/**
 * @author niu Email:2377540437@qq.com
 */
/*
 * 多线程的创建：
 *   方式一：创建一个继承于Thread的子类
 *       1. 创建一个继承于Thread类的子类
 *      2. 重写Thread类的run() --> 将此线程执行的操作声明在run()中
 *      3. 创建Thread类的子类的对象
 *      4. 通过此对象调用start()：①启动当前线程 ② 调用当前线程的run()
 *   */

//遍历100以内的偶数
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+"_"+i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //1.run与start的区别
        myThread.start();
        //myThread.run();

        //2.重新启动一个线程
        //myThread.start();-->IllegalThreadStateException 非法的线程状态
        MyThread myThread1 = new MyThread();
        myThread1.start();


        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+"_"+i+"**main()**");
            }
        }
    }
}
