package niu.java.日期时间;

import org.junit.Test;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/7 14:41
 */
/*Jdk8之后的日期类
1.之前类的问题：
    可变性：像日期和时间这样的类应该是不可变的。
    偏移性：Date中的年份是从1900开始的，而月份都从0开始。
    格式化：格式化只对Date用，Calendar则不行。
    此外，它们也不是线程安全的；不能处理闰秒等。

2.新类的API测试 LocalDate、LocalTime、LocalDateTime
        说明：LocalDateTime使用频率高，类似于Calendar

3.Instant类 类似于Date类

4.DateTimeFormatter格式化或解析时间、日期，类似于SimpleDateFormat

*/
public class DateTest_1 {
    @Test
    public void testM(){
        /*//可变性
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//7
        calendar.set(Calendar.DAY_OF_MONTH, 20);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//20

        //偏移性
        //等价于Calendar.set(year + 1900, month, date)
        Date date = new Date(2020,9,7);
        SimpleDateFormat sle = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sle.format(date));//3920-10-07*/

        //Api测试
        /*// LocalDate、LocalTime、LocalDateTime 体现不偏移性
        //实例化
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);//2020-09-07
        System.out.println(localTime);//14:57:26.287
        System.out.println(localDateTime);//2020-09-07T14:57:26.287

        //of方法
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 9,7,14,59,34);
        System.out.println("测试偏移性："+localDateTime1);//2020-09-07T14:59:34

        //getXxx方法
        System.out.println(localDateTime1.getDayOfYear());
        System.out.println(localDateTime1.getDayOfMonth());
        System.out.println(localDateTime1.getDayOfWeek());

        //withXxx方法 等价于Calendar.set方法
        //体现为不可变性
        LocalDateTime localDateTime2 = localDateTime1.withDayOfMonth(10);
        System.out.println(localDateTime2);
        localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime2);

        //加法 减法
        localDateTime2 = localDateTime2.plusDays(10);
        System.out.println(localDateTime2);
        localDateTime2 = localDateTime2.minusDays(2);
        System.out.println(localDateTime2);*/
    }

    @Test
    public void testM1(){
        //Instant类测试
        /*//实例化
        //now 本初子午线的时间
        Instant instant = Instant.now();//2020-09-07T07:28:12.458Z
        System.out.println(instant);//格林威治时间,但我们处于东八区，所以时间差8小时
        //设置时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2020-09-07T15:28:12.458+08:00
        //表示自1970年1月1日0时0分0秒（UTC）开始的毫秒数,时间戳
        long l = instant.toEpochMilli();
        System.out.println(l/1000/60/60/24/365);//50年
        //静态方法，返回在1970-01-01 00:00:00基础上加上指定毫秒数之后的Instant类的对象
        Instant instant1 = Instant.ofEpochMilli(l);
        System.out.println(instant1);*/
    }

    @Test
    public void testM2(){
        //DateTimeFormatter使用
        //三种格式化方式
        /*//1.预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        TemporalAccessor tem = localDateTime;//子类与间接父类的关系 --> 多态
        //格式化：日期-->字符串
        String str = dateTimeFormatter.format(tem);
        System.out.println(localDateTime);//2020-09-07T15:45:39.344
        System.out.println("方式一："+str);//2020-09-07T15:45:39.344
        //解析：字符串-->日期
        TemporalAccessor tem1 = dateTimeFormatter.parse("2020-09-07T15:45:39.344");
        System.out.println(tem1);//{},ISO resolved to 2020-09-07T15:45:39.344*/


        //2.本地化相关的格式。如：
        /*// ofLocalizedDateTime(FormatStyle.LONG) FormatStyle.LONG、MEDIUM、SHORT --> 适用于LocalDateTime
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        LocalDateTime localDateTime1 = LocalDateTime.now();
        String str1 = dateTimeFormatter1.format(localDateTime1);
        String str2 = dateTimeFormatter2.format(localDateTime1);
        System.out.println("方式二："+str1);
        System.out.println(str2);

        // ofLocalizedDate() FormatStyle.FULL、LONG、MEDIUM、SHORT --> 适用于LocalDate
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        LocalDate localDate = LocalDate.now();
        String str3 = dateTimeFormatter3.format(localDate);
        System.out.println(str3);
        System.out.println(dateTimeFormatter3.parse(str3));//{},ISO resolved to 2020-09-07*/


        //重点：3.自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        /*//格式化
        DateTimeFormatter dateTimeFormatter4 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String str = dateTimeFormatter4.format(localDateTime);
        System.out.println(str);

        //解析
        TemporalAccessor temporalAccessor = dateTimeFormatter4.parse(str);
        System.out.println(temporalAccessor);*/

    }
}
