package niu.java.多线程学习.线程的同步_02;

/**
 * @author niu Email:2377540437@qq.com
 */
//Runnable接口同步
class ImpleThread implements Runnable {
    private int num = 100;
    private Object obj = new Object();

    @Override
    public void run() {

        //方式一：同步代码块
//        test01();

        //方式二：同步方法
        while (true) {
            test02();
        }
    }

    //方式一：同步代码块
    private void test01() {
        while (true) {
            //同步代码块
            synchronized (ThreadLife02.class) {   //1.obj 2.this <--> 实现接口的优点 3.类.class
                if (num > 0) {
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "我买到了" + num + "号票");
                    num--;
                }else{
                    break;
                }
            }

        }
    }

    //方式二：同步方法-->此时的同步监视器就是this
    private synchronized void test02() {
        if (num <= 0) return;
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "我买到了" + num + "号票");
        num--;
    }
}

public class ThreadLife02 {
    public static void main(String[] args) {
        ImpleThread th = new ImpleThread();

        Thread thread01 = new Thread(th);
        thread01.setName("窗口一：");
        Thread thread02 = new Thread(th);
        thread02.setName("窗口二：");
        Thread thread03 = new Thread(th);
        thread03.setName("窗口三：");

        thread01.start();
        ;
        thread02.start();
        thread03.start();
    }
}
