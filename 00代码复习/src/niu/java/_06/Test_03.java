package niu.java._06;

import org.junit.Test;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/3 15:40
 */
/*抽象类：
* 1.不可实例化，但一定有构造器，在对象实例化的过程中，总会间接的调用父类的构造器
* 2.若未重写抽象类的抽象方法，则该类必须也为抽象类
* 3.匿名抽象类
* */
abstract class AB1{
    public static int a = 10;
    public int a1 = 100;
    static {
        System.out.println("AB1的静态代码块");
    }
    {
        ptr();
        System.out.println("AB1的非静态代码块");
    }
    public AB1(String str){
        System.out.println("AB1有参构造器");
    }
    public AB1(){
        this("");
        System.out.println("AB1无参构造器");
    }

    public abstract void ptr();
}
abstract class AB2 extends AB1{
    static {
        System.out.println("AB2的静态代码块");
    }
    {
        ptr("");
        System.out.println("AB2的非静态代码块");
    }
    public AB2(){
        super();
        System.out.println("AB2的无参构造器");
    }
    public abstract void ptr(String str);
}
public class Test_03 extends AB2{
    static {
        System.out.println("Test_03的静态代码块");
    }
    {
        System.out.println("Test_03的非静态代码块");
    }
    public Test_03(){
        System.out.println("Test_03的无参构造器");
    }
    @Override
    public void ptr() {
        System.out.println("ptr1");
    }

    @Override
    public void ptr(String str) {
        System.out.println("ptr2");
    }

    public static void main(String[] args) {
        new Test_03();
    }

    @Test
    public void test(){
        new Test_03();
        /*解释：为甚么在Jnuit测试下此时会创建两次对象？
        * 先调用Test_03的方法test() --> 之后又new Test_03()；该过程中类只加载一次
        * */
    }
    @Test
    public void test1(){
        //匿名抽象类
        new AB1(){
            @Override
            public void ptr() {
                System.out.println("我是匿名抽象类");
            }
        };
    }
}
