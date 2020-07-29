package niu.java.多线程练习;

/**
 * @author niu Email:2377540437@qq.com
 */

//1.继承方式
class ThreadPP01 extends Thread {
    //static final Object object = new Object();
    static int num = 100;
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //1.同步代码块
            /*getnum01();
            if(num <=0 ) break;*/

            //2.同步方法
            //静态
            getnum02();
            if(num <=0 ) break;
            //非静态
            /*getnum03();
            if(num <=0)break;*/
        }
    }

    //1.同步代码块 可以使用类名.class 或者 静态obj
    private void getnum01(){
        synchronized (ThreadPP01.class) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + "_" + this.getPriority() + ":" + num--);
        }
    }

    //2.同步方法--静态  使用类名.class作为锁
    private static synchronized void getnum02(){
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "_" + Thread.currentThread().getPriority() + ":" + num--);
    }

    //3.同步方法--非静态 使用this作为锁
    private synchronized void getnum03(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "_" + Thread.currentThread().getPriority() + ":" + num--);
    }
}

//2.接口方式
class ThreadPP02 implements Runnable {
    static int num = 100;
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //1.同步代码块
            /*getnum01();
            if(num <=0 ) break;*/

            //2.同步方法
            //静态
            /*getnum02();
            if(num <=0 ) break;*/
            //非静态
            getnum03();
            if(num <=0)break;
        }
    }

    //1.同步代码块 可以使用类名.class 或者 静态obj
    private void getnum01(){
        synchronized (ThreadPP01.class) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "_" + Thread.currentThread().getPriority() + ":" + num--);
        }
    }

    //2.同步方法--静态  使用类名.class作为锁
    private static synchronized void getnum02(){
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "_" + Thread.currentThread().getPriority() + ":" + num--);
    }

    //3.同步方法--非静态 使用this作为锁
    private synchronized void getnum03(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "_" + Thread.currentThread().getPriority() + ":" + num--);
    }
}

//3.匿名类创建
class AnnoyPP {
    private Thread thread = new Thread() {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {

                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (i % 3 == 0) {
                    System.out.println(Thread.currentThread().getName() + "_" + Thread.currentThread().getPriority() + ":" + i);
                }
            }
        }
    };
    private Thread thread02 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

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

public class ThreadPractice02 {
    public static void main(String[] args) {
        //1.继承
        /*Thread threadE01 = new ThreadPP01();
        threadE01.setName("窗口一");
        threadE01.start();

        Thread threadE02 = new ThreadPP01();
        threadE02.setName("窗口二");
        threadE02.start();*/

        //2.接口
       ThreadPP02 threadPP02 = new ThreadPP02();
        Thread thread = new Thread(threadPP02);
        thread.setName("窗口一");
        thread.start();

        Thread thread1 = new Thread(threadPP02);
        thread1.setName("窗口二");
        thread1.start();

       //3.匿名类--略
    }
}
