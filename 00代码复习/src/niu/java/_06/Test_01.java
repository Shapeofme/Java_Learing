package niu.java._06;

import java.net.PortUnreachableException;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/3 10:19
 */
/*static:
* 1.修饰的结构：属性、方法、代码块、内部类
* 2.属性：
* -->静态属性的加载早于对象的创建
* -->随着类的加载而加载（类只加载一次）
*3.调用：方法与属性相同
* */
/*代码块：
* 1.静态代码块、非静态代码块
* 2.加载顺序：静态>非静态
* */
/*属性赋值：
* 1.赋值位置：默认初始化、显式初始化、构造器初始化、代码块内初始化、对象.属性及对象.方法
* 2.赋值顺序：
*   默认 --> 显式/代码块 --> 构造器 --> 对象.属性或对象.方法
*   代码块与显式初始化的先后顺序不同 --> 影响属性赋值
 * */
public class Test_01 {
    public static void main(String[] args) {
        //调用：方法与属性相同
        int a = T.a;
//        a = T.b;//类不可调用实例变量
        T t = new T();
        int b = t.a;//对象可调用类变量
        b = t.b;

        //属性赋值
        T1 t1 = new T1();//静态代码块 --> 非静态代码块 --> 构造器
        t1.getAB();
    }
}
class T{
    public static int a;
    public int b;
}
class T1{
    //代码块与显式初始化的先后顺序不同 --> 影响属性赋值
    public static int a = 10;

    public T1(){
        System.out.println("构造器");
    }
    {
        System.out.println("非静态代码块");
    }
    static {
        a = 100;
        b = 222;
//        System.out.println(b); 此时不可如此引用数据
        System.out.println(T1.b);

        System.out.println("静态代码块");
    }
    public static int b = 22;

    public void getAB(){
        System.out.println(a);
        System.out.println(b);
    }
}
