package niu.java.字符串的学习;

import org.junit.Test;

/**
 * @author niu Email:2377540437@qq.com
 */
/*
* String:字符串，使用一对""引起来表示。
1.String声明为final的，不可被继承
2.String实现了Serializable接口：表示字符串是支持序列化的。
        实现了Comparable接口：表示String可以比较大小
3.String内部定义了final char[] value用于存储字符串数据
4.通过字面量的方式（区别于new给一个字符串赋值，此时的字符串值声明在字符串常量池中)。
5.字符串常量池中是不会存储相同内容(使用String类的equals()比较，返回true)的字符串的。

字符串的不可变性  体现
1.当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值。
2.当对现的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
3.当调用String的replace()方法修改指定字符或字符串时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
*/
public class StringTest {

    class Person{
        String name;
        int age ;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    class StringTest1{
        String str = new String("good");
        char[] ch = {'t','e','s','t'};
        public void change(String str,char[] ch){
            str = "test ok";
            ch[0] = 'b';
        }
    }

    @Test
    public void test1(){
        String s1 = "abc";
        String s2 = "abc";
        //这里比较的是两个对象的地址值
        System.out.println(s1 == s2);//输出为true，即：s1，s2指向同一个位置

        //此时对s1对象进行修改，按理说应该s2 = “hello”
        s1 = "hello";
        System.out.println(s1);//hello
        System.out.println(s2);//abc  不相同，所以s1改变了指向

        //此时s3与s2指向同一位置，如果修改s3而s2没变，那么s3改变了指向
        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);//abcdef
        System.out.println(s2);//abc

        //修改某一位置的元素，原有字符串是否会发生改变
        String s4 = "abc";
        String s5 = s4.replace("a","m");
        System.out.println(s4);//abc
        System.out.println(s5);//mbc
    }

    @Test
    public void test2(){
        //字面量与new构造器创建String
        //1.通过字面量的形式创建--位于常量池
        String s1 = "abc";
        String s2 = "abc";
        //2.new构造器创建--先创建堆空间，之后指向常量池
        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3 == s4);//false

        System.out.println("********************************");
        //两中创建方式的区别
        Person person = new Person("abc",12);
        Person person1 = new Person("abc",12);
        System.out.println(person.name == person1.name);

        Person person2 = new Person(new String("abc"),12);
        Person person3 = new Person(new String("abc"),12);
        System.out.println(person2.name == person3.name);
    }
    /*
    * 1.常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
      2.只要其中一个是变量，结果就在堆中。
      3.如果拼接的结果调用intern()方法，返回值就在常量池中*/
    @Test
    public void test3(){
        String s1 = "abc";
        String s2 = "def";

        String s3 = "abcdef";
        String s4 = "abc"+"def";
        String s5 = "abc"+s2;
        String s6 = s1 + "def";
        String s7 = s1 +s2;
        System.out.println(s3 == s4);//t
        System.out.println(s3 == s5);//f
        System.out.println(s3 == s6);//f
        System.out.println(s3 == s7);//f
        System.out.println(s5 == s7);//f

        String s8 = s5.intern();
        System.out.println(s8 == s3);//t
    }

    //关于值传递、方法
    @Test
    public void test4() {
        StringTest1 stringTest1 = new StringTest1();
        stringTest1.change(stringTest1.str, stringTest1.ch);
        System.out.println(stringTest1.str+"and");
        System.out.println(stringTest1.ch);
    }
}
