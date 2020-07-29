package niu.java.多线程练习;

/*
 * @author niu Email:2377540437@qq.com
 */
/*
    方式一：创建一个继承于Thread的子类
 *       1. 创建一个继承于Thread类的子类
 *      2. 重写Thread类的run() --> 将此线程执行的操作声明在run()中
 *      3. 创建Thread类的子类的对象
 *      4. 通过此对象调用start()：①启动当前线程 ② 调用当前线程的run()
 */
//创建两个分线程：一个遍历偶数，一个遍历奇数

//分线程一：遍历偶数
class MyThread01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

//分线程二：遍历奇数
class MyThread02 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

//分线程三:根据需求遍历偶数和奇数
class MyThread03 extends Thread {
    private boolean isEven;

    public MyThread03(){
    }
    public MyThread03(boolean isEven){
        this.isEven = isEven;
    }
    @Override
    public void run() {
        if(isEven) getEven();
        else getOdd();
    }
    //获取奇数
    private void getOdd() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 !=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
    //获取偶数
    private void getEven(){
        for (int i = 0; i < 100; i++) {
            if (i % 2 ==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        //分线程一
        /*MyThread01 myThread01 = new MyThread01();
        myThread01.start();*/
        //分线程二
        /*MyThread02 myThread02 = new MyThread02();
        myThread02.start();*/

        //分线程三
        /*MyThread03 myThread03_1 = new MyThread03(false);
        myThread03_1.start();
        MyThread03 myThread03_2 = new MyThread03(true);
        myThread03_2.start();*/

        //分线程四:匿名子类
        Thread myThread04_1 =new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i%2 ==0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        };
        Thread myThread04_2 =new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i % 2 !=0)
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        };
        myThread04_1.start();
        myThread04_2.start();
    }
}
