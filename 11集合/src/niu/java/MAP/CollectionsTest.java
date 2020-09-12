package niu.java.MAP;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.Test;

import java.util.*;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/11 20:31
 */
/*Collections工具类：
* 1.Collections 是一个操作 Set、List 和 Map 等集合的工具类
* 2.常用方法：
    reverse(List)：反转 List 中元素的顺序
    shuffle(List)：对 List 集合元素进行随机排序
    sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
    sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
    swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换

    Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
    Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
    Object min(Collection)
    Object min(Collection，Comparator)

    int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
    void copy(List dest,List src)：将src中的内容复制到dest中
    boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换List 对象的所有旧值
*
* */
public class CollectionsTest {
    @Test
    public void test(){
        List list = new ArrayList();
        list.add(123);
        list.add(-123);
        list.add(56);
        list.add(90);
        System.out.println(list);
        //reverse
        Collections.reverse(list);
        System.out.println("reverse"+list);
        //shuffle--洗牌
        Collections.shuffle(list);
        System.out.println("shuffle"+list);

        //sort--自然排序
        Collections.sort(list);
        System.out.println("sort_自然"+list);

        //sort--定制排序
        Collections.sort(list,new Comparator(){

            @Override
            public int compare(Object o1, Object o2) {
                Integer in1 = (Integer)o1;
                Integer in2 = (Integer)o2;
                return -in1.compareTo(in2);
            }
        });
        System.out.println("sort_定制"+list);

        //swap
        Collections.swap(list, 1, 0);
        System.out.println("swap"+list);

        //min、max(Collection)
        //min、max(Collection，定制排序)
        Set set = new HashSet();
        set.add(10);
        set.add(100);
        set.add(1000);
        Object i = Collections.min(set);
        Object i1 = Collections.max(set);
        System.out.println(i+","+i1);

        //frequency
        List list1 = new ArrayList();
        list1.add(12);
        list1.add(12);
        list1.add(13);
        list1.add(15);
        System.out.println(Collections.frequency(list1, 12));

        //copy -- 注：list.size 为集合中添加的元素个数
        //例一：
        List list2 = new ArrayList();
        list2.add(199);
        list2.add(200);
        //java.lang.IndexOutOfBoundsException: Source does not fit in dest
        //Collections.copy(list2, list1);
        Collections.copy(list1, list2);
        System.out.println("copy"+list1);
        //例二
        List list3 = Arrays.asList(new Integer[list1.size()]);
        Collections.copy(list3, list1);
        System.out.println("copy"+list3);

        //replaceAll
        list1.add(12);
        boolean b = Collections.replaceAll(list1, 12, 45);
        System.out.println(b);
        System.out.println(list1);
    }

    //Collections类中提供了多个synchronizedXxx()方法，该方法可使将指定集合包装成线程同步的集合，
    //从而可以解决多线程并发访问集合时的线程安全问题
    @Test
    public void test1(){
        List list = new ArrayList();//ArrayList为线程不全的
        list = Collections.synchronizedList(list);//返回线程安全的集合
    }
}
