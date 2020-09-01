package niu.java._01;


/*
* 1.最多只能有一个public类,且该类必须与文件名同名
* 2.public static void main(String[] args) 入口函数
* 3.（.java）文件内有几个类就javac后生成几个(.class)文件
* 4.注释-->文档注释
* */

/**
 * @description: 测试第一单元内容
 * @author: niu
 * @date: 2020/9/01
 */

public class Test01 {
    /**
     * @description: 入口函数
     * @author: niu
     * @date: 2020/9/01
     *
     * @return: void
     */
    public static void main(String[] args){
        System.out.println("测试01");
        new Test02().ptr();
    }
}
class Test02{
    public void ptr(){
        System.out.println("测试02");
    }
}
