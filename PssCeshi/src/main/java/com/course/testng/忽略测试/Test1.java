package com.course.testng.忽略测试;
import org.testng.annotations.Test;
//忽略测试
public class Test1 {
    @Test
    private void testMouth1(){
        System.out.println("测试1");
    }

    //默认为true
    @Test(enabled = true)
    private void testMouth2(){
        System.out.println("测试2");
    }

    @Test(enabled = false)
    private void testMouth3(){
        System.out.println("测试3");
    }

}
