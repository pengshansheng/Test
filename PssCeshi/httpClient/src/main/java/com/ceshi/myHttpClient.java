package com.ceshi;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.zip.DeflaterOutputStream;

public class myHttpClient {

    @Test
    public void test1(){
        String result;
        HttpGet get=new HttpGet("http://www.baidu.com");
        HttpClient client=new DefaultHttpClient();
        try {
            HttpResponse res =client.execute(get);
            String entity = EntityUtils.toString(res.getEntity(),"utf-8");

            System.out.println("entity = " + entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
