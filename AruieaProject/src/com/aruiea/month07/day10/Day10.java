package com.aruiea.month07.day10;

import com.aruiea.month07.day10.annotation.Bean;

/**
 * instruction of project
 *
 * @author Aruiea.com
 * @ClassName Day10
 * @Version 1.0
 * @Date 2020/7/10 9:14
 * Annotation
 */
public class Day10 {
    private String name;
    @Bean
    private int age;
    private String habbit;

    public static void main(String[] args) {
    }

    public void print(){
        System.out.println("我是Day10里面的方法！");
    }

    @Override
    public String toString() {
        return "Day10{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}