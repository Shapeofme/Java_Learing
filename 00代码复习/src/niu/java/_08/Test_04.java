package niu.java._08;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/5 21:29
 */
/*新增线程创建方式：
 * 1.实现Callable 接口:
 * -->
    NumCall numCall = new NumCall();
    FutureTask futureTask = new FutureTask(numCall);
    new Thread(futureTask).start();
    futureTask.get(); 返回值
 * 2.线程池 -略
 * */
class NumCall implements Callable {
    int ticknum = 10;

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        while (true) {
            synchronized (this) {
                Thread.sleep(100);
                if (ticknum < 0) break;
                System.out.println(Thread.currentThread().getName() + ":" + ticknum);
                ticknum--;
            }
        }
        return "测试成功！";
    }
}

public class Test_04 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        NumCall numCall = new NumCall();
        FutureTask futureTask = new FutureTask(numCall);
        FutureTask futureTask1 = new FutureTask(numCall);

        new Thread(futureTask).start();
        new Thread(futureTask1).start();

        Object object = futureTask.get();
        System.out.println(object);
    }
}
