package niu.java.多线程练习;

import com.sun.javafx.geom.transform.Affine3D;

/**
 * @author niu Email:2377540437@qq.com
 */
//P1-创建线程
//1.继承方式
class ThreadP01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (i % 2 == 0)
                System.out.println(this.getName() + "_" + this.getPriority() + ":" + i);
        }
    }
}

//2.接口方式
class ThreadP02 implements Runnable {
    private Thread thread = Thread.currentThread();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (i % 2 != 0)
                System.out.println(Thread.currentThread().getName() + "_" + Thread.currentThread().getPriority() + ":" + i);
        }
    }
}

//3.匿名类创建
class AnnoyP {
    private Thread thread = new Thread() {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {

                /*try {
                    //Thread.sleep(30);
                    //if(i == 60)thread02.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/

                if (i % 3 == 0) {
                    Thread.yield();
                    System.out.println(Thread.currentThread().getName() + "_" + Thread.currentThread().getPriority() + ":" + i);
                }
            }
        }
    };
    private Thread thread02 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {

                /*try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/

                if (i % 3 != 0)
                    System.out.println(Thread.currentThread().getName() + "_" + Thread.currentThread().getPriority() + ":" + i);
            }
        }
    });

    public Thread getThread(boolean isExt) {
        Thread thread = this.thread;
        thread.setName("窗口三");
        if (!isExt) {
            thread = this.thread02;
            thread.setName("窗口四");
            thread.setPriority(3);
        }
        return thread;
    }
}

public class ThreadPractice {
    public static void main(String[] args) {
        //P-1创建
        //1.继承方式
        /*Thread thread01 = new ThreadP01();
        thread01.setName("窗口一");
        thread01.start();*/
        //2.接口方式
        /*Thread02 thread_1 = new Thread02();
        Thread thread02 = new Thread(thread_1);
        thread02.setName("窗口二");
        thread02.start();*/

        //3.匿名类方式
        /*Annoy annoy = new Annoy();
        Thread thread03 = annoy.getThread(true);
        thread03.start();

        Thread thread04 = annoy.getThread(false);
        thread04.start();
        System.out.println(thread03.isAlive());*/


    }
}
