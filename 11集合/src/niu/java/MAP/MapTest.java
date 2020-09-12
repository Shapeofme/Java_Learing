package niu.java.MAP;

import org.junit.Test;

import java.util.*;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/11 10:12
 */
/*1.Map实现类
|----Map:双列数据，存储key-value对的数据   ---类似于高中的函数：y = f(x)
        *       |----HashMap:作为Map的主要实现类；线程不安全的，效率高；存储null的key和value
        *              |----LinkedHashMap:保证在遍历map元素时，可以照添加的顺序实现遍历。
        *                    原因：在原的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
        *                    对于频繁的遍历操作，此类执行效率高于HashMap。
        *       |----TreeMap:保证照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序
        *                      底层使用红黑树
        *       |----Hashtable:作为古老的实现类；线程安全的，效率低；不能存储null的key和value
        *              |----Properties:常用来处理配置文件。key和value都是String类型
        *
        *      HashMap的底层：数组+链表  （jdk7及之前)
        *                    数组+链表+红黑树 （jdk 8)
             [面试题]
             *  1. HashMap的底层实现原理？
             *  2. HashMap 和 Hashtable的异同？
             *  3. CurrentHashMap 与 Hashtable的异同？（暂时不讲)
*/
/*2.Map结构
    >Map中的key:无序的、不可重复的，使用Set存储所的key ---> key所在的类要重写equals()和hashCode()(以HashMap为例)
    >Map中的value:无序的、可重复的，使用Collection存储所的value --->value所在的类要重写equals()
    > 一个键值对：key-value构成了一个Entry对象。
    >Map中的entry:无序的、不可重复的，使用Set存储所有的entry
*/

/*3.内存结构说明：
* 3.1 HashMap在jdk7中实现原理：
HashMap map = new HashMap():
*      在实例化以后，底层创建了长度是16的一维数组Entry[] table。
*      ...可能已经执行过多次put...
*      map.put(key1,value1):
*      首先，调用key1所在类的hashCode()计算key1哈希值，此哈希值经过某种算法计算以后，得到在Entry数组中的存放位置。
*      如果此位置上的数据为空，此时的key1-value1添加成功。 ----情况1
*      如果此位置上的数据不为空，(意味着此位置上存在一个或多个数据(以链表形式存在)),比较key1和已经存在的一个或多个数据的哈希值：
*              如果key1的哈希值与已经存在的数据的哈希值都不相同(循环去比较)，此时key1-value1添加成功。----情况2
*              如果key1的哈希值和已经存在的某一个数据(key2-value2)的哈希值相同，继续比较：调用key1所在类的equals(key2)方法，比较：
*                      如果equals()返回false:此时key1-value1添加成功。----情况3
*                      如果equals()返回true:使用value1替换value2。
*
*      补充：关于情况2和情况3：此时key1-value1和原来的数据以链表的方式存储。
*
*     在不断的添加过程中，会涉及到扩容问题，当超出临界值(且要存放的位置非空)时，扩容。默认的扩容方式：扩容为原来容量的2倍，并将原的数据复制过来。
*
* 3.2 HashMap在jdk8中相较于jdk7在底层实现方面的不同：
    1. new HashMap():底层没创建一个长度为16的数组
    2. jdk 8底层的数组是：Node[],而非Entry[]
    3. 首次调用put()方法时，底层创建长度为16的数组
    4. jdk7底层结构只：数组+链表。jdk8中底层结构：数组+链表+红黑树。
    形成链表时，七上八下（jdk7:新的元素指向旧的元素。jdk8：旧的元素指向新的元素）
    当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组的长度 > 64时，
    此时此索引位置上的所数据改为使用红黑树存储。

  3.3HashMap底层典型属性的属性的说明：
    DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
    DEFAULT_LOAD_FACTOR：HashMap的默认加载因子：0.75
    threshold：扩容的临界值，=容量*填充因子：16 * 0.75 => 12
    TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树:8
    MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量:64
*
* 为什么ArrayList的扩容是达到容量上限才扩容，而LinkedHashMap在达到临界值时（存储位置不为空）就提前扩容？
* 底层的存储原理不同：LinkedHashMap是通过哈希值的转换为数组索引存储的，要尽可能避免元素聚集所以要提前扩容
*
* /

/*4.LinkedHashMap的实现原理
 *  HashMap --> new Map(key , value)
 *  HashSet 实现原理 --> new Map(e,常量)  常量 = new Object（）；
 *
 */


/*5.Map接口中定义的方法：
    * 添加 、 删除、修改操作 ：
     Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
     void putAll(Map m):将m中的所有key-value对存放到当前map中
     Object remove(Object key)：移除指定key的key-value对，并返回value
     void clear()：清空当前map中的所有数据
     元素 查询的操作：
     Object get(Object key)：获取指定key对应的value
     boolean containsKey(Object key)：是否包含指定的key
     boolean containsValue(Object value)：是否包含指定的value
     int size()：返回map中key-value对的个数
     boolean isEmpty()：判断当前map是否为空
     boolean equals(Object obj)：判断当前map和参数对象obj是否相等
     元视图操作的方法：
     Set keySet()：返回所有key构成的Set集合
     Collection values()：返回所有value构成的Collection集合
     Set entrySet()：返回所有key-value对构成的Set集合
* */
public class MapTest {
    /*添加 、 删除、修改操作
     Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
     void putAll(Map m):将m中的所有key-value对存放到当前map中
     Object remove(Object key)：移除指定key的key-value对，并返回value
     void clear()：清空当前map中的所有数据
    */
    @Test
    public void test3(){
        Map map = new HashMap();
        //put -- 添加已有的就修改，并返回旧值
        map.put("AA", 123);
        map.put(12, 14);
        Object object = map.put("AA", 89);
        System.out.println(map);
        System.out.println(object);

        //putAll
        Map map1 = new HashMap();
        map1.put("JJ", 123);
        map.putAll(map1);
        System.out.println(map);

        //remove -- 删除key，并返回value;没有key,就返回null
        Object object1 = map.remove("AA");
        Object object2 = map.remove("BB");
        System.out.println(map);
        System.out.println(object1);
        System.out.println(object2);//null

        //clear
        map.clear();
        System.out.println(map);
    }

    /*元素 查询的操作：
     Object get(Object key)：获取指定key对应的value
     boolean containsKey(Object key)：是否包含指定的key
     boolean containsValue(Object value)：是否包含指定的value
     int size()：返回map中key-value对的个数
     boolean isEmpty()：判断当前map是否为空
     boolean equals(Object obj)：判断当前map和参数对象obj是否相等*/
    @Test
    public void test4(){
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(12, 14);
        map.put(12 , "NN");
        map.put("BB", 1);

        //get
        Object obj = map.get(12);
        Object obj1 = map.get(123);
        System.out.println(obj);
        System.out.println(obj1);//null

        //containsKey
        boolean ce = map.containsKey("BB");
        System.out.println(ce);

        //containsValue
        boolean ce1 = map.containsValue("NN");
        System.out.println(ce1);

        //size
        System.out.println(map.size());
        map.remove("AA");
        System.out.println(map.size());
        System.out.println(map);

        //isEmpty
        System.out.println(map.isEmpty());

        //equals
        Map map1 = new HashMap();
        map1.put("BB", 1);
        map1.putAll(map);
        System.out.println(map.equals(map1));

    }

    /*元视图操作的方法：
     Set keySet()：返回所有key构成的Set集合
     Collection values()：返回所有value构成的Collection集合
     Set entrySet()：返回所有key-value对构成的Set集合*/
    @Test
    public void test5(){
        Map map = new HashMap();
        map.put("BB", 1);
        map.put("AA",2);

        //keySet
        Set set = map.keySet();
        System.out.println(set);
        Iterator iterator = set.iterator();
        //遍历所有key值
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj+"__"+map.get(obj));
        }
        System.out.println("*********");

        //values
        Collection col = map.values();
        System.out.println(col);
        //遍历所有value值
        for (Object ob: col) {
            System.out.println(ob);
        }
        System.out.println("*********");

        //entrySet
        //Map.Entry<K,V>
        Set set1 = map.entrySet();//使用泛型存储键值对儿  Map.Entry<K, V>
        System.out.println(set1);
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            Map.Entry entry = (Map.Entry) iterator1.next();//所以这里可以强制转型
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }

    }

    @Test
    public void test1(){
        //测试HashMpa中可以存null值
        //Hashtable中不可以存放null值
        /*Map map = new HashMap();
        map.put(null, null);
        Map map1 = new Hashtable();
        map1.put(null, null);//抛出java.lang.NullPointerException异常*/

        //如果存放的key值相等，则修改value值
        /*Map<String,Integer> map = new HashMap<>();
        map.put("niu", 23);
        map.put("niu", 25);
        System.out.println(map.get("niu"));//25*/
    }

    @Test
    public void test2(){
        Map map = new LinkedHashMap();//按添加顺序输出:
        //父类的put --> 重写的putVal  --> 重写的newNode() --> Entry 继承自Node<K,V>
        //对比LinkedHashSet --> put --> map.put(e,常量)  全局常量 = new Object（）
        map.put(23, "牛绍乾");
        map.put(24, "牛绍乾");
        System.out.println(map);
    }
}
