package com.aruiea.homework;

import org.junit.Test;

/**
 * instruction of project
 *
 * @author Aruiea.com
 * @ClassName Training3
 * @Version 1.0
 * @Date 2020/7/9 19:06
 */
public class ArrayTools3 {

    int getMax(int[] number){
        int max = number[0];
        for (int i : number) {
           if (max < i){
               max = i;
           }
        }
        return max;
    }

    @Test
    public void test(){
        ArrayTools3 at = new ArrayTools3();
        int[] number = {1,2,3,4,5,6,7};
        System.out.println(at.getMax(number));
    }

}
