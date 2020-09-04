package niu.java._08;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/4 8:21
 */
/*多线程
* 1.创建多线程的三种方式：
* --> 继承Thread类
* --> 实现Runnable接口 实现类只需创建一次就可以了
* --> 匿名类
* */
//继承
class ExThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //if(i ==50 ) Thread.yield();//释放当前线程的执行权
            System.out.println(this.getName() + ":" + i);
        }
    }
}
//实现Runnable接口
class ImThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
public class Test_01 {
    public static void main(String[] args) {

        Thread thread = new ExThread();
        thread.start();

        Thread thread1 = new Thread(new ImThread());
        thread1.start();

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0;i<100;i++) {
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        };
        //匿名创建
        Thread thread3 = new Thread(new Runnable(){

            @Override
            public void run() {
                for (int i = 0;i<100;i++) {
                    if(i == 50) {
                        try {
                            thread2.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        });
        thread3.start();
        thread2.start();
    }
}
