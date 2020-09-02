package niu.java._05;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/2 22:17
 */
/*继承性：
* 1.单继承性
* 2.默认情况下，继承自java.lang.Object
* 3.会获取直接父类或间接父类中所声明的所有属性和方法 --> 特别：private也会被继承只是由于封装性无法直接访问
* */
/*方法的重写：
* 1.方法的声明：权限修饰符 （static/非static） 返回值类型 方法名（形参列表） throw 异常类型
* 2.--> 权限修饰符:子类重写方法的权限修饰符 >= 父类
* 3.--> 返回值类型：引用类型多态性（不包含自动装箱、拆箱）
* 4.--> 异常类型: 子类的异常类型 <= 父类
* 5.-> static 不可被重写
* */
/*super:
* 1.调用的结构：属性、方法、构造器
* 2.构造器：
* --> 首行
* --> 默认调用super（）
* --> 子类中至少存在一个suoer（形参)
* 3.super.super 错误
* */
public class Test_01 {
    public static void main(String[] args) {
        //继承性
        T2 t2 = new T2();
        t2.ptr();

    }
}
//继承性
class T{
    private int i = 23;
    public int getI(){
        return i;
    }
    //自动拆箱、装箱
    public Integer geti1(){
        return i;
    }
    //返回值类型：多态性
    public T getT(){
        return new T1();
    }
    //异常类型
    public void test() throws Exception{
    }
    //static
    public static void test2(){

    }
}
class T1 extends T{
    private String str = "牛绍乾";

    //super:子类中至少有一个super（形参）
    //自定义有参构造器，不再生成无参构造器，导致默认的super（）错误
    /*public T1(int i){

    }*/
    public T1(){}

    public String getStr(){
        test2();
        return str;
    }

    @Override
    public void test() throws NullPointerException{

    }
    //static 不可被重写
    public static void test2(){
        System.out.println("测试。。。");
    }
}
class T2 extends T1{
    public void ptr(){
        int age = getI();
        String name = getStr();
        System.out.println("name:"+name+" age:"+age);
    }

    public T2(){

    }
}

