package niu.java._06;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/3 15:17
 */
class Father1{
    {
        System.out.println(str1);
        System.out.println("Father的非静态代码块");
    }

    static {
        str1 = "修改属性";
        System.out.println(Father1.str1);
        System.out.println("Father的静态代码块");
    }

    public static String str1 = "属性一";

    static {
        System.out.println(str1);
        System.out.println("Father的静态代码块");
    }

    {
        System.out.println(str1);
        System.out.println("Father的非静态代码块");
    }
    public Father1(){
        System.out.println("Father的无参构造器");
    }
    public Father1(String str){
        this();
        System.out.println("Father的有参构造器");
    }
}
class Son2 extends Father1{
    static {
        System.out.println("Son2的静态代码块");
    }
    {
        System.out.println("Son2的非静态代码块");
    }
    public Son2(){
        this("");
        System.out.println("Son2的无参构造器");
    }
    public Son2(String str){
        super(str);
        System.out.println("Son2的有参构造器");
    }
}
public class Son1 extends Son2{
    public static int a = 10;
    static {
        System.out.println("Son1的静态构造块");
    }
    {
        System.out.println("Son1的非静态构造块");
    }
    public Son1(){
        System.out.println("Son1的无参构造器");
    }
    public static void main(String[] args) {
        //静态代码块只加载一次
        int a = Son1.a;
        new Son1();
    }
}
/*
修改属性
Father的静态代码块
属性一
Father的静态代码块
Son2的静态代码块
Son1的静态构造块

属性一
Father的非静态代码块
属性一
Father的非静态代码块
Father的无参构造器
Father的有参构造器
Son2的非静态代码块
Son2的有参构造器
Son2的无参构造器
Son1的非静态构造块
Son1的无参构造器
*/
