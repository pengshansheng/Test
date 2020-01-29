package com.course.testng.分组测试;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups = "server")
    public void serverTest1() {
        System.out.println("这是服务端组测试方法1");
    }

    @Test(groups = "server")
    public void serverTest2() {
        System.out.println("这是服务端组测试方法2");
    }

    @AfterGroups("server")
    public void serverTestAfter() {
        System.out.println("After运行前");
    }
    @BeforeGroups("server")
    public void serverTestBefore() {
        System.out.println("Before运行后");
    }


    @Test(groups = "client")
    public void clientTest1() {
        System.out.println("这是客户端组测试方法1111");
    }

    @Test(groups = "client")
    public void clientTest2() {
        System.out.println("这是客户端组测试方法2222");
    }

    @Test(groups = "thirdParty")
    public void thirdPartyTest1() {
        System.out.println("这是第三方组测试方法1111");
    }

    @Test(groups = "thirdParty")
    public void thirdPartyTest2() {
        System.out.println("这是第三方组测试方法2222");
    }
}
