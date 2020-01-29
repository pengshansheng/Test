package com.course.testng;

import org.testng.annotations.*;


public class BasicAction {
    @Test
    public void test1(){
        System.out.println("测试==========");
    };

    @Test
    public void add(){
        System.out.println("xxxxx==========");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("测试方法之前《-");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("测试方法之后-》");
    };

    @BeforeClass
    public void beforeClass(){
        System.out.println("类运行之前<--");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("类运行之后-->");
    }

    @BeforeSuite
    public void beforSuit(){
        System.out.println("测试套件。在类运行之前运行-->");
    }

    @AfterSuite
    public void afterSuit(){
        System.out.println("测试套件。在类运行之后运行-->");
    }
}
