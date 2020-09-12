package niu.java.注解;

import java.lang.annotation.*;

/**
 * Description:
 *
 * @author:
 * @version: date: 2020/9/9 9:19
 */
@Inherited
@Repeatable(MyAnnotations.class)
@Target({ElementType.TYPE,ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)//能加载到内存中
public @interface MyAnnotation {
//    String value();
    String value() default "hello";//设置默认值
}
