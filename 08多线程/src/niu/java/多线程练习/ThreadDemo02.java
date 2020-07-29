package niu.java.多线程练习;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author niu Email:2377540437@qq.com
 */
/*银行有一个账户。有两个储户分别向同一个账户存3000 元，存 每次存1000， ，存3次 。每次存完打印账户余额。*/

class Bank implements Runnable {
    private  int num = 0;

    private ReentrantLock lock = new ReentrantLock();//1.创建对象

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {

            //方式一：synchronized 代码块
            /*synchronized (this) {

                num += 1000;

                //阻塞会导致不理想状态
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "已经存了钱:" + num + "元");
            }*/

            //方式二：synchronize 方法
            run01();

            //方式三：lock锁
            /*lock.lock();//2.上锁

            num += 1000;

            //阻塞会导致不理想状态
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "已经存了钱:" + num + "元");

            lock.unlock();//3.解锁*/
        }
    }

    private synchronized void run01(){

        num += 1000;

        //阻塞会导致不理想状态
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "已经存了钱:" + num + "元");
    }
}
public class ThreadDemo02 {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Thread th1 = new Thread(bank);
        Thread th2 = new Thread(bank);

        th1.setName("小新");
        th2.setName("风间");

        th1.start();
        th2.start();
    }
}
