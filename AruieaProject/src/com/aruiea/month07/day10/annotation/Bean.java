package com.aruiea.month07.day10.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//定义一个注解，可以通过Bean.name(）获得方法的返回值属性！
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Bean {

    String name() default "";

}
