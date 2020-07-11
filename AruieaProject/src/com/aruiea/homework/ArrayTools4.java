package com.aruiea.homework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * instruction of project
 *
 * @author Aruiea.com
 * @ClassName ArrayTools4
 * @Version 1.0
 * @Date 2020/7/9 19:12
 */
public class ArrayTools4 {

    @Test
    public void test(){
        new ArrayTools4().pringArray(new int[5]);
    }

    public void pringArray(int[] number){
        for (int i : number) {
            System.out.println(i);
        }
    }

    @Before
    public void check(){
        System.out.println("之前执行！");
    }

    @After
    public void log(){
        System.out.println("之后执行！");
    }

}
