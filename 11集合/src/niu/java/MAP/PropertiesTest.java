package niu.java.MAP;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/11 20:04
 */
public class PropertiesTest {
    @Test
    public void test(){
        FileInputStream fis = null;
        try {
            //Properties:常用来处理配置文件。key和value都是String类型
            Properties prp = new Properties();

            fis = new FileInputStream("jdbc.properties");
            prp.load(fis);//加载流文件

            String name = prp.getProperty("name");
            String paw = prp.getProperty("password");

            System.out.println("name:"+name+", password:"+paw);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis != null){
                try{
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
