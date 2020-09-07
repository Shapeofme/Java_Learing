package niu.java.字符串的学习;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/6 11:30
 */
/*String
* --> 概述：
* String:字符串，使用一对""引起来表示。
1.String声明为final的，不可被继承
2.String实现了Serializable接口：表示字符串是支持序列化的。
        实现了Comparable接口：表示String可以比较大小
3.String内部定义了final char[] value用于存储字符串数据
4.通过字面量的方式（区别于new给一个字符串赋值) 此时的字符串值声明在字符串常量池中。
5.字符串常量池中是不会存储相同内容(使用String类的equals()比较，返回true)的字符串的。*/

/*-->字符串的不可变性
 * 1.当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值。
 * 2.当对现的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
 * 3.当调用String的replace()方法修改指定字符或字符串时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
 * */

/*-->String实例化的两种方式
    方式一：通过字面量定义的方式  直接存入常量池
    方式二：通过new + 构造器的方式 先在对空间中创建对象，再在常量池中创建字符串
* */

/*-->字符串拼接方式赋值的对比
* 1.常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
  2.只要其中一个是变量，结果就在堆中。注意：final修饰的变量等价于常量
  3.如果拼接的结果调用intern()方法，返回值就在常量池中
*/

/*-->常用方法（略）
* */

/*-->String与其他结构间的转换
* 1.String、基本数据类型、包装类之间的转换
* 2.String、字符数组（char）间的转换
* 2.String、字节数组（byte）间的转换：编码、解码、乱码
* 3.String与StringBuffer、StringBuilder之间的转换
* */

/*-->StringBuffer、StringBuilder
* 1.三者的异同
* 2.内存解析
* 3.3者的执行效率
* 4.常用方法 ：可变性、线程不安全 --> 可变性、线程安全 --> 不可变性、线程不安全
* */
public class StringTest_1 {
    private String str1;

    @Test
    public void strTest() {
        //字符串常量池不会存储相同内容
        /*String st = "abx";
        String st1 = "abx";
        System.out.println(st.equals(st1));//重写后的方法，比较存储的字符串 --> true 说明字符串是同一个
        System.out.println(st == st1);//比较存储的地址值 true --> 说明字符串是同一个*/

        //字符串的不可变性
        //注：字符串是引用数据类型
        /*String str = "abc";
        String str1 = "abc";
        str1 = "abd";
        System.out.println(str);
        System.out.println(str1);
        System.out.println("********");

        String str2 = str;
        str2 += "a";
        System.out.println(str);
        System.out.println(str2);
        System.out.println("********");

        String str3 = str.replace("a", "d");
        System.out.println(str);
        System.out.println(str3);*/

        //String实例化的两种方式
        /*String string = "abc";
        String string1 = "abc";
        String string2 = new String("abc");
        String string3 = new String("abc");
        System.out.println(string == string1);//true
        System.out.println(string2 == string3);//flase
        System.out.println(string == string2);//比较的是存储的地址值 false
        System.out.println(string.equals(string2));//与比较类内部存储的字符串相比较 true*/

        //字符串拼接与字符串字面量
        /*String str = "ni";
        String str1 = "u";
        final String str11 = "u";

        String str2 = "niu";
        String str3 = "ni"+"u";
        String str4 = "ni"+str11;
        String str5 = str+"u";
        String str6 = "ni"+str1;
        String str7 = str+str1;

        System.out.println(str2 == str3);//true  字面量间的比较
        System.out.println(str2 == str4);//true  final
        System.out.println(str5 == str6);//false 对象之间的比较
        System.out.println(str5 == str7);//false
        System.out.println(str2 == str5);//false 字面量与对象之间的比较

        String str8 = str5.intern();
        System.out.println(str2 == str8);//intern方法*/
    }

    @Test
    public void MethodTest() {
        //int compareTo(String anotherString)：比较两个字符串的大小
        /*String string = "abcd";
        String string1 = new String("dcba");
        System.out.println(string.compareTo(string1));//-3 a<d*/

        //String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
        /*String str = "abcdef";
        System.out.println(str.substring(0));
        System.out.println(str.substring(str.length()).equals(""));//此时输出为空字符串（new类型创建）*/

        //String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
        /*String str = "abcedf";
        String str1 = str.substring(0,str.length()-1);
        System.out.println(str1);*/

        //boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
        //boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
        //boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始
        /*String str = "abcd";
        System.out.println(str.endsWith("cd"));
        System.out.println(str.startsWith("abcd"));
        System.out.println(str.startsWith("bc",1));*/

        //boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true
        //int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
        //int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
        //int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
        //int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
        //注：indexOf和lastIndexOf方法如果未找到都是返回-1
        /*String str = "abcdd";
        System.out.println(str.contains("cd"));
        System.out.println(str.indexOf("dd"));
        System.out.println(str.indexOf("cd",3));
        System.out.println("******");
        System.out.println(str.lastIndexOf("ab"));
        System.out.println(str.lastIndexOf("ab",0));*/

        //替换：
        //String replace(char oldChar, char newChar)：返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所 oldChar 得到的。
        //String replace(CharSequence target, CharSequence replacement)：使用指定的字面值替换序列替换此字符串所匹配字面值目标序列的子字符串。
        //String replaceAll(String regex, String replacement)：使用给定的 replacement 替换此字符串所匹配给定的正则表达式的子字符串。
        //String replaceFirst(String regex, String replacement)：使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
        /*String str = "aabbccddee";
        String str1 = str.replace('b', 'e');
        System.out.println(str1);
        String str2 = str.replace("bbcc", "");
        System.out.println(str2);
        String str3 = "ab123cd24n2";
        String str4 = str3.replaceAll("\\d+", "");
        System.out.println(str4);
        String str5 = str3.replaceFirst("\\d+", "");
        System.out.println(str5);*/

        //匹配:
        //boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
        /*String str = "335678";
        System.out.println(str.matches("\\d+"));*/

        //切片：
        //String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
        //String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
        /*String str = "aja4rscn4344hj";
        String[] strs = str.split("\\d+");
        System.out.println(Arrays.toString(strs));//[aja, rscn, hj]
        String[] strs1 = str.split("\\d",3);
        System.out.println(Arrays.toString(strs1));//[aja, rscn, 344hj]*/
    }

    @Test
    public void strTest1() throws UnsupportedEncodingException {
        //string、基本数据类型、包装类间的转换
        /*String str = "100";
        int i = Integer.parseInt(str);//字符串转基本数据类型
        Integer i1 = new Integer(str);//字符串转包装类
        System.out.println(i+","+i1);

        Integer in1 = new Integer("100");//包装类转字符串
        System.out.println(in1.toString());
        System.out.println(String.valueOf(in1));
        int i2 = 100;
        in1 = i2;//基本数据类型 --> 包装类 --> 字符串
        System.out.println(in1.toString());
        System.out.println(String.valueOf(i2));
        System.out.println(i2+"");*/

        //字符串、字符数组间的转换
        /*String str = "abcde";
        char[] chars = str.toCharArray();
        char[] chars1 = new char[str.length()];
        str.getChars(0, str.length()-1, chars1,1);
        for(int i =0;i<chars.length;i++) {
            System.out.println(chars1[i]);
        }

        char[] chars2 = {'a','b','c','d'};
        String string = new String(chars2) ;
        System.out.println(string);*/

        //字符串与字节数组
        //编码
        /*String string = "abc123中国";
        byte[] bytes = string.getBytes();// 使用默认字符集--> 即IDE内设置的默认编码格式
        byte[] bytes1 = string.getBytes("gbk");//指定字符集格式
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(bytes1));
        //解码
        String string1 = new String(bytes);//使用默认字符集
        String string2 = new String(bytes1,"gbk");//指定字符集格式
        System.out.println(string1+","+string2);
        //乱码
        String string3 = new String(bytes1);//utf-b编码，gbk解码
        System.out.println(string3);*/
    }

    @Test
    public void strTest2(){
        //异同：可变性
        /*StringBuffer str1 = new StringBuffer("abc");
        StringBuilder str2 = new StringBuilder("ab");
        str1.replace(0, 2, "acd");//acdc 将0-1的内容替换为acd
        str2.replace(1, 2, "shc");//ashc 将0的内容替换为shc
        System.out.println(str1);
        System.out.println(str2);*/

        //内存解析 --> 自动扩容
        /*StringBuffer stringBuffer = new StringBuffer("abc");
        StringBuilder stringBuilder = new StringBuilder("ab");
        System.out.println(stringBuffer.capacity());//16+3
        System.out.println(stringBuilder.capacity());//16+2
        System.out.println(stringBuffer.length());//3
        System.out.println(stringBuilder.length());//2*/
    }
}
