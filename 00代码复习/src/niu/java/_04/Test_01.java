package niu.java._04;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/2 11:07
 */
//权限修饰符
/*1.对于类(文件可编译生成的.class文件)：public、default可使用
* --> public : 都可以访问
* --> default : 同一（.java）文件或同一包内可访问
*
* 2.对于成员变量（属性）：public、default、private、protected
* --> public : 都可以访问
* --> default :同一（.java）文件或同一包内可访问
* --> protected :
*   -基类的protected成员：包内可见，子类内部可见
*   -若子类与基类不在同一包内，子类内部：子类实例可访问继承的Pro，不可以基类实例访问
* --> priavte : 类的内部
* */

public class Test_01 {
    private int a = 10;
    protected int a1 = 100;
    public int a2 = 1000;
    int a3 = 10000;
    public static void main(String[] args) {
    }
    //方法
    //可变形参：重载时不可与数组共存
    /*public void ptr(int i,int ...j){
        System.out.println("ceshi");
    }
    public void ptr(int i, int[] j){
        System.out.println("ceshi1");
    }*/
}
class T{
    public void ptr(){
        niu.java._04.Test_01 test_01 = new Test_01();
        int a ;
//      a = test_01.a;//private不可访问
        a = test_01.a1;//protected
        a = test_01.a2;//public
        a = test_01.a3;//default
    }
}

