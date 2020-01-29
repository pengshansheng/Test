package com.httpclient;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
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

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostMethod() throws IOException {
        String uri = bundle.getString("postCookies");
        //拼接最终的测试地址
        String testUrl=this.url+uri;
        //申明一个Client对象，用来执行方法
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        //申明一个方法，这个方法时post方法
        HttpPost httpPost = new HttpPost(testUrl);
        //添加参数
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","aaa");
        jsonObject.put("age","18");
        //设置请求头信息 header 信息
        httpPost.setHeader("content-type","application/json");
        //将参数信息添加到方法中
        StringEntity stringEntity = new StringEntity(jsonObject.toString(),"utf-8");
        httpPost.setEntity(stringEntity);
        //申明一个对象来进行响应结果的存储
        String result;
        //设置cookies信息
        defaultHttpClient.setCookieStore(this.cookieStore);
        //执行post方法
        CloseableHttpResponse execute = defaultHttpClient.execute(httpPost);
        //获取响应结果
        result=EntityUtils.toString(execute.getEntity(),"utf-8");
        System.out.println(result);
        //返回数据转换成json对象
        JSONObject jsonObject1 = new JSONObject(result);
        String data = (String)jsonObject1.get("date");
        Assert.assertEquals("接收到了！！！",data);
        String status = (String)jsonObject1.get("status");
        Assert.assertEquals("2",status);
    }
}
