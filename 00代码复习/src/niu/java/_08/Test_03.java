package niu.java._08;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/5 20:52
 */
/*wait()、notify、notifyall
* 1.必须在synchronized代码块和方法中使用
* 2.必须由同步监视器调用
* 同步监视器，俗称：锁。任何一个类的对象，都可以充当锁。
 *          要求：多个线程必须要共用同一把锁。
* */
class ExThe extends Thread{
    static int ticknum = 10;
    static Thread thread = null;
    static int i = 0;
    static Object object = new Object();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

        while(true) {
            synchronized(object){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                };

                if(i++ == 4) {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if(ticknum < 0) {
                    object.notify();
                    break;
                }

                System.out.println(Thread.currentThread().getName()+":"+ticknum);
                ticknum--;
            }
        }
        //notify();
    }
}
public class Test_03 {
    public static void main(String[] args) {
        Thread thread = new ExThe();
        Thread thread1 = new ExThe();
        Thread thread2 = new ExThe();
        thread.start();
        thread1.start();
        thread2.start();
    }
}
