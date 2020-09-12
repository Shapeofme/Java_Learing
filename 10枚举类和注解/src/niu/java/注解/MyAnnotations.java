package niu.java.注解;

import java.lang.annotation.*;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/9 10:10
 */
@Inherited
@Target({ElementType.TYPE,ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})//--只能用于类、接口
@Retention(RetentionPolicy.RUNTIME)//能加载到内存中
public @interface MyAnnotations {
    MyAnnotation[] value();
}
