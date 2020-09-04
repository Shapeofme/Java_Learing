package niu.java._05;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/3 9:59
 */
/*包装类：
* 1.基本数据类型与包装类：
* -->转包装类 ：自动装箱，new Integer(10);
* -->转基本数据类型：自定拆箱，bb.intValue()；
*
* 2.String与包装类： , toString()
* -->转包装类 ：new Integer(Str)
* -->转String : toString()
*
* 3.String与基本数据类型：
* -->转基本数据类型 ：Integer.parseInt(str1);new Integer(str1);
* -->转String ：String.valueOf(),连接符“+”
* */
public class Test_04 {
    public static void main(String[] args) {
        //1.基本数据类型与包装类
        int a = 10;
        Integer aa = a;//自动装箱
        a = aa;//自动拆箱
        Integer bb = new Integer(10);//构造器装箱
        int b = bb.intValue();//方法拆箱

        //2.String与包装类
        Integer cc = new Integer("10");
        String str = cc.toString();

        //3.String与基本数据类型
        int d = 10;
        String str1 = String.valueOf(d);
        str1 = d+"";

        d = Integer.parseInt(str1);
        d = new Integer(str1);//自动拆箱
    }
}
