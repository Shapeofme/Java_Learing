package niu.java.泛型;

import niu.java.exer.MyDate;
import org.junit.Test;

import java.util.*;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/13 16:24
 */
public class GenericTest1 {
    @Test
    public void test(){
        /*
        1. 泛型在继承方面的体现
        虽然类A是类B的父类，但是G<A> 和G<B>二者不具备子父类关系，二者是并列关系。
        补充：类A是类B的父类，A<G> 是 B<G> 的父类
        */
        Object obj = null;
        String str = null;
        obj = str;

        Object[] arrs = null;
        String[] strs = null;
        arrs = strs;

        /*List<Object> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list = list1;//错误
        如果可以：
        list.add(123) --> List(Object)
        但是这里实际上调用List<String>方法，很明显不对
        */

        //HashSet 与 LinkedHashSet是子父类的关系
        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        hashSet = linkedHashSet;

    }

    @Test
    public void test2(){
        /*
        2.通配符的使用
        通配符：?
        类A是类B的父类，G<A>和G<B>是没关系的，二者共同的父类是：G<?>
        */
        List<Object> list = new LinkedList<>();
        List<String> list1 = new LinkedList<>();
        List<?> list2 = new LinkedList<>();
        list2 = list;
        list2 = list1;

        list1.add("AA");
        list1.add("BB");

        //添加数据:对于List<?>就不能向其内部添加数据。
        //除了添加null之外
        //list2.add(new Object());//会报错
        list2.add(null);
        
        //获取数据:允许读取数据，读取的数据类型为Object。
        Object o = list2.get(0);
        System.out.println(o);
    }

    public void testT(List<?> list){
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            //用Object接受
            Object obj = iterator.next();
        }
    }

    @Test
    public void test3(){
        /*
        * 3.有限制条件的通配符
        * ? extends A: G<? extends A> 可以作为G<A>和G<B>的父类，其中B是A的子类
        * ? Super A: G<? super A> 可以作为G<A>和G<B>的父类，其中B是A的父类
        * */

        /*List<? extends Person> list1 = null;//可以取List<Person>、List<Student>、以及更小的子类
        List<? super Person> list2 = null;//可以取List<Object>、List<Person>

        List<Student> list3 = new ArrayList<>();
        List<Person> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();

        list1 = list3;
        list1 = list4;
        //list1 = list5;

        //list2 = list3;
        list2 = list4;
        list2 = list5;

        //读取数据
        //必须写最大的
        //<=person
        //>=person

        list1 = list3;
        Person per = list1.get(0);
        //编译不通过
        //Student stu = list1.get(0);

        list2 = list4;
        Object obj = list2.get(0);
        //编译不通过
        //Student obj1 = list2.get(0);

        //写入数据
        //编译不通过
        //list1.add(new Student());

        list2.add(new Person());
        list2.add(new Student());

        System.out.println("**************************************");*/

        Collection col = new ArrayList<>();
        col.add("as");
        col.add("zs");
        col.add(123);
        col.add(new MyDate(2010, 02, 12));
        printCollection(col);


    }

    public void printCollection(Collection c) {
        Iterator i = c.iterator();
        for (int k = 0; k < c.size(); k++) {
            System.out.println(i.next());
        }
    }

    /*public void printCollection(Collection<Object> c) {
        for (Object e : c) {
            System.out.println(e);
        }
    }*/
}

class Person{}
class Student extends Person{}