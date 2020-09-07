package niu.java.日期时间;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/6 21:01
 */
/*关于Date的类
*·Jdk8之前的类
* 1.System.currentTimeMillis
* 2.java.util.Date类 --> 子类 java.spl.Date类
*   1.两个构造器的使用
        >构造器一：Date()：创建一个对应当前时间的Date对象
        >构造器二：创建指定毫秒数的Date对象
    2.两个方法的使用
        >toString():显示当前的年、月、日、时、分、秒
        >getTime():获取当前Date对象对应的毫秒数。（时间戳）

    3. java.sql.Date对应着数据库中的日期类型的变量
        >如何实例化
        >如何将java.util.Date对象转换为java.sql.Date对象
*4.java.text.SimpleDataFormat类
 SimpleDateFormat对日期Date类的格式化和解析
    1.两个操作：
    1.1 格式化：日期 --->字符串
    1.2 解析：格式化的逆过程，字符串 ---> 日期

    2.SimpleDateFormat的实例化:new + 构造器
*
*
* 5、Calendar类：抽象类
*   实例化：getinstance方法、创建子类的对象GregorianCalendar
*
* */
public class DateTest {
    @Test
    public void dateTest() throws ParseException {
        //System类中的currentTimeMillis()
        /*long time = System.currentTimeMillis();
        System.out.println(time);*/

        //java.util.Date类与java.sql.Date类 (子父类关系)
        /*//构造器
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.getTime());

        Date date1 = new Date(date.getTime());
        System.out.println(date1.toString());
        System.out.println(date1.getTime());

        //java.sql.Date
        java.sql.Date date2 = new java.sql.Date(date.getTime());
        System.out.println(date2.toString());

        //如何将java.util.Date对象转换为java.sql.Date对象
        //一、多态性
        Date date3 = new java.sql.Date(date.getTime());
        System.out.println(date3.toString());//调用重写后的toString
        //二、Date对象的getTime方法
        Date date4 = new Date();
        java.sql.Date date5 = new java.sql.Date(date4.getTime());
        System.out.println(date5.toString());*/

        //java.text.SimpleDataFormat类
        //默认构造器
        //格式化 : 日期-->字符串
        /*Date date = new Date();
        SimpleDateFormat sle = new SimpleDateFormat();
        String format = sle.format(date);
        System.out.println(format);*/

        //解析： 字符串--> 日期
        /*String format1 = "20-09-07";
        String format2 = "20-9-7 下午1:24";

        Date date2 = sle.parse(format2);
        System.out.println(date2);
        //Date date1 = sle.parse(format1);//会抛出异常 要求字符串符合SimpleDateFormat的识别格式
        //System.out.println(date1);*/

        //有参构造器
        //解析： 字符串--> 日期
        //SimpleDateFormat sle2 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        /*SimpleDateFormat sle2 = new SimpleDateFormat("yyyy-MMMM-dd hh:mm:ss");
        Date date3 = new Date();
        System.out.println(sle2.format(date3));

        System.out.println("************************");
        SimpleDateFormat sle3 = new SimpleDateFormat("yyyy-MMMM-dd hh:mm aaa");
        Date date4 = new Date();
        String format3 = sle3.format(date4);
        System.out.println(format3);
        date4 = sle3.parse(format3);
        System.out.println(date4);*/

        //练习：将“2020-09-08”转换为java.sql.Date
        /*SimpleDateFormat sle = new SimpleDateFormat("yyyy-MM-dd");
        //System.out.println(sle.format(new Date()));
        Date date = sle.parse("2020-09-08");
        java.sql.Date dat1 = new java.sql.Date(date.getTime());
        System.out.println(dat1);*/

        //Calendar类：日历类、抽象类
        //实例化
        //返回值均为子类GregorianCalendar
        /*Calendar calendar = new GregorianCalendar();
        System.out.println(calendar.getClass());
        Calendar calendar1 = Calendar.getInstance();
        System.out.println(calendar1.getClass());*/

        //常用方法
        /*//get
        Calendar calendar = Calendar.getInstance();
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("本月第"+days+"天");//7
        //set
        //Calendar的可变性
        calendar.set(Calendar.DAY_OF_MONTH, 10);//修改了内部的属性
        int days1 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("本月第"+days1+"天");//10
        //add
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        int days2 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("本月第"+days2+"天");//13
        //getTime
        Date date1 = calendar.getTime();//13
        System.out.println(date1);
        //setTime
        Date date2 = new Date();//修正为7
        calendar.setTime(date2);
        System.out.println(calendar.getTime());
        //月：0-11，星期：1-7
        Calendar calendar1 = Calendar.getInstance();
        System.out.println(calendar1.get(Calendar.MONTH));//8 实际是 9月
        System.out.println(calendar1.get(Calendar.DAY_OF_WEEK));//2 实际为星期二*/
    }
}
