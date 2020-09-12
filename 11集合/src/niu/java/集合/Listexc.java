package niu.java.集合;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/10 11:20
 */
public class Listexc {
    @Test
    public void testListRemove() {
        //测试remove（int）和remove（Object）
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }
    private static void updateList(List list) {
        list.remove(2);//remove(int) 按索引删除
        list.remove(new Integer(2));//remove(Integer) 按元素删除
    }
}
