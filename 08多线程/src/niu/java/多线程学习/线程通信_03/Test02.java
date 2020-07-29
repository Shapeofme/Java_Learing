package niu.java.多线程学习.线程通信_03;

/**
 * @author niu Email:2377540437@qq.com
 */
/*  生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，店员一
    次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员会叫生产者停一下，
    如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
    果店中有产品了再通知消费者来取走产品。
*/
class Clerk01 {//该对象就造了一个
    private int productCount = 0;

    public synchronized void produtorProduct() {//同步监视器 this
        if (productCount < 20) {
            productCount+= 1;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + productCount + "个产品");
            notify();
        } else {
            //动态的平衡，总会保持在20左右（这里生产速度是要大于消费速度的）
            try {
                wait();//--> 会释放锁（即同步监视器 this）
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void customeProduct() {//同步监视器 this
        if (productCount > 0) {
            System.out.println(Thread.currentThread().getName() + "开始消费第" + productCount + "个产品");
            productCount--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//消费者
class Customer01 extends Thread {
    Clerk01 clerk01;

    public Customer01(Clerk01 clerk01) {
        this.clerk01 = clerk01;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始消费产品...");
        while (true) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk01.customeProduct();
        }
    }
}

//生产者
class Productor01 extends Thread {
    Clerk01 clerk01;

    public Productor01(Clerk01 clerk01) {
        this.clerk01 = clerk01;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始生产产品...");
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk01.produtorProduct();
        }
    }
}

public class Test02 {
    public static void main(String[] args) {

        Clerk01 clerk01 = new Clerk01();

        Customer01 customer01 = new Customer01(clerk01);
        Productor01 productor01 = new Productor01(clerk01);
        Customer01 customer02 = new Customer01(clerk01);

        customer01.setName("消费者1");
        productor01.setName("生产者1");
        customer02.setName("消费者2");

        customer01.start();
        customer02.start();
        productor01.start();
    }
}
