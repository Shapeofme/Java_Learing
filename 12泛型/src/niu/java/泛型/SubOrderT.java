package niu.java.泛型;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/13 15:19
 */
public class SubOrderT extends OrderT<String>{//不是泛型类
    public SubOrderT(String name, int age, String orderT) {
        super(name, age, orderT);
    }

    @Override
    public void setOrderT(String orderT) {
        System.out.println("我是子类中的Set方法");
        super.setOrderT(orderT);
    }
}
