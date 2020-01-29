package com.course.testng.分组测试;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class demoClass1 {
    public void test1(){
        System.out.println("demoClass1方法1");
    }
    public void test2(){
        System.out.println("demoClass1方法2");
    }
}
