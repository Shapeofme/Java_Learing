package niu.java.比较器;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/7 22:11
 */
/*1.自然排序：使用Comparable接口
    1.像String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象大小的方式。
    2.像String、包装类重写compareTo()方法以后，进行了从小到大的排列
    3. 重写compareTo(obj)的规则：
        如果当前对象this大于形参对象obj，则返回正整数，
        如果当前对象this小于形参对象obj，则返回负整数，
        如果当前对象this等于形参对象obj，则返回零。
    4. 对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法。在compareTo(obj)方法中指明如何排序

  2.定制排序：使用Comparator接口
    1.背景：
    当元素的类型没实现java.lang.Comparable接口而又不方便修改代码，或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，那么可以考虑使用 Comparator 的对象来排序
    2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小：
    如果方法返回正整数，则表示o1大于o2；
    如果返回0，表示相等；
    返回负整数，表示o1小于o2。

  背景---3.Java中的对象，正常情况下，只能进行比较：==  或  != 。不能使用 > 或 < 的
但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小。（只要涉及到对象的排序，必然要用到这两个方法）
如何实现？使用两个接口中的任何一个：Comparable 或 Comparator

4. 两种排序方式对比
*    Comparable接口的方式一旦一定，保证Comparable接口实现类的对象在任何位置都可以比较大小。 重复使用的筷子
*    Comparator接口属于临时性的比较。 一次性筷子
*/
public class CampareableTest {
    @Test
    public void TestM1() {
        String[] strings = {"CC", "HH", "AA", "EE", "DD"};
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
    }

    @Test
    public void TestM2() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse", 34.0);
        arr[1] = new Goods("dellMouse", 43.0);
        arr[2] = new Goods("xiaomiMouse", 12.0);
        arr[3] = new Goods("huaweiMouse", 12.0);
        arr[4] = new Goods("huaweiMouse", 11.1);

        //自然排序-使用Comparable接口
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        //定制排序-使用Comparator接口
        //匿名类实现接口
        //先按名称从小到大排序，再按价格从大到小排序
        Arrays.sort(arr,new Comparator(){

            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods)o1;
                    Goods g2 = (Goods)o2;
                    if(g1.getName().equals(g2.getName())){
                        return -g1.getPrice().compareTo(g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("传入的类型不一致！");
            }
        });
        System.out.println(Arrays.toString(arr));

        //某个不相关的类实现了Comparetor接口 --> 不一定是要排序的类
        //对比匿名类，这里会将比较方式限死；但是匿名类可随时建立，有无限种可能
        Arrays.sort(arr,new Te());
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void TestM3() {
        String[] arr = {"CC", "HH", "AA", "EE", "DD"};

        //定制排序-使用Comparator接口
        Arrays.sort(arr, new Comparator() {
            //按照字符串从大到小排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = o2.toString();
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入的数据类型不一致！");
            }
        });

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void TestM4(){
    }
}
