package niu.java.泛型;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/13 15:04
 */
public class OrderT<T> {
    private String name;
    private int age;
    private T orderT;

    public OrderT() {
    }

    public OrderT(String name, int age, T orderT) {
        this.name = name;
        this.age = age;
        this.orderT = orderT;
    }

    //以下三个均不是泛型方法
    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "OrderT{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", orderT=" + orderT +
                '}';
    }

    //泛型方法
    //泛型方法是可以声明为静态的
    public <E> List<E> copyArr(E[] arr){

        return Arrays.asList(arr);
    }

    //静态方法中不能使用类的泛型
    //static方法可以不用创建实例化对象调用，但是T必须要在实例化时赋值
    /*public static ptr(T a){
        System.out.println(a);
    }*/

    //异常类型不能是泛型
    /*public void ptr(){
        try {
        }catch (T x){

        }
    }*/

    //关于T数组
    //T[] arrs = new T[10];错误
    //T[] arrs = (T[]) new Object[10];正确，强制转型

}
