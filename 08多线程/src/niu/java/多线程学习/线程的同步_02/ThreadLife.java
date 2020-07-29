package niu.java.多线程学习.线程的同步_02;

/**
 * @author niu Email:2377540437@qq.com
 */

/*方式一：同步代码块
 *
 *   synchronized(同步监视器){
 *      //需要被同步的代码
 *
 *   }
 *  说明：1.操作共享数据的代码，即为需要被同步的代码。  -->不能包含代码多了，也不能包含代码少了。
 *       2.共享数据：多个线程共同操作的变量。比如：num就是共享数据。
 *       3.同步监视器，俗称：锁。任何一个类的对象，都可以充当锁。
 *          要求：多个线程必须要共用同一把锁。
 *
 */

/*
 * *  方式二：同步方法
 *     如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明同步的。
 *  关于同步方法的总结：
 *  1. 同步方法仍然涉及到同步监视器，只是不需要我们显式的声明。
 *  2. 非静态的同步方法，同步监视器是：this
 *     静态的同步方法，同步监视器是：当前类本身
 *     */
//创建三个窗口买票：总票数为100
class Window extends Thread {
    protected static int num = 100;
    protected static Object obj = new Object();

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

    //方式二：同步方法-->非静态方法同步监视器就是this（在继承下无法使用），静态方法为 类名.class
    private synchronized static void test02() {
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

public class ThreadLife {
    public static void main(String[] args) {

        Window window = new Window();
        window.setName("窗口一：");

        Window window1 = new Window();
        window1.setName("窗口二：");

        Window window2 = new Window();
        window2.setName("窗口三：");

        window.start();
        window1.start();
        window2.start();
    }
}

