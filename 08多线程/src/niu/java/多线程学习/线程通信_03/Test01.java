package niu.java.多线程学习.线程通信_03;

import javax.jws.Oneway;

/**
 * @author niu Email:2377540437@qq.com
 */

/*  生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，店员一
    次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员会叫生产者停一下，
    如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
    果店中有产品了再通知消费者来取走产品。
*/

//消费者
class Customer extends Thread{

    public Clerk clerk = Clerk.getClerk();

    @Override
    public void run() {
        while(true){
            System.out.println(this.getName()+"-现有货物数量:"+clerk.getProducts_num());
            clerk.takePro();
        }
    }
}
//店员
class Clerk{

    private int products_num = 20;
    public int getProducts_num(){
        return this.products_num;
    }

    //单例模式
    private static Clerk clerk = null;
    private Clerk(){
    }
    public static Clerk getClerk(){
        if(clerk == null) {
            synchronized (Clerk.class) {
                if(clerk == null) clerk = new Clerk();
            }
        }
        return clerk;
    }

    //输出产品
    public synchronized void takePro(){
        if(products_num >=20) {
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            products_num-=2;
            System.out.println("你好");
        }else if(products_num <20 ){
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("请您稍等。。。");
        }
    }

    //输入产品
    public synchronized void bringPro(){
        if(products_num < 20){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            products_num++;
            System.out.println("请多添货。。。");
        }else if(products_num > 20){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            products_num--;
            System.out.println("请适当生产。。。");
        }
    }

}
//生产者
class Produtor implements Runnable{

    public Clerk clerk = Clerk.getClerk();

    @Override
    public void run() {
        while(true){
            System.out.println(Thread.currentThread().getName()+"-现有货物数量:"+clerk.getProducts_num());
            clerk.bringPro();
        }
    }
}
public class Test01 {
    public static void main(String[] args) {
        Thread cu = new Customer();

        Produtor produtor = new Produtor();
        Thread pro = new Thread(produtor);

        //System.out.println(produtor.clerk == ((Customer) cu).clerk);
        cu.setName("消费者");
        pro.setName("生产者");

        cu.start();
        pro.start();
    }
}
