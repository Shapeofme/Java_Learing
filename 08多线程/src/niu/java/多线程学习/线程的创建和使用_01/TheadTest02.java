package niu.java.多线程学习.线程的创建和使用_01;

/**
 * @author niu Email:2377540437@qq.com
 */
/* 方式二：实现Runnable接口的方式：
 * 1. 创建一个实现了Runnable接口的类
 * 2. 实现类去实现Runnable中的抽象方法：run()
 * 3. 创建实现类的对象
 * 4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5. 通过Thread类的对象调用start()：①启动当前线程 ② 调用当前线程的run()-->调用Runnable接口中的run方法
 * */
/*
* 两种方式的对比：
* 开发中：优先选择：实现Runnable接口的方式
* 原因：1. 实现的方式没类的单继承性的局限性
*      2. 实现的方式更适合来处理多个线程共享数据的情况。
*
* 联系：public class Thread implements Runnable
* 相同点：两种方式都需要重写run(),将线程要执行的逻辑声明在run()中。
        目前两种方式，要想启动线程，都是调用的Thread类中的start()。
* */
class ImpleThead implements Runnable{
    private int i = 0;
    @Override
    public void run() {
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
public class TheadTest02 {
    public static void main(String[] args) {
        //这里只使用一个对象
        ImpleThead impleThead = new ImpleThead();

        Thread thread = new Thread(impleThead);
        Thread thread1 = new Thread(impleThead);
        thread.setName("窗口一：");
        thread.start();
        thread1.setName("窗口二：");
        thread1.start();
    }
}
