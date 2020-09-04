package niu.java._05;

import com.sun.xml.internal.ws.runtime.config.TubelineFeatureReader;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/3 8:57
 */
/*Object类：
* 1.无属性、空参构造器
* 2.“==“ ：
* -->基本数据类型：自动类型提升
* -->引用类型：多态性 （比较地址值）
* 3.“equal”：
* --> 未重写：同“==”
* --> 重写: 可根据类的内容进行比较
* */
public class Test_03 {
    public static void main(String[] args) {
        //equal 方法
        Tr1 tr1 = new Tr2(100);//运行时 Tr2
        Tr1 tr11 = new Tr1();//运行时 Tr1
        Tr2 tr2 = new Tr2(100);//运行时 Tr2
        System.out.println(tr1.equals(tr2));
        System.out.println(tr11.equals(tr2));
        System.out.println(tr2.equals(tr1));

        System.out.println(tr11.toString());
        System.out.println(tr1.toString());
        System.out.println(tr2.toString());
    }
}
class Tr1{
    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }
}
class Tr2 extends Tr1{
    public int i;

    public Tr2(int i){
        this.i = i;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof Tr2)) return false;
        Tr2 tr2 = (Tr2)obj;
        if(this.i == tr2.i) return true;
        else return false;
    }

    @Override
    public String toString() {
        return this.getClass()+" 属性：i ="+i;
    }
}
