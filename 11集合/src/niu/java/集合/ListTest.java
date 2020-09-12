package niu.java.集合;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/10 9:45
 */
/*导图：|----Collection接口：单列集合，用来存储一个一个的对象
 *          |----List接口：存储有序的、可重复的数据。  -->“动态”数组
 *              |----JDK7ArrayList、LinkedList、Vector
 *
 **/
/*List接口
*1、JDK7ArrayList、LinkedList、Vector异同：存储有序的、可重复的数据。
* 同：实现了List接口，存储数据的特点相同：
*  |----JDK7ArrayList：作为List接口的主要实现类；线程不安全的，效率高；底层使用Object[] elementData存储
 * |----LinkedList：对于频繁的插入、删除操作，使用此类效率比ArrayList高；底层使用双向链表存储
 * |----Vector：作为List接口的古老实现类；线程安全的，效率低；底层使用Object[] elementData存储
 * */
/*2. 源码分析(难点)
4.1 ArrayList的源码分析：
*   2.1 jdk 7情况下
*      JDK7ArrayList list = new JDK7ArrayList();//底层创建了长度是10的Object[]数组elementData
*      list.add(123);//elementData[0] = new Integer(123);
*      ...
*      list.add(11);//如果此次的添加导致底层elementData数组容量不够，则扩容。
*      默认情况下，扩容为原来的容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中。
*
*      结论：建议开发中使用带参的构造器：JDK7ArrayList list = new JDK7ArrayList(int capacity)
*
*   2.2 jdk 8中ArrayList的变化：
*      JDK7ArrayList list = new JDK7ArrayList();//底层Object[] elementData初始化为{}.并没创建长度为10的数组
*
*      list.add(123);//第一次调用add()时，底层才创建了长度10的数组，并将数据123添加到elementData[0]
*      ...
*      后续的添加和扩容操作与jdk 7 无异。
*   2.3 小结：jdk7中的ArrayList的对象的创建类似于单例的饿汉式，而jdk8中的ArrayList的对象
*            的创建类似于单例的懒汉式，延迟了数组的创建，节省内存。
*

4.2 LinkedList的源码分析：
*      LinkedList list = new LinkedList(); 内部声明了Node类型的first和last属性，默认值为null
*      list.add(123);//将123封装到Node中，创建了Node对象。
*
*      其中，Node定义为：体现了LinkedList的双向链表的说法
*      private static class Node<E> {
            E item;
            Node<E> next;
            Node<E> prev;

            Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
            }
        }
4.3 Vector的源码分析：
jdk7和jdk8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组。
在扩容方面，默认扩容为原来的数组长度的2倍。*/

/*3.常用方法：
void add(int index, Object ele): 在index 位置插入ele 元素
boolean addAll(int index, Collection eles): 从index 位置开始将eles中的所有元素添加进来
Object get(int index): 获取指定index 位置的元素
int indexOf(Object obj): 返回obj 在集合中首次出现的位置
int lastIndexOf(Object obj): 返回obj 在当前集合中末次出现的位置
Object remove(int index): 移除指定index 位置的元素，并返回此元素
Object set(int index, Object ele): 设置指定index 位置的元素为ele
List subList(int fromIndex, int toIndex): 返回从fromIndex 到toIndex
位置的子集合
* */
public class ListTest {
    @Test
    public void listTest(){
        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person(23,"牛绍乾"));

        //void add(int index, Object ele): 在index 位置插入ele 元素
        list.add(1, "BB");
        System.out.println(list);

        //boolean addAll(int index, Collection eles): 从index 位置开始将eles中的所有元素添加进来
        List list1 = Arrays.asList(1,2,3);
        list.addAll(2,list1);
        System.out.println(list);

        //Object get(int index): 获取指定index 位置的元素
        System.out.println(list.get(1));

        //int indexOf(Object obj): 返回obj 在集合中首次出现的位置
        //找不到wei-1
        System.out.println("size:"+list.size());
        System.out.println(list.indexOf(new Person(23,"牛绍乾")));
        System.out.println("找不到"+list.indexOf("jj"));

        //int lastIndexOf(Object obj): 返回obj在当前集合中末次出现的位置
        System.out.println(list.lastIndexOf("BB"));

        //Object remove(int index): 移除指定index 位置的元素，并返回此元素
        System.out.println(list.remove(1));//返回移除的元素
        System.out.println(list);

        //Object set(int index, Object ele): 设置指定index 位置的元素为ele
        System.out.println(list.set(0, "BBB"));//返回0位置上的元素
        System.out.println(list);

        //List subList(int fromIndex, int toIndex): 返回从fromIndex 到toIndex
        List list2 = list.subList(3, 5);//左闭右开
        System.out.println(list2);
        System.out.println(list);//不对本身修改
    }
}
