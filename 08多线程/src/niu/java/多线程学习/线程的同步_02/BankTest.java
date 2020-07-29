package niu.java.多线程学习.线程的同步_02;

/**
 * @author niu Email:2377540437@qq.com
 */
//单例模式
//懒汉式
class Bank01{
    public Bank01(){}
    private static Bank01 bank01 = null;

    //原始版本
    /*public static Bank01 getBank01(){

        if(bank01 == null) bank01 = new Bank01();
        return bank01;

    }*/

    //方式一：效率较差-->每个线程都得进去，即使对象已经创建
    /*public static Bank01 getBank01(){
        synchronized (Bank01.class) {
            if(bank01 == null) bank01 = new Bank01();
            return bank01;
        }
    }*/

    //方式二：如果对象创建好了，拿着直接走就行
    public static Bank01 getBank01(){
        if (bank01 == null ) {
            synchronized (Bank01.class) {
                if (bank01 == null) bank01 = new Bank01();
            }
        }
        return bank01;
    }
}

public class BankTest {
    public static void main(String[] args) {
        /*Window01 window01_1 = new Window01();
        Window01 window01_2 = new Window01();
        Window01 window01_3 = new Window01();

        window01_1.setName("窗口一：");
        window01_2.setName("窗口二：");
        window01_3.setName("窗口三：");

        window01_1.start();
        window01_2.start();
        window01_3.start();*/

        //方式一：匿名类继承方式的创建
        new Thread(){
            @Override
            public void run() {
            }
        }.start();

        //方式二：匿名类Runnable接口的方式的创建
        new Thread(new Runnable() {
            @Override
            public void run() {
            }
        }).start();

    }
}
