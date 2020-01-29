package com.pss.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/PssGet")
@Api(description = "这是我定义的方法")
public class MyGetMethod {

    @ApiOperation(value="获取cookies信息", httpMethod = "GET")
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    public String getCookies(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return  "恭喜拉，获取cookies信息成功";
    }

    @ApiOperation(value="携带cookies信息请求接口", httpMethod = "GET")
    @RequestMapping(value = "/getWithCookies",method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies)){
            return  "需要携带cookies信息";
        }
        for (Cookie item :cookies) {
            if(item.getName().equals("login") && item.getValue().equals("true")){
                return  "成功！--------";
            }
        }
        return  "需要携带cookies信息";
    }

    /**
     * 第一种get带参数的请求方式
     * @param start
     * @param end
     * @return
     */
    @ApiOperation(value="第一种get带参数的请求方式", httpMethod = "GET")
    @RequestMapping(value="/getList/param")
    public Map<Object,Object> getList(@RequestParam Integer start,@RequestParam Integer end){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("name","美成");
        objectObjectHashMap.put("age",18);
        return objectObjectHashMap;
    }

    /**
     * 第二种get带参数的请求方式
     * @param start
     * @param end
     * @return
     */
    @ApiOperation(value="第二种get带参数的请求方式", httpMethod = "GET")
    @RequestMapping(value="/getListTwo/param/{start}/{end}")
    public Map<Object,Object> getListTwo(@PathVariable Integer start, @PathVariable Integer end){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("name","美成");
        objectObjectHashMap.put("age",18);
        return objectObjectHashMap;
    }
}
