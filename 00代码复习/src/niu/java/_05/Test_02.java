package niu.java._05;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/3 8:29
 */
/*多态性：
* 1.使用前提：继承、实现关系（虚拟类、接口、普通类）；方法的重写
* 2.编译时类型、运行时类型不一致时会产生多态性
* 3.早绑定与晚绑定：
* --> 早绑定：编译时就确定下来的（方法重载）
* --> 晚绑定：运行时才会真正确定下来的（方法重写）
* 4.不能访问子类所特有属性、方法
* 5.上下转型：
* --> 向上：Person p = new Student()
* --> 向下：Student s = （Student）p  ； instanceof 判断
* */
public class Test_02 {
    public static void main(String[] args) {
        T11 t11 = new T22();
        t11.ptr();//晚绑定
        t11.imPtr();//接口实现

        T22 t21 = (t11 instanceof T22)?(T22)t11:null;
        if(t21 != null) t21.ptr("测试向下转型");

        T22 t22 = new T22();
        t22.ptr("重载");//早绑定
    }
}
interface IT{
    void imPtr();
}
class T11 implements IT{
    public void ptr(){
        System.out.println("T11");
    }

    @Override
    public void imPtr() {
        System.out.println("T11"+"接口实现");
    }
}
class T22 extends T11{
    @Override
    public void ptr() {
        System.out.println("T22");
    }
    public void ptr(String str){
        System.out.println("T22"+str);
    }
}