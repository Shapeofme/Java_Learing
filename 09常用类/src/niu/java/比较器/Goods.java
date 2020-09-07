package niu.java.比较器;

import java.util.Comparator;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/7 22:22
 */
public class Goods implements Comparable {
    private String name ;
    private Double price;

    public String getName(){
        return this.name;
    }
    public Double getPrice(){
        return this.price;
    }

    public Goods(String name,Double price) {
        this.name = name;
        this.price = price;
    }

    //先按价格从低到高排序，再按照产品名称从低到高排序
    @Override
    public int compareTo(Object o) {
        System.out.println("******");
        if( o instanceof Goods){
            Goods goods = (Goods)o;
            //方式一
            if(this.price > goods.price){
                return 1;
            }else if(this.price < goods.price){
                return -1;
            }else{
                //return 0;
                return this.name.compareTo(goods.name);
            }

            //方式二：
            //return Double.compare(this.price, goods.price);
        }
        throw new RuntimeException("传入数据类型不一致!");
    }

    @Override
    public String toString() {
        return this.name+"-"+this.price;
    }
}
class Te implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof Goods && o2 instanceof Goods){
            Goods g1 = (Goods)o1;
            Goods g2 = (Goods)o2;
            if(g1.getName().equals(g2.getName())){
                return -g1.getPrice().compareTo(g2.getPrice());
            }else{
                return -g1.getName().compareTo(g2.getName());
            }
        }
        throw new RuntimeException("传入的类型不一致！");
    }
}
