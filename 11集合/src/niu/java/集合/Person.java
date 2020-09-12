package niu.java.集合;

import java.util.Objects;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/9 15:53
 */
public class Person {
    private int age;
    public String name;

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
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
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
//        System.out.println("测试");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    /*@Override
    public boolean equals(Object obj) {
        System.out.println("测试");
        if(obj == null) return false;
        if(!(obj instanceof Person)) return false;
        Person person = (Person)obj;
        return name == person.name&&age == person.age;
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
