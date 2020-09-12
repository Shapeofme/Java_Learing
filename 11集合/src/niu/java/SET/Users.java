package niu.java.SET;

import java.lang.annotation.Inherited;
import java.util.Comparator;
import java.util.Objects;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/10 13:16
 */
public class Users implements Comparable {
    private int age;
    private String name;

    public Users() {
    }

    public Users(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("User...");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return age == users.age &&
                Objects.equals(name, users.name);
    }

    @Override
    public String toString() {
        return "Users{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        System.out.println("我只在这判断");
        return Objects.hash(age, name);
//        return super.hashCode();
    }

    //按照姓名从小到大排序,再按照年龄排序
    @Override
    public int compareTo(Object o) {
        if(o == null || o.getClass() != this.getClass()) throw new RuntimeException("类型错误！");
        Users users = (Users)o;
        if(this.name.compareTo(users.name) == 0){
            Integer integer = this.age;
            return integer.compareTo(users.age);
        }else{
            return this.name.compareTo(users.name);
        }
    }
}
