package niu.java._03;

import java.util.Arrays;

/**
 * Description:
 *  数组的使用
 * @author: niu
 * @version: date: 2020/9/2 9:30
 */
public class Test01 {
    public static void main(String[] args) {
        //数组的分类：1.维数 2.数据类型
        //数组为引用类型，存取其首地址
        //长度一旦确定便不可更改

        //1.初始化 : 静态初始化 、 动态初始化
        //静态初始化 --> 数组内容从一开始就确定
        /*int [] a = new int[]{1,2,3};
        int [] a1 = {1,2,3};//类型推断
        int [][] b = new int[][]{{1,2,3},{1,2,3}};
        int [][] b1 = {{1,2,3},{1,2,3}};
        //动态初始化
        int [] aa = new int[3];
        int [][] bb = new int[3][];*/

        //2.默认初始化
        //整型 : 0
        //浮点型：0.0
        //布尔：false
        //字符：\u0000 使用==‘\u0000’
        //引用：null
        //-->特别的：多维数组的初始化 ：地址值，默认值（null）
        /*int [] a = new int[1];
        System.out.println("int："+a[0]);
        double [] b = new double[1];
        System.out.println("double:"+b[0]);
        boolean [] c = new boolean[1];
        System.out.println("boolean:"+c[0]);
        char [] d = new char[1];
        System.out.println("char:"+d[0]);
        System.out.println(d[0] == '\u0000');

        String [] strings = new String[1];
        System.out.println("引用:"+strings[0]);

        int [][] arr = new int[3][2];
        int [][] arr1 = new int[3][];
        System.out.println(arr[2][1]);//0
        System.out.println(arr[2]);//地址值
        System.out.println(arr1[2]);//null*/

        //3.Arrays类的使用
        //注：二分查找的前提必须是排好序的数组
        /*int [] a = new int[10];
        int [] b = new int[10];
        for(int i = 0;i<5;i++){
            a[i] = i;
            b[i] = i;
        }
        System.out.println("a:"+Arrays.toString(a));
        System.out.println("b:"+Arrays.toString(b));
        System.out.println(Arrays.equals(a, b));
        Arrays.fill(a,5,6,10);
        System.out.println(Arrays.toString(a));

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.binarySearch(a, 10));*/
    }
}
