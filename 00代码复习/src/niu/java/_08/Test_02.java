package niu.java._08;

import com.sun.jmx.snmp.SnmpTimeticks;
import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/4 9:40
 */
/*线程的同步：
 * 1.问题：共享数据的访问
 * 2.解决方法：
 * --> synchronize代码块
 * --> synchronize方法 静态<-->非静态
 * --> lock锁 try-finally 可能会到程序无法退出
 * */
//继承类
//Synchronize代码块
class ExThre extends Thread {
    static int ticnum = 10;
    static int i = 0;

    @Override
    public void run() {

        i++;
        String str = "";
        switch (i) {
            case 1:
                str = "一";
                break;
            case 2:
                str = "二";
                break;
            case 3:
                str = "三";
                break;
        }
        Thread.currentThread().setName("窗口" + str);
        System.out.println(Thread.currentThread().getName());

        while (true) {
            synchronized (ExThre.class) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /*解决方法：
                 * 这里会break掉其他两个线程多余的-1,-2*/
                if (ticnum < 0) break;

                System.out.println(Thread.currentThread().getName() + ":" + ticnum);
                ticnum--;

                /*为何在此种情况下会出现输出-1的情况？
                 * 分析：
                 * 释放锁的方式 --> 代码块执行结束，break、return、异常、wait方法
                 * 在该情况下，break会首先结束一个线程，但是这里还有其他两个线程
                 * 在ticknum=0的情况下，一个线程结束，但其他线程未结束
                 * 所以会出现ticknum=-1、-2的情况出现（-2的时候会break掉，不会输出）
                 * 解决方法：--> 见上述
                 * */
                /*System.out.println("--"+ticnum);
                if(ticnum <= 0)
                {
                    System.out.println("break "+ticnum);
                    break;
                }else {
                    System.out.println(ticnum);
                }*/
            }
        }
    }
}

/*Synchronized方法：
 * --> 静态方法 类名.class
 * --> 非静态方法 this
 * */
class ExThre1 extends Thread {
    static int ticknum = 10;
    static int i = 0;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        while (true) {
            /*synchronized(ExThre1.class){
                if (i == 1) break;
            }*/
            if (i == 1) break;//i也是共享数据，但可在test方法里保证安全性
            test();
        }
    }

    public static synchronized void test() {
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (ticknum < 0) {
            i = 1;
            return;
        }
        System.out.println(Thread.currentThread().getName() + ":" + ticknum);
        ticknum--;
    }
}

//lock锁
//目前遇到的问题 --> 程序不结束
class ExTre2 extends Thread {
    static int ticknum = 10;
    static ReentrantLock lock = new ReentrantLock();
    static int i = 0;

    @Override
    public void run() {
        System.out.println("lock锁：" + Thread.currentThread().getName());
        while (true) {
            try {
                //if(i == 0)lock.lock();
                lock.lock();
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticknum < 0) {
                    break;
                }
                /*else{
                    i = 1;
                }*/
                System.out.println(Thread.currentThread().getName() + ":" + ticknum);
                ticknum--;

                //lock.unlock();//1-在这里解锁会导致程序无法退出
                /*个人猜测：
                * 由于最后一个线程在ticknum=-1后，解除锁定，但在此之前并未触发break；
                * 之后还会有一个线程访问，此时会触发break，但回到该线程无法解除锁定，所以导致程序无法退出
                * */

            } finally {
                //lock.unlock();//2-在这里解锁会导致程序正常退出
            }
        }
        //lock.unlock();//3

        /*总结：
        * --> 1、3 程序正常退出
        * --> 2 程序正常退出
        * --> 1 程序无法退出
        * --> 3 程序无法退出
        * --> 3、while里注释的代码 程序正常退出
        * 个人猜测：
        * while里的循环导致不断lock.lock这里造成的；
        * 解决方法自然是只进行一次lock.lock
        * */
    }
}

//实现接口
//Synchronize代码块
class ImThre implements Runnable {
    int ticknum = 10;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        while (true) {
            synchronized (ImThre.class) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticknum < 0) break;
                System.out.println(Thread.currentThread().getName() + ":" + ticknum);
                ticknum--;
            }
        }
    }
}

//Synchronize方法
//静态<-->非静态
class ImThre1 implements Runnable {
    static int ticknum = 10;
    static int i = 0;

    @Override
    public void run() {
        while (true) {
            if (i == 1) return;
//            test();//非静态
            test1();//静态
        }
    }

    //非静态
    public synchronized void test() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (ticknum < 0) {
            i = 1;
            return;
        }
        System.out.println(Thread.currentThread().getName() + ":" + ticknum);
        ticknum--;
    }

    //静态
    public static synchronized void test1() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (ticknum < 0) {
            i = 1;
            return;
        }
        System.out.println(Thread.currentThread().getName() + ":" + ticknum);
        ticknum--;
    }
}

//lock锁
class ImThre2 implements Runnable {
    int ticknum = 10;
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        while (true) {
            lock.lock();
            try {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticknum < 0) break;
                System.out.println(Thread.currentThread().getName() + ":" + ticknum);
                ticknum--;
            }finally {
                lock.unlock();
            }
        }
    }
}

public class Test_02 {
    public static void main(String[] args) {
        //继承方式
        //Synchronize代码块
        /*Thread thread = new ExThre();
        Thread thread1 = new ExThre();
        Thread thread2 = new ExThre();
        thread.start();
        thread1.start();
        thread2.start();*/

        //Synchronize方法
        /*Thread thread = new ExThre1();
        Thread thread1 = new ExThre1();
        Thread thread2 = new ExThre1();
        thread.start();
        thread1.start();
        thread2.start();*/

        //lock锁
        /*Thread thread = new ExTre2();
        Thread thread1 = new ExTre2();
        Thread thread2 = new ExTre2();
        thread.start();
        thread1.start();
        thread2.start();*/

        //实现接口
        //Synchronize代码块
        /*Runnable imThre = new ImThre();
        Thread thread = new Thread(imThre);
        Thread thread1 = new Thread(imThre);
        Thread thread2 = new Thread(imThre);
        thread.start();
        thread1.start();
        thread2.start();*/

        //Synchronized方法
        /*Runnable imThre1 = new ImThre1();
        Thread thread = new Thread(imThre1);
        Thread thread1 = new Thread(imThre1);
        Thread thread2 = new Thread(imThre1);
        thread.start();
        thread1.start();
        thread2.start();*/

        //lock锁
        /*Runnable imThre2 = new ImThre2();
        Thread thread = new Thread(imThre2);
        Thread thread1 = new Thread(imThre2);
        Thread thread2 = new Thread(imThre2);
        thread.start();
        thread1.start();
        thread2.start();*/

    }
}
