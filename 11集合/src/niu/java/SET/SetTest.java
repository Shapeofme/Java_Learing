package niu.java.SET;

import niu.java.集合.Person;
import org.junit.Test;
import sun.plugin.util.UserProfile;

import java.util.*;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/10 12:51
 */

//Set接口：
/*1.---Collection接口：单列集合，用来存储一个一个的对象
 *          |----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
 *              |----HashSet：作为Set接口的主要实现类；线程不安全的；可以存储null值
 *                  |----LinkedHashSet：作为HashSet的子类；遍历其内部数据时，可以按照添加的顺序遍历
 *                 在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个数据和后一个数据.对于频繁的遍历操作，LinkedHashSet效率高于HashSet.
 *              |----TreeSet：可以照添加对象的指定属性，进行排序。
 *
 * 2.理解”无序的不可重复的数据“
 * (Set中没有额外定义新的方法，使用的是Collection接口中的方法)
 * --要求：向set中添加的数据，其所在的类一定要重写hashcode和equals方法
 * --重写的hashcode和equals尽可能保持一致性：相等的对象必须具有相等的散列码
 *
 * 一Hashset为例
 * --->无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引法的顺序添加，而是根据数据的哈希值决定
 * --->不可重复性：保证添加的元素按照equals方法判断时， 不能返回true.即:相同的元素只能添加一个
 *
 *3.add（添加元素）方法的过程（以HashSet为例）
 *哈希值不一定相同：哈希值%16 = 要存储的索引位置（17%16=1,1%16=1，很显然哈希值不同）
我们向HashSet中添加元素a,首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置（即为：索引位置，判断数组此位置上是否已经有元素：
    如果此位置上没其他元素，则元素a添加成功。 --->情况1
    如果此位置上有其他元素b(或以链表形式存在的多个元素）则比较元素a与元素b的hash值：
        如果hash值不相同，则元素a添加成功。--->情况2
        如果hash值相同，进而需要调用元素a所在类的equals()方法：
               equals()返回true,元素a添加失败
               equals()返回false,则元素a添加成功。--->情况3

        对于添加成功的情况2和情况3而言：元素a 与已经存在指定索引位置上数据以链表的方式存储。
        jdk 7 :元素a放到数组中，指向原来的元素。
        jdk 8 :原来的元素在数组中，指向元素a
        总结：七上八下
        HashSet底层：数组+链表的结构。（前提：jdk7)
 *
 * */
public class SetTest {

    //测试Set的无序与不可重复
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person(23,"牛绍乾"));
        set.add(129);
        set.add(new Users(23,"牛绍乾"));
        set.add(new Users(23,"牛绍乾"));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());//先hascode判断，再用equals方法判断
        }
    }


    //LinkhashSet的使用
    //在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个数据和后一个数据.
    // 优点：对于频繁的遍历操作，LinkedHashSet效率高于HashSet.
    @Test
    public void test2(){
        //为什么同属SET，而这个集合却可以按照添加顺序输出？
        //把链表的每个节点分别哈希化，存入了哈希表中
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person(23,"牛绍乾"));
        set.add(129);
        set.add(new Users(23,"牛绍乾"));
        set.add(new Users(23,"牛绍乾"));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    //TreeSet测试
    //可以按照添加对象的指定属性，进行排序。
    /*1.向Treeset中添加的数据，要求是相同类的对象
    * 2.Java比较器接口：自然排序（Comparable接口）、定制排序（Comparetor接口）
    * 3.自然排序中，比较两个对象相同的标准是compareTo（）返回0，不再是equals
    * 4.定制排序中，比较两个对象相同的标准为compare（）返回0，不再是equals
    * */
    @Test
    public void test3(){
        TreeSet set = new TreeSet();
        //错误：不同类的对象
        /*set.add(123);
        set.add(456);
        set.add("AA");
        set.add(new Person(23,"牛绍乾"));*/
        //测试一：正确
        /*set.add(123);
        set.add(-123);
        set.add(43);
        set.add(25);
        set.add(67);*/
        //测试二：
        //问题：Person cannot be cast to java.lang.Comparable 未实现比较器接口
        //解决：Users实现了比较器接口
        set.add(new Users(23,"绍乾"));
        set.add(new Users(29,"牛乾"));
        set.add(new Users(24,"牛绍"));
        set.add(new Users(22,"牛绍乾"));
        //问题：如果按照equals判断，该对象会被添加；但是实际不是，所以是按照比较器返回为0来判断的
        //解决：实现二级排序（按照age排序）
        set.add(new Users(27,"牛绍乾"));

        Iterator ite = set.iterator();
        while(ite.hasNext()){
            System.out.println(ite.next());//从小到大输出
        }

    }

    //定制排序
    @Test
    public void test4(){

        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Users users = (Users)o1;
                Users users1 = (Users)o2;
                return users.compareTo(users1);
            }
        };

        //
        TreeSet set = new TreeSet(com);
        set.add(new Users(23,"绍乾"));
        set.add(new Users(29,"牛乾"));
        set.add(new Users(24,"牛绍"));
        set.add(new Users(22,"牛绍乾"));
        set.add(new Users(27,"牛绍乾"));

        for (Object obj : set) {
            System.out.println(obj);
        }
    }
}
