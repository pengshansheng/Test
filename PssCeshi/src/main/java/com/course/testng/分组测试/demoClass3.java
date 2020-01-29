package com.course.testng.分组测试;

import org.testng.annotations.Test;

@Test(groups = "demo2")
public class demoClass3 {
    public void test1(){
        System.out.println("demoClass3方法1");
    }
    public void test2(){
        System.out.println("demoClass3方法2");
    }
}
