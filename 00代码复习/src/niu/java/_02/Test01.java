package niu.java._02;

/**
 * Description:
 * @author:
 * @version: date: 2020/9/1 17:36
 */
public class Test01 {
    public static void main(String[] args) {
        //1.基本数据的自动转换 byte 、 short 、char --> int --> long -->float --> double
        // byte、short、char运算会得到int  不包括 自增（自减）、赋值运算符
        /*byte s = 10; -->同类型间
        byte s1 = 10;
        s = s+s1; */

        /*short s = 10;--> 不同类型间
        byte s1 = 10;
        s = s+s1;*/

        /*char s = 10; --> 同上
        byte s1 = 10;
        short s2 =10;
        s = s+s1+s2;*/

        /*byte a = 10; -->没有报错
        a++;
        a+=2;*/

        /*byte a = 10;
        a = a+1;--> 此时1默认为int型
        */
        /*byte a = 10;
        float a1 = a+10.0;-->此时10.0默认为double型
        */

        //2.String 转基本数据类型
        /*boolean b = Boolean.parseBoolean("true");//String 类转换为包装类，之后通过自动装箱转换为基本数据类型
        System.out.println(b);*/

        double a = 10.0/2.3;
        System.out.println(a);

    }
}
