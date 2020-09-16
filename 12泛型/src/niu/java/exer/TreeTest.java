package niu.java.exer;

import org.junit.Test;

import java.util.*;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/11 9:00
 */
public class TreeTest {

    //自然排序
    @Test
    public void test1(){
        TreeSet<Employee> treeSet = new TreeSet<>();
        Employee emp1 = new Employee("A",5,new MyDate(1998, 10, 4));
        Employee emp2 = new Employee("B",1,new MyDate(1999, 1, 24));
        Employee emp3 = new Employee("D",29,new MyDate(1978, 10, 4));
        Employee emp4 = new Employee("C",5,new MyDate(1998, 7, 14));
        Employee emp5 = new Employee("E",35,new MyDate(1972, 9, 4));

        treeSet.add(emp1);
        treeSet.add(emp2);
        treeSet.add(emp3);
        treeSet.add(emp4);
        treeSet.add(emp5);

        Iterator<Employee> iterator = treeSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //定制排序
    @Test
    public void test2(){
        Comparator com = new Comparator<Employee>() {

            @Override
            public int compare(Employee o1, Employee o2) {
                Employee emp1 = o1;
                Employee emp2 = o2;
                //转换为Date类型，利用Date.CompareTo方法比较
                Date date1 = new Date(emp1.getBirthday().getYear(),emp1.getBirthday().getMonth(),emp1.getBirthday().getDay());
                Date date2 = new Date(emp2.getBirthday().getYear(),emp2.getBirthday().getMonth(),emp2.getBirthday().getDay());

                return (date1.compareTo(date2));
            }
        };

        TreeSet treeSet = new TreeSet(com);
        Employee emp1 = new Employee("新之助",5,new MyDate(1998, 10, 4));
        Employee emp2 = new Employee("小白",1,new MyDate(1999, 1, 24));
        Employee emp3 = new Employee("美伢",29,new MyDate(1978, 10, 4));
        Employee emp4 = new Employee("风间彻",6,new MyDate(1998, 7, 14));
        Employee emp5 = new Employee("广志",35,new MyDate(1972, 9, 4));

        treeSet.add(emp1);
        treeSet.add(emp2);
        treeSet.add(emp3);
        treeSet.add(emp4);
        treeSet.add(emp5);

        Iterator<Employee> ite = treeSet.iterator();
        while(ite.hasNext()){
            System.out.println(ite.next());
        }
    }

    //练习：在List 内去除重复数字值，要求尽量简单
    //利用HashSet过滤相同的元素
    @Test
    public void test3(){
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));
        List list2 = duplicateList(list);
        for (Object integer : list2) {
            System.out.println(integer);
        }
    }
    public static List duplicateList(List list) {
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }

    @Test
    public void test4(){
        //向set中添加了数据后，修改了参与哈希值计算的name属性
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");
        set.add(p1);
        set.add(p2);
        p1.name = "CC";
        System.out.println(set.remove(p1));//false
        System.out.println(set);//BB,CC
        set.add(new Person(1001,"CC"));
        System.out.println(set);//BB,CC,CC
        set.add(new Person(1001,"AA"));
        System.out.println(set);//BB,CC,CC,AA
    }
}
