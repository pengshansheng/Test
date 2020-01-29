package com.httpclient;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;
    //用来存储cookies信息的变量
    private CookieStore cookieStore;
    @BeforeTest
    public void beforeTest(){
        bundle=ResourceBundle.getBundle("application", Locale.CANADA);
        url=bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        String uri=bundle.getString("getCookies.uri");
        String testUrl=this.url+uri;
        HttpGet get=new HttpGet(testUrl);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        CloseableHttpResponse execute = defaultHttpClient.execute(get);
        result=EntityUtils.toString(execute.getEntity(),"utf-8");

        //获取cookies信息
        this.cookieStore = defaultHttpClient.getCookieStore();
        List<Cookie> cookies = cookieStore.getCookies();
        for (Cookie cookie:
                cookies ) {
            String name=cookie.getName();
            String value=cookie.getValue();
            System.out.println("name="+name+",value="+value);
        }
        System.out.println(result);
    }

    //dependsOnMethods依赖，上面的testGetCookies方法执行完才会执行该方法
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetIsCookies() throws IOException {
        String uri=bundle.getString("getIsCookies");
        String testUrl=this.url+uri;
        HttpGet get=new HttpGet(testUrl);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        //设置cookies信息
        defaultHttpClient.setCookieStore(this.cookieStore);
        CloseableHttpResponse execute = defaultHttpClient.execute(get);
        int statusCode = execute.getStatusLine().getStatusCode();
        System.out.println("响应状态码="+statusCode);
        if(statusCode==200){
            String result=EntityUtils.toString(execute.getEntity(),"utf-8");
            System.out.println(result);
        }

    }
}
