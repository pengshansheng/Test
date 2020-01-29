package com.course.testng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("-----------------");
        System.out.println("-----------------before suit 运行了==");
    }
    @AfterSuite
    public void afterSuit(){
        System.out.println("=================after suit 运行了==");
    }

    @BeforeTest
    public void test(){
        System.out.println("BeforeTest");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("afterTest");
    }
}
