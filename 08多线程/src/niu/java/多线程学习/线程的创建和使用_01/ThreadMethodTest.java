package niu.java.多线程学习.线程的创建和使用_01;

/**
 * @author niu Email:2377540437@qq.com
 */
/*Thread方法：
 * 1. start():启动当前线程；调用当前线程的run()
 * 2. run(): 通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3. currentThread():静态方法，返回执行当前代码的线程
 * 4. getName():获取当前线程的名字
 * 5. setName():设置当前线程的名字
 * 6. yield():释放当前cpu的执行权 --> 有可能下一次执行权又被刚结束的线程抢到
 * 7. join():在线程a中调用线程b的join(),此时线程a就进入阻塞状态，直到线程b完全执行完以后，线程a才结束阻塞状态。
 * 8. stop():已过时。当执行此方法时，强制结束当前线程。
 * 9. sleep(long millitime):让当前线程“睡眠”指定的millitime毫秒。在指定的millitime毫秒时间内，当前线程是阻塞状态。
 * 10. isAlive():判断当前线程是否存活
 *
 *
 * */
class MyThread01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {

                //sleep(long millitime)方法
                /*try {
                    Thread.sleep(100);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }*/

                System.out.println(Thread.currentThread().getName() + "_" + i);
            }
            //释放当前CPU的执行权
            /*if(i%2 == 0) {
                yield();
            }*/
        }
    }

    public MyThread01() {
    }

    public MyThread01(String name) {
        super(name);
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        //1.线程命名：setName
        MyThread01 myThread01 = new MyThread01();
        myThread01.setName("线程一");
        myThread01.start();

        //1.1通过构造器给线程命名
       /* MyThread01 myThread02 = new MyThread01("构造器线程一");
        myThread02.start();*/

        //2.主线程命名：Thread.currentThread().setName
        /*Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "_" + i);
            }
        }*/

        //3.匿名子类
        Thread myThread03 = new Thread() {
            @Override
            public void run() {
                this.setName("匿名线程");
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + "_" + i);
                    }
                    if (i == 20) {
                        try {
                            //测试join方法
                            myThread01.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        myThread03.start();
        while (true) {
            if (myThread03.isAlive() == false) {
                System.out.println("测试中。。。");
                break;
            }
        }
    }
}
