package niu.java.MAP;

import niu.java.SET.Users;
import niu.java.集合.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.Map;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/11 19:51
 */
//向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
//因为要照key进行排序：自然排序 、定制排序
public class TreeMap {
    @Test
    public void test(){
        //1.自然排序
        Map map = new java.util.TreeMap();
        map.put(new Users(13,"niu"), 19981004);
        map.put(new Users(13,"iu"), 19981004);
        map.put(new Users(13,"shao"), 19891104);
        map.put(new Users(13,"hao"), 19991004);

        System.out.println(map);

        //2.定制排序
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Users users = (Users)o1;
                Users users1 = (Users)o2;
                return users.compareTo(users1);
            }
        };
        Map map1 = new java.util.TreeMap();
        map1.put(new Users(13,"A"), 19981004);
        map1.put(new Users(13,"E"), 19981004);
        map1.put(new Users(13,"D"), 19891104);
        map1.put(new Users(13,"D"), 19991004);
        System.out.println(map1);
    }
}
