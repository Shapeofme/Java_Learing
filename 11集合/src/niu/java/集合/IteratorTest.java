package niu.java.集合;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/9 17:32
 */
/*集合间的遍历操作，使用迭代器Iterator接口
* 1.方法：next（），hasNext（）、remove
* 2.Jdk5.0新增foreach遍历集合、数组
* */
public class IteratorTest {
    @Test
    public void iteTest(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person(5,"牛绍乾"));

        //迭代器
        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void iteTest1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person(5,"牛绍乾"));
        //错误方式一：跳着输出元素
        /*Iterator iterator = coll.iterator();
        while(iterator.next() != null) {
            System.out.println(iterator.next());//异常--NoSuchElementException
        }*/

        //错误方式二：死循环，只输出第一个数据
        /*while(coll.iterator().hasNext()){
            System.out.println(coll.iterator().next());
        }*/

        //不同于集合调用remove方法，指针到哪，就remove那个
        //如果还未调用next()或在上一次调用 next 方法之后已经调用了 remove 方法,再调用remove都会报IllegalStateException
        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            //iterator.remove();错误
            Object obj = iterator.next();
            if(obj.equals(new Person(5,"牛绍乾"))){
                iterator.remove();
                //iterator.remove();错误
            }
            //先hasnext为true后，再ite.next指向元素；若remove后再remove，此时ite.next扔停留在原位，所以。。。
        }
        Iterator iterator1 = coll.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }

    @Test
    public void foreTest(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person(5,"牛绍乾"));

        //遍历集合
        //内部仍然调用迭代器
        for (Object col:coll) {
            System.out.println(col);
        }
        System.out.println("**************");
        //遍历数组
        Object[] objects = coll.toArray();
        for (Object obj : objects) {
            System.out.println(obj.toString());
        }
    }

    //练习题
    @Test
    public void foreTest1(){
        String[] strings = {"MM","MM","MM"};

        //方式一：
        for (int i = 0; i < strings.length; i++) {
            strings[i] = "GG";
        }
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }

        strings = new String[]{"MM","MM","MM"};
        //方式二：
        //这里的s为局部变量
        for (String s : strings) {
            s = "GG";
        }
        for (String s : strings) {
            System.out.println(s);
        }
    }

    @Test
    public void test1(){
        int[] ints = {1,2,3,4,5};
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
