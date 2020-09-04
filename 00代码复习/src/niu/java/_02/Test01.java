package niu.java._02;

/**
 * Description: 基本语法的使用
 * @author: niu
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

        //3.运算符
        //3-1 算数运算符
        //小数除法与整数除法的区别
        /*double a = 10.0/2.3;
        System.out.println(a);//4.34826...
        int b = 10/3;
        System.out.println(b);//3*/
        //取模:与第一个数的正负有关
        /*System.out.println(5%-2);//1
        System.out.println(-5%2);//-1
        System.out.println(-5%-2);//-1
        System.out.println(5%2);//1*/

        //3-2 逻辑运算符
        //测试 &  测试&&
        /*boolean a = false;
        if( a==true & (a = true)) ;
        System.out.println(a); // a = true
        a=false;
        if(a == false & (a = true));
        System.out.println(a);// a = true;

        boolean b = false;
        if( b == true && (b = true));
        System.out.println(b); // a = false
        b = false;
        if( b == false && (b = true));
        System.out.println(b); //a = true*/

        /*boolean a = false;
        if(a == true | (a= true));
        System.out.println(a);//true
        a = false;
        if(a == false | (a = true));
        System.out.println(a);//true

        boolean b = false;
        if(b == true || (b = true));
        System.out.println(b);//true
        b = false;
        if(b == false || (b = true));
        System.out.println(b);//false*/

        //3-3位运算符
        // >>右移运算符
        /*System.out.println(6>>2);// 6/(2*2)
        System.out.println(-6>>2);// 使用负数的原码进行移位*/
        // <<左移运算符
        /*System.out.println(6<<2);// 6*(2*2)
        System.out.println(-6<<2);// -6*(2*2)*/

        //3-4三元运算符 -->表达式1,2的数据类型保持一致，会自动类型提升
        /*double a = 10==10?10.9:10;
        System.out.println(a);*/

        //4.流程控制
        //--> byte、short、char、int（对应包装类 ：Byte、Short、Character、Integer）、String、enum
        //--> case 必须为常量
        /*switch (new Byte("10")){
            case 10:
                System.out.println("测试");
        }*/

        //5.循环结构
        //break label :结束label范围内的循环
        /*int i = 10;

        label:
        while(true){
            System.out.println("测试");
            i--;
            if(i == 8) break label;//跳出至label处的循环
            if(i == 0) break;
        }*/

        /*for(int i = 0;i<5;)
        {
            while (true){
                if(i == 3) break;
                i++;
            }
            System.out.println("测试"+i);
        }*/

        /*label:
        for(int i = 0;i<5;)
        {
            System.out.println("测试"+i);
            while (true){
                if(i == 3) break label;
                i++;
            }
        }*/
    }
}
