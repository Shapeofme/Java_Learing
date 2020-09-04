package niu.java._06;

import org.junit.Test;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/3 11:06
 */
public class Test_02 {
    /*final:
    * 1.修饰：类、方法、变量
    * 2.本意：最后的，不可变的
    * --> final类 不可继承
    * --> final方法 不可重写
    * --> final变量
    * 3.final变量：
    * --> 成员变量 只能显示初始化、非静态代码块初始化、构造器初始化
    * --> 局部变量 参数（方法、构造器）、变量 均必须初始化
    * */

    /*static final
    * 全局常量
    * 赋值：显式初始化、静态代码块初始化
    * */
    @Test
    public void test1(){
        TT tt = new TT();
        tt.ptr();
        tt.ptr("局部变量测试");
    }

}
class TT{
    //final 测试
    public final int a = 10;//显式初始化
    public final int b ;//构造器初始化
    public TT(){
        b = 100;
    }
    public final int c;//代码块初始化
    {
        c = 100;
    }
    public void ptr(){
        System.out.println("a:"+a+",b:"+b+",c"+c);
    }

    public void ptr(final String str){
        final int a = 10;
        //a = 100;
        System.out.println(str);
        //str = ""; 不可赋值
    }

    //static final 测试
    static final int d = 100;
    static final int d1 ;
    static {
        d1= 100;
    }
}
