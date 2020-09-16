package niu.java._01;

import org.junit.Test;

import java.io.*;
import java.nio.file.FileSystem;
import java.util.Arrays;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/16 23:13
 */
/*一、流的分类：
* --按操作 数据单位不同分为：字节流(8 bit) ，字符流(16 bit)
* --按数据流的 流向不同分为：输入流、输出流
* --按流的 角色的不同分为： 节点流，处理流
*
* 二、流的体系结构（字节流/字符流）
* 抽象基类：InputStream、OutputStream、Reader、Writer
* 节点流（或文件流）：FileInputStream、FileOutputStream、FileReader、FileWriter
* 缓冲流（处理流的一种）：BufferedInputSTream、BufferedOutputStream、BufferedReader、BufferedWriter
*/
public class FileWriterReaderTest {
    /*关键点：
    * 1.关于read ： 返回读入的一个字符。如果达到文件末尾，返回-1
    * 2.异常的处理：为了保证流资源一定可以执行关闭操作，需要使用try-catch-finally处理（不可用throws）
    * 3.读入的文件一定要存在，否则会报FileNotFoundException
    * 4.普遍流程：File类的实例化-->FileReader流（流可能不同）的实例化-->读入（写出）操作-->资源关闭
    * */
    @Test
    public void test(){
        FileReader fileReader = null;
        try {
            //1.File类的实例化
            File file = new File("hello1.txt");//向对于当前Module,该文件可能不存在

            //2.FileReader流的实例化
            fileReader = new FileReader(file);//可能会空指针，即文件不存在

            //3.读入的操作
            //read()：返回读入的一个字符。如果达到文件末尾，返回-1

                //方式一：
            /*int data = fileReader.read();
            while(data != -1){
                System.out.print((char)data);
                data = fileReader.read();
            }*/
            //方式二：
            int data;
            while((data = fileReader.read()) != -1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            try {
                if(fileReader != null)
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*read的重载方法
    * 1.read(char[] cbuf):返回每次读入cbuf数组中的字符的个数。到文件末尾返回-1
    * 2.输出分析：覆盖式 abcde 12345 67895 最后仅4个数，所以5不被覆盖（最后返回长度为4）
    * 3.
    * */
    @Test
    public void test1() throws Exception {
        //1.File类的实例化
        File file = new File("hello.txt");

        //2.FileReader流的实例化
        FileReader fr = new FileReader(file);

        //3.读入的操作
        //read(char[] cbuf):返回每次读入cbuf数组中的字符的个数。到文件末尾返回-1
        //read(char[] cbuf ,int offset , int lengh): 存入数组的起始位置、长度
        char[] cbuff = new char[5];
        int len;
        while((len = fr.read(cbuff)) != -1){
            //方式一：
            //错误写法
            //-->输出分析：覆盖式 abcde 12345 67895 最后仅4个数，所以5不被覆盖
            //System.out.println(Arrays.toString(cbuff));
            //for(int i =0;i<cbuff.lengh;i++){
            //正确写法
            /*for(int i =0;i<len;i++){
                System.out.print(cbuff[i]);
            }*/

            //方式二：
            //错误写法
            /*String str = new String(cbuff);
            System.out.println(str);*/
            //正确写法
            String str = new String(cbuff,0,len);
            System.out.println(str);
        }

        //4.流的关闭
        fr.close();
    }

    /*写出
    * 1.输出操作，File可以不存在，不会报异常
    * 2.File对应的硬盘中的文件
    * --不存在：会自动创建
    * --存在：
    *   构造器FileWriter（file，false）/FileWriter（file）对原有文件进行覆盖
    *   构造器FileWriter（file，true）对原有文件内容进行追加
    * */
    @Test
    public void test2() throws Exception {

        //1.File类实例，指明写出到的文件
        File file = new File("hello1.txt");

        //2.FileWriter类实例，用于数据的写出
        FileWriter fw = new FileWriter(file,false);
        //FileWriter fw = new FileWriter(file,true);
        //FileWriter fw = new FileWriter(file);

        //3.写出的操作
        fw.write("#I have a dream!");

        //4.流资源的关闭
        fw.close();
    }

    /*文件的复制*/
    @Test
    public void testCopy(){

        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.创建File类的对象， 指明读入和写出的文件
            File srcFile = new File("hello.txt");
            File destFile = new File("hello1.txt");

            //测试图片的复制
            //通过字节流复制的图片无法打开，失败
            /*File srcFile = new File("农小新.png");
            File destFile = new File("农小新1.png");*/

            //2.创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            //3.数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;//记录每次读入到cbuf数组中的字符的个数
            while((len = fr.read(cbuf)) != -1){
                //每次写出len个字符
                fw.write(cbuf,0,len);
                //str += new String(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源

            //方式一：
            /*try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/

            //方式二
            //注：第二个try-catch依旧可以执行到
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
