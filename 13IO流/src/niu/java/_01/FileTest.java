package niu.java._01;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/16 10:27
 */

/*File类的使用：
 * 1. File类的一个对象，代表一个文件或一个文件目录(俗称：文件夹)
 * 2. File类声明在java.io包下
 * 3. File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，
 * 并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成。
 * 4. 后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的"终点".
 */
public class FileTest {
    @Test
    public void test(){
        /*1.创建File的一个实例
        * public File(String pathname)
        * public File(String parent,String child)
        * public File(File parent,String child)
        *
        * 2.路径：
        * -->相对路径
        * -->绝对路径
        *
        * 3.路径分隔符
        * -->windows:\
        * -->unix、url:/
        * main方法与junit不同；Ecaplise与Idea不同
        * */

        //构造器1
        File file = new File("hello.txt");//相对路径：相对当前module
        File file1 = new File("C:\\Users\\aaa\\Desktop\\he.txt");//绝对路径
        System.out.println(file);
        System.out.println(file1);
        //构造器2
        File file2 = new File("C:\\Users\\aaa\\", "HHHH");
        System.out.println(file2);
        //构造器3
        File file3 = new File(file2,"he.txt");
        System.out.println(file3);
    }

    @Test
    public void test2(){
        /* File 类的获取功能
        public String getAbsolutePath()：获取绝对路径
        public String getPath() ：获取路径
        public String getName() ：获取名称
        public String getParent()：获取上层文件目录路径。若无，返回null
        public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
        public long lastModified() ：获取最后一次的修改时间，毫秒值

        文件目录相关：
        public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
        public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
        */
        File file = new File("he.txt");
        File file1 = new File("f:\\Io\\he.txt");

        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(new Date(file.lastModified()));//为毫秒数，用Date对象包裹
        System.out.println("******************");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());

        //文件目录
        System.out.println("*****************");
        File file2 = new File("f:\\");
        System.out.println(Arrays.toString(file2.list()));
        File[] files = file2.listFiles();
        for (File f : files) {
            System.out.println(f.getName());
        }
    }

    @Test
    public void test3(){
    /*File 类的重命名功能
      public boolean renameTo(File dest):把文件重命名为指定的文件路径
      *要求：file必须在内存中存在，file1不能再内存中存在-->返回true
      */
        File file = new File("C:\\Users\\aaa\\Desktop\\Java_Learing\\13IO流\\he.txt");
        File file1 = new File("C:\\Users\\aaa\\Desktop\\Java_Learing\\13IO流\\he11.txt");
        System.out.println(file.lastModified());
        System.out.println(file1.lastModified());
        boolean r  = file.renameTo(file1);
        System.out.println(file.lastModified());
        System.out.println(file1.lastModified());
        System.out.println(r);
    }

    @Test
    public void test4(){
        /* File 类的判断功能
        public boolean isDirectory()：判断是否是文件目录
        public boolean isFile() ：判断是否是文件
        public boolean exists() ：判断是否存在
        public boolean canRead() ：判断是否可读
        public boolean canWrite() ：判断是否可写
        public boolean isHidden() ：判断是否隐藏
        */
        File file = new File("he11.txt");
        file = new File("he.txt");
        File file1 = new File("F:\\Io");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
        System.out.println("****************");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
    }
    @Test
    public void test5() throws Exception{
        /* File 类的创建功能
            public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
            public boolean mkdir() ：
                --创建文件目录。如果此文件目录存在，就不创建了。
                --如果此文件目录的上层目录不存在，也不创建。
            public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建
            注意事项：如果你创建文件或者文件目录没有写盘符路径， 那么默认在项目路径下 。
             File 类的删除功能
            public boolean delete()：删除文件或者文件夹
            删除注意事项：
            Java中的删除不走回收站。
            要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录
            */
        File file = new File("he22.txt");
        System.out.println(file.createNewFile());

        //创建文件目录。如果此文件目录存在，就不创建了。
        File file1 = new File("lal");
        System.out.println(file1.exists());
        System.out.println(file1.mkdir());

        //如果此文件目录的上层目录不存在，也不创建。
        File file2 = new File("F:\\II\\o");
        System.out.println(file2.exists());
        System.out.println(file2.mkdir());

        //创建文件目录。如果上层文件目录不存在，一并创建
        File file3 = new File("o\\la");
        System.out.println(file3.exists());
        System.out.println(file3.mkdirs());

        //要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录
        File file4 = new File("o");
        System.out.println(file4.delete());
    }
}
