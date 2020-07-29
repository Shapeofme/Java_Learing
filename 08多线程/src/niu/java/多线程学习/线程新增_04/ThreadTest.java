package niu.java.多线程学习.线程新增_04;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author niu Email:2377540437@qq.com
 */

//方式一：Callable接口的方式创建多线程
/*
* 如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程方式强大？
* 1. call()可以返回值的。
* 2. call()可以抛出异常，被外面的操作捕获，获取异常的信息
* 3. Callable是支持泛型的
* */

//1.创建一个Callable的实现类
class NumThread implements Callable{

    //2.实现call方法，该方法存在返回值
    @Override
    public Object call() throws Exception {//会抛出异常
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;//自动装箱
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        //3.创建callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4.将callable接口实现类的对象作为FutureTask构造器参数传入
        FutureTask futureTask = new FutureTask(numThread);
        //5.将FutureTask对象作为Thread构造器参数传入，并start调用
        new Thread(futureTask).start();

        try{
            //6.自动调用call方法，并返回该方法的值
            Object sum = futureTask.get();
            System.out.println(sum);
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
    }
}
