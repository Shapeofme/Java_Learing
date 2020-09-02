package niu.java._04;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/2 21:14
 */
/*构造器：
* 1.分类：隐式无参构造器（系统），显式构造器（自定义的无参、有参）
* 2.作用：创建对象，初始化对象
* */
/*this:
* 1.调用结构：属性，方法，构造器
* 2.调用构造器：不能递归调用，位于首行
* */
/*package、import使用：
* 1.package命名规范：inid.niu.JavaPrac.类 --> 个人项目.开发者姓名.项目名称.模块名
* 2.如果在源文件中，使用了不同包下的同名的类，则必须至少一个类需要以全类名的方式显示
* */
public class Test_02 {
    public static void main(String[] args) {
        //构造器
        /*T1 t1 = new T1(23,"牛绍乾");
        System.out.println("name:"+t1.getStr()+" age:"+t1.getI());

        T2 t2 = new T2(23,"牛绍乾");
        System.out.println("name:"+t2.getStr()+" age:"+t2.getI());*/

        //属性赋值顺序
        T3 t3 = new T3();
        System.out.println(t3.i);//默认初始化：0 --> 构造器初始化：100
        System.out.println(t3.j);//默认初始化：0 --> 显式初始化：10 --> 构造器初始化：100 --> ...
        t3.i = 10000;//对象.属性赋值
        System.out.println(t3.i);
        t3.setI();//对象.方法赋值
        System.out.println(t3.i);
    }
}
//构造器测试
class T1{
    private int i ;
    private String str;
    public T1(){

    }
    public T1(int i){
        this.i = i;
    }
    public T1(int i,String str){
        if(i != 0) this.i = i;
        this.str = str;
    }

    public int getI() {
        return i;
    }
    public String getStr(){
        return str;
    }
}
class T2 extends T1{
    public T2(){
        super();
    }
    public T2(int i){
        super(i);
    }
    public T2(int i,String str){
        super(i,str);
    }
}
//属性赋值顺序
class T3{
    public int i;
    public int j = 10;
    public T3(){
        i = 100;
        j = 100;
    }
    public void setI(){
        i = 1000;
    }
}
//this使用
class T4{
    public T4(){
        this(10);
    }
    public T4(int i){
        this(10, "");
    }
    public T4 (int i,String str){
        //this();
    }
}