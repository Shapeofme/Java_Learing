package niu.java._06;


/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/3 16:57
 */
/*内部类：
* 1.成员内部类
* --> 访问 ：C1.A1 a1 = c1.new A1();
* --> 访问隐藏：C1.this.getI();
* --> 权限修饰符
* 2.局部内部类
*
* 3.匿名内部类
* */
//成员内部类
class C1{
    public A1 getA1(){
        return new A1();
    }
    public void getI(){
        System.out.println("外部类getI方法");
    }
    class A1{
        public void getI(){
            System.out.println("内部类getI隐藏方法");
        }

        //内部类成员与外部类成员重名导致的隐藏现象 --> 访问外部类的方法
        public void getI2(){
            C1.this.getI();
        }

        //public static int a = 10;
        // 非static的成员内部类中的成员不能声明为static的，只有在外部类或static的成员内部类中才可声明static成员报错
    }
}
class C2{
    static class A{
    }
    public A getA(){
        return new A();
    }
}
public class Test_05 {
    public static void main(String[] args) {
        //访问非静态内部类
        //方式一：
        C1 c1 = new C1();
        C1.A1 a1 = c1.new A1();
        a1.getI();
        //方式二：
        C1 c2 = new C1();
        C1.A1 a2 = c2.getA1();
        a2.getI();

        //访问静态内部类
        //访问方式一：
        C2.A a11 = new C2.A();
        //访问方式二：
        C2.A a22 = new C2().getA();

        //匿名内部类
        Test1 test1 = new Test1();
        test1.test();

        RideT rideT = new RideT() {
            //定义类
            class T{
                public static final int a = 1;//使用static
                public int anInt = 100;
            }
            //定义方法
            public void get(){
            }

            @Override
            public void getName() {

            }
        };
    }

    public void Test(){
        //局部内部类
        //均为final
        int a = 100;
        final int b = 100;
        class A {
            public void setA(){
                System.out.println(a+b);
            }
        }
    }

}
//匿名内部类
class Test1{
    public int i = 10;
    public void getI(){
        System.out.println(i);
    }

    public void test(){
        new Test1(){
            @Override
            public void getI() {
                System.out.println("成员变量"+Test1.this.i);
            }
        }.getI();
    }
}

abstract class RideT{
    public String name = "牛绍乾";
    public abstract void getName();
}
