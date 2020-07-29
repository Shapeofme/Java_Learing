package niu.java.多线程练习;

/**
 * @author niu Email:2377540437@qq.com
 */
//创建三个窗口买票：总票数为100
class Window extends Thread{
    protected static int num = 100;

    @Override
    public void run() {
       while(num > 0) {

           System.out.println(this.getName()+"我买到了"+num+"号票");

           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

           num--;
       }
    }
}
public class WindowTest {
    public static void main(String[] args) {
        Window window = new Window();
        window.setName("窗口一：");
        Window window1 = new Window();
        window1.setName("窗口二：");
        Window window2 = new Window();
        window2.setName("窗口三：");

        window.start();
        window1.start();
        window2.start();
    }
}
