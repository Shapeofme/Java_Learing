package niu.java.泛型;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/13 14:16
 */

/** 1.使用泛型的总结
 *  ① 集合接口或集合类在jdk5.0时都修改为带泛型的结构。
 *  ② 在实例化集合类时，可以指明具体的泛型类型
 *  ③ 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法、构造器、属性等）使用到类的泛型的位置，都指定为实例化的泛型类型。
 *    比如：add(E e)  --->实例化以后：add(Integer e)
 *  ④ 注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换
 *  ⑤ 如果实例化时，没指明泛型的类型。默认类型为java.lang.Object类型。
 *  */
/*2.自定义泛型结构：
* --> 泛型类、泛型接口
* --> 泛型方法
* */
public class GenericTest {
    //测试泛型
    @Test
    public void test(){
        ArrayList<Integer> arr= new ArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40);

        //方式一
        for (Integer i : arr) {
            System.out.println(i);
        }
        //方式二
        Iterator<Integer> iterator = arr.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    //测试自定义泛型
    @Test
    public void test1(){
        //如果定义了泛型类，实例化没指明类的泛型，则认为此泛型类型为Object类型
        OrderT orderT1 = new OrderT();
        orderT1.setOrderT("我是Obj");
        System.out.println(orderT1);

        OrderT<String> orderT = new OrderT<>("牛绍乾",23,"中国人");
        System.out.println(orderT.toString());

        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
        SubOrderT subOrderT = new SubOrderT("牛绍乾",23,"人啊");
        subOrderT.setOrderT("测试");
        System.out.println(subOrderT);

        //泛型类
        SubOrderT1<String> subOrderT1 = new SubOrderT1<>();
        subOrderT1.setOrderT("测试。。。");
        System.out.println(subOrderT1);
    }

    @Test
    public void test2(){
        //int是错误的，基本数据类型
        //ArrayList<int> arrayList = new ArrayList<int>();

        //泛型不同的引用不能相互赋值
        ArrayList<String> arrayList = null;
        ArrayList<Integer>arrayList1=null;
        //arrayList = arrayList1; -->不能相互赋值
    }

    @Test
    public void test3(){
        //泛型方法测试
        //方法中的泛型参数与类的泛型参数无关
        //泛型方法所在的类是不是泛型类没关系
        //泛型方法是可以声明为静态的
        OrderT<String> orderT = new OrderT<>();
        Integer[] integers = new Integer[]{1,2};
        List<Integer> list = orderT.copyArr(integers);
        System.out.println(list);
    }
}
