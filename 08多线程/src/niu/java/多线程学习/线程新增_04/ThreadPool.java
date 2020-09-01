package niu.java.多线程学习.线程新增_04;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author niu Email:2377540437@qq.com
 */
class NumerThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i%2 ==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class NumerThread01 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i%2 !=0){
                System.out.println(Thread.currentThread().getName()+":"+i+"*");
            }
        }
    }
}
class NumerThread02 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i <= 100; i++) {
            if(i%3 !=0){
                System.out.println(Thread.currentThread().getName()+":"+i+"**");
            }
        }
        return null;
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);//这是接口
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;//这是类
        //设置线程池中的属性
        service1.setCorePoolSize(15);
//        ((ThreadPoolExecutor) service).setKeepAliveTime();

        //2.执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumerThread());//适合适用于Runnable
        service.execute(new NumerThread01());
        service.submit(new NumerThread02());//适合适用于Callable

        //3.关闭连接池
        service.shutdown();
    }
}
