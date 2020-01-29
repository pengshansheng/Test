package com.pss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * todo 注意！！！！
 * 注解这里原来为@EnableAutoConfiguration，运行报错，
 * 原因是springboot自动配置了支持mongodb。在启动springboot时会自动实例化一个mongo实例，需要禁用自动配置
 * 所有替换为@SpringBootApplication(exclude = MongoAutoConfiguration.class)
 */


//@EnableAutoConfiguration
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@Controller
public class SampleController {
    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "hello!!";
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(SampleController.class,args);
    }
}
