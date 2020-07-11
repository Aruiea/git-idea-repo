package com.aruiea.month07.day10.annotation;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * instruction of project
 *
 * @author Aruiea.com
 * @ClassName AnnotationTest
 * @Version 1.0
 * @Date 2020/7/10 16:03
 */

public class AnnotationTest {

    static Map<String,Object> cache = new HashMap<>();

    @Before
    //从配置文件里引入所有类的配置
    public void init(){
        Properties properties = new Properties();
        try {
            properties.load(AnnotationTest.class.getResourceAsStream("/conf/bean.properties"));
            Set<String> stringKeys = properties.stringPropertyNames();//获得properties里面的所有字符串键
            //把properties里面的文件遍历出来，获得类的路径
            for (String stringKey : stringKeys) {
                String classPath = properties.getProperty(stringKey);//获得类路径的String路径
                System.out.println(classPath);
                Class clasz = Class.forName(classPath);//把文件里的路径实例化为类class对象。
                cache.put(stringKey,clasz.newInstance());//类名默认为Map中的key，后面对应实例化的对象。这样可以通过类名key来得到唯一的实例化对象。
            }

            //把类上的注解拿出来，然后给对象赋值
            for (String stringKey : stringKeys) {
                //先遍历对象，取出所有属性，判断哪些上面有注解。
                Object instance = cache.get(stringKey);
                Class clasz = instance.getClass();
                Field[] declaredFields = clasz.getDeclaredFields();
                for (Field declaredField : declaredFields) {
                    if (declaredField.isAnnotationPresent(Bean.class)){
                        Bean annotation = declaredField.getAnnotation(Bean.class);//注解对象
                        Object o = cache.get(annotation.name());
                        declaredField.setAccessible(true);
                        declaredField.set(instance,o);
                    }
                }
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void print(){
        //需要使用的时候就可以直接得到已经创建好的对象了
        System.out.println("------------------------------------------------------------");
        System.out.println(cache.get("day10"));
        System.out.println(cache);
    }

}
