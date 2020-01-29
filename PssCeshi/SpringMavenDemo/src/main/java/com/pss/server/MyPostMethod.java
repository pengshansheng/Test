package com.pss.server;

import com.pss.Entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.Cookie;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(description = "这是我的全部的post请求")
@RequestMapping("/pssPost")
public class MyPostMethod {

    private static Cookie cookie;

    @ApiOperation(value="登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String getCookies(HttpServletResponse response,
                             @RequestParam(value="userName",required=true) String userName,
                             @RequestParam(value="password",required=true) String password){
        if(userName.equals("admin") && password.equals("password")){
            cookie=new Cookie("login","true");
            response.addCookie(cookie);
            return "登录成功！！";
        }
        javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("login", "true");
        response.addCookie(cookie);
        return  "用户名或密码错误";
    }

    @ApiOperation(value="获取用户列表")
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    public String getUserList(HttpServletRequest request,
                            @RequestBody User user){
        Cookie[] cookies = request.getCookies();
        User user1;
        for (Cookie c:cookies
             ) {
            if(c.getName().equals("login") &&c.getValue().equals("true")
            && user.getUserName().equals("admin")&&
            user.getPassword().equals("password")){
                user1 = new User();
                user1.setAge(18);
                user1.setName("美成");
                return user1.toString();
            }
        }
        return "验证失败";
    }
}
