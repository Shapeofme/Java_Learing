package niu.java.枚举类;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/8 8:33
 */
/*1.说明
    *1.枚举类的理解：类的对象只有有限个，确定的。我们称此类为枚举类
     2.当需要定义一组常量时，强烈建议使用枚举类
     3.如果枚举类中只一个对象，则可以作为单例模式的实现方式。
*
* 2.定义枚举类：
* ·--自定义枚举类 -->继承自Object
*  --使用enum关键字 -->继承自java.lang.Enum
*
*  3.Enum类中的常用方法
*   --toString
*   --value（）
*   --valuesOf（String str）
*
*   4.枚举类实现接口：
*   --正常的方式实现接口   仅该类可实现抽象方法
*   --枚举类的方式实现接口 每个枚举属性都可实现抽象方法
*   (注：switch-case)
* */
public class EnumTest {
    public static void main(String[] args) {

        /*//自定义枚举
        Season spring = Season.SPRING;
        System.out.println(spring);

        //关键字定义
        //toString方法
        Season1 spring1 = Season1.SPRING;
        System.out.println(spring1);//SPRING -->toString方法
        System.out.println(Season1.class.getSuperclass());//java.lang.Enum

        System.out.println("************************************");

        //value
        Season1[] season1s = Season1.values();
        for (int i = 0; i < season1s.length; i++) {
            System.out.println(season1s[i].toString());
        }

        //valueOf(String str)-->没有找到该名字的属性，会报错
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter.toString());

        //正常方式实现接口
        //枚举类的方式实现接口(会覆盖正常方式的)
        winter.show();*/

        //switch-case测试
        Season1 season1 = Season1.SPRING;
        switch (season1){
            case SPRING:
                System.out.println("春天");break;
            case AUTUMN:
                System.out.println("秋天");break;
            case SUMMER:
                System.out.println("夏天");break;
            case WINTER:
                System.out.println("冬天");break;
        }
    }
}

//使用enumerate关键字--继承自Enum类（通过测试Tostring方法）
interface ITest{
    void show();
}
enum Season1 implements ITest{
    //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天来了。。。");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天来了。。。");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天来了。。。");
        }
    },
    WINTER("冬天","冰天雪地");/*{
        @Override
        public void show() {
            System.out.println("冬天来了。。。");
        }
    };*/

    //2.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //3.私化类的构造器,并给对象属性赋值
    private Season1(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //此时没有重写toString方法
    public String getSeasonName() {
        return seasonName;
    }
    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public void show() {
        System.out.println("我在测试。。。");
    }
}

//自定义枚举类--继承自Object
class Season{
    //1.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;
    //2.私化类的构造器,并给对象属性赋值
    public Season(String seasonName,String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //3.提供当前枚举类的多个对象：public static final的
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","冰天雪地");

    //
    public String getSeasonName(){
        return seasonName;
    }
    public String getSeasonDesc(){
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}