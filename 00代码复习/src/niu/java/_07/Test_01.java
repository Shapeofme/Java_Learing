package niu.java._07;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/3 21:37
 */
/*异常处理 -- 抓抛模型
* 1.“抓”：try-catch-finally , throws
* 2."抛"：系统自动产生，用户自定义
*
* 3.try-catch-finally
* --> finally可选，总会执行
* --> catch可选，先子类异常后父类异常
* 4.throws
* --> 方法声明中
* --> 只是将异常延迟了，try...是将异常处理了
* */
public class Test_01 {
    public static void main(String[] args) throws Exception {

        int a = testTry();
        System.out.println(a);

//        ptrName();

        Test test = new Test();
        test.ptr();
    }
    public static int testTry(){
        try{
            int a = 9/0;//这里报错，开始跳转
            return 10;//这里根本就没执行到
        } catch(ArithmeticException e){
            e.printStackTrace();
            System.out.println("测试");
            return 100;//在这里返回，但会在结束该方法前，先跳转到finally执行
        }catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("我在测试。。。");
        }
        System.out.println("OOO");
        return 1000;
    }

    public static void ptrName() throws NullPointerException{
        String str = null;
        System.out.println(str.toString());
    }
}
class Test{
    public void ptr() throws Exception{
        System.out.println("测试中。。。");
        throw new Exception();
    }
}
