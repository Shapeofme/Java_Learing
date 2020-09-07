package niu.java.字符串的学习;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/6 14:04
 */
/*注意：
* 1.局部变量 参数，变量
* 2.引用数据类型 地址值
* 3.值传递
* 4.字符串的不可变性（字符串是引用数据类型）
* */
public class TestStr {
    String str = new String("good");
    char[] ch = { 't', 'e', 's', 't' };
    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }
    public static void main(String[] args) {
        TestStr ex = new TestStr();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str);//good
        System.out.println(ex.ch);//best
    }
}
