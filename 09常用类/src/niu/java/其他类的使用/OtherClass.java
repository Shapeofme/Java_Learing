package niu.java.其他类的使用;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/7 23:38
 */
/*
* 1.System
* 2.Math
* 3.BigIneger 和 BigDecimal
* */
public class OtherClass {
    @Test
    public void TestM1(){
        String javaVersion = System.getProperty("java.version");
        System.out.println("java的version:" + javaVersion);
        String javaHome = System.getProperty("java.home");
        System.out.println("java的home:" + javaHome);
        String osName = System.getProperty("os.name");
        System.out.println("os的name:" + osName);
        String osVersion = System.getProperty("os.version");
        System.out.println("os的version:" + osVersion);
        String userName = System.getProperty("user.name");
        System.out.println("user的name:" + userName);
        String userHome = System.getProperty("user.home");
        System.out.println("user的home:" + userHome);
        String userDir = System.getProperty("user.dir");
        System.out.println("user的dir:" + userDir);
    }

    @Test
    public void TestM2(){
        BigInteger bi = new BigInteger("1243328848374785783785837538475873458734874587346541123");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
        //System.out.println(bd.divide(bd2));//没有设置精确的的位数，会报错
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));//默认保留的小数位数
        System.out.println(bd.divide(bd2, 15, BigDecimal.ROUND_HALF_UP));//设置的保留小数位数
    }
}
