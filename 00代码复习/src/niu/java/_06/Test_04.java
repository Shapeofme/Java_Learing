package niu.java._06;

import sun.net.InetAddressCachePolicy;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/3 16:11
 */
/*接口：
* 1.内部成员：全局变量、虚方法、静态方法、默认方法 --> public static abstract 可省略
* 2.静态方法只能通过接口调用,默认方法只能通过实现类调用
* 3.冲突问题：
* -->类优先原则
* -->接口默认方法冲突 必须在实现类中重写
* 4.调用接口中的默认方法：
*   接口.super.方法 IAction1.super.play
* 5.匿名实现类
* */
interface IAction{
    //等价 --> public static final 全局常量 可略写
    int a = 10;
    public static int b = 100;
    public static final int c = 1000;

    //等价 --> 可略写
    public abstract void ptr();
    void ptr1();

    public default void ptr2(){
        System.out.println("我是接口中的默认方法");
    }
    public static void ptr3(){
        System.out.println("我是接口中的静态方法");
    }
}
class B1 implements IAction {

    @Override
    public void ptr() {
        System.out.println("ptr");
    }

    @Override
    public void ptr1() {
        System.out.println("ptr1");
    }

    @Override
    public void ptr2() {
        System.out.println("我是重写后的默认方法");
    }
}
public class Test_04 {
    public static void main(String[] args) {
        //测试其他
        IAction action = new B1();
        action.ptr();
        action.ptr1();

        System.out.println(IAction.a);
        System.out.println(B1.b);

        IAction.ptr3();
        action.ptr2();

        //测试冲突
        IAction2 b2 = new B2();
        b2.play();//玩你妈呢玩！
    }
}
//测试冲突问题
interface IAction1{
    default void play(){
        System.out.println("1play");
    };
}
interface IAction2{
    default void play(){
        System.out.println("2play");
    };
    default void getplay(){
        System.out.println("你管我呢！");
    };
}
class BB1{
    public void getplay(){
        System.out.println("玩你妈呢玩！");
    }
}
class B2 extends BB1 implements IAction1,IAction2{
    //不重写默认方法会报错

    @Override
    public void play() {
        getplay();
        IAction1.super.play();//调用接口中的默认方法
    }
}
