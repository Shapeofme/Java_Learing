package niu.java.多线程学习.线程的同步_02;

/**
 * @author niu Email:2377540437@qq.com
 */
//死锁
public class ThreadDead {
    public static void main(String[] args) {

        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread(() -> {
            synchronized (s1) {
                s1.append("a");
                s1.append("1");

                //阻塞的存在导致死锁的概率加大
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (s2) {
                    s1.append("b");
                    s2.append("2");
                    System.out.println(s2);
                    System.out.println(s1);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {
                    s1.append("c");
                    s1.append("3");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s1) {
                        s1.append("d");
                        s2.append("4");
                        System.out.println(s2);
                        System.out.println(s1);
                    }
                }
            }
        }).start();
    }
}
