package niu.java.集合;
import org.junit.Test;

import java.util.*;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/9 10:33
 */
/*1、Collection接口常用方法：
* 使用Collection集合存储对象，要求对象所属的类满足：向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().
* */
public class CollectionTest {
    @Test
    public void collM(){
        Collection coll = new ArrayList();

        //add
        coll.add("112");
        coll.add(123);
        coll.add(new Date());

        //addAll(Collection)
        Collection coll1 = new ArrayList();
        coll1.add("测试");
        coll.addAll(coll1);

        //size
        System.out.println(coll.size());
        System.out.println(coll.toString());
        //clear
        coll.clear();

        //isempty()
        System.out.println(coll.isEmpty());
    }

    @Test
    public void cooM1(){

        /*//boolean contains(Object obj)
        //会调用equals方法
        System.out.println(coll.contains(123));
        System.out.println(coll.contains(new String("Tom")));
        //从第一个元素开始调用Person.equals,直到遇到相同的对象
        System.out.println(coll.contains(new Person(56,"牛绍乾")));
        System.out.println("*******");*/

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person(5,"牛绍乾"));

        // boolean containsAll(Collection c)
        //必须都得包含
        Collection coll1 = Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));//true
    }

    @Test
    public void CollM2(){

        /*//boolean remove(Object obj)
        //会调用equals方法判断
        boolean tr = coll.remove(new Person(5, "牛绍乾"));
        System.out.println(tr);
        System.out.println(coll.toString());*/

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person(5,"牛绍乾"));

        // boolean removeAll(Collection coll)
        //只移除交集
        Collection coll1 = Arrays.asList(1239,456);
        System.out.println(coll.removeAll(coll1));//true
        //[123, Tom, false, Person{age=5, name='牛绍乾'}]
        System.out.println(coll.toString());

    }

    @Test
    public void collM3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person(5,"牛绍乾"));

        //boolean retainAll(Collection c)
        //只留下交集
        /*Collection coll1 = Arrays.asList(123,456,789);
        System.out.println(coll.retainAll(coll1));
        System.out.println(coll.toString());*/

        // boolean equals(Object obj)
        //1.判断元素是否相同
        //2.是否依赖于顺序还得看右边的数据结构--HashSet
        Collection coll1 = new ArrayList();
        coll1.add(456);//调换顺序
        coll1.add(123);
        coll1.add(new String("Tom"));
        coll1.add(false);
        coll1.add(new Person(5,"牛绍乾"));
        System.out.println(coll.equals(coll1));
    }

    @Test
    public void collM4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person(5,"牛绍乾"));

        //hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        // Object[] toArray()
        //集合转成对象数组
        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        //数组转集合
        //Collection 与 List 子父类
        Collection coll1 = Arrays.asList(new String[]{"aa","bb"});
        List<String> list = Arrays.asList(new String[]{"aa","bb"});
        System.out.println(coll1.size());//2
        System.out.println(list.size());//2

        //注意事项：
        //问题-为什么new int[]被视为一个元素，而new Integer[]视为一个一个的元素？
        //解释：asList(T ...a)，首先T必须为Object类型，
        // 而int[]内的元素为基本数据类型，所以new int[]被视为了一个整体
        List<int[]> list1 = Arrays.asList(new int[]{1,2});
        System.out.println(list1.size());//1
        List list2 = Arrays.asList(new int[]{1,2});
        System.out.println(list2.size());//1
        List list3 = Arrays.asList(new Integer[]{1,2});
        System.out.println(list3.size());//2

        //iterator()：返回迭代器对象，用于集合遍历
    }
}
