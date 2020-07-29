package niu.java.多线程学习.线程的创建和使用_01;

/**
 * @author niu Email:2377540437@qq.com
 */
/*1.
 * MAX_PRIORITY：10
 * MIN _PRIORITY：1
 * NORM_PRIORITY：5  -->默认优先级
 *
 * 2.如何获取和设置当前线程的优先级：
 *   getPriority():获取线程的优先级
 *   setPriority(int p):设置线程的优先级
 *   说明：高优先级的线程要抢占低优先级线程cpu的执行权。但是只是从概率上讲，
 *   高优先级的线程高概率的情况下被执行。并不意味着只当高优先级的线程执行完以后，低优先级的线程才执行。
 *   */
class Thread01 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("分线程测试中。。。");
        }
    }
}
public class ThreadPriority {
    public static void main(String[] args) {

        //设置主线程
        System.out.println("主线程："+Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        System.out.println("主线程："+Thread.currentThread().getPriority());

        //设置分线程
        Thread01 thread01 = new Thread01();
        System.out.println("分线程："+thread01.getPriority());
        thread01.setPriority(8);
        System.out.println("分线程："+thread01.getPriority());
        thread01.start();

        for (int i = 0; i < 50; i++) {
            System.out.println("***主线程***");
        }
    }
}
