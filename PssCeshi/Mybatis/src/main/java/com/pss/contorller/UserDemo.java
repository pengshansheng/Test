package com.pss.contorller;


import com.pss.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j
@RestController
@Api(value="user",description = "用户demo")
@RequestMapping("user")
public class UserDemo {

    //首先获取一个执行sql的对象
    @Autowired
    private SqlSessionTemplate template;

    @ApiOperation(value="获取用户数")
    @GetMapping(value="/getUserCount")
    public int getUserCount(){
        return template.selectOne("getUserCount");
    }

    @ApiOperation(value="新增用户")
    @PostMapping(value="/addUser")
    public int addUser(@RequestBody User user){
        int a=template.insert("addUser",user);
        return a;
    }

    @ApiOperation(value="修改用户")
    @PutMapping(value="/updateUser")
    public int updateUser(@RequestBody User user){
        int a=template.update("updateUser",user);
        return a;
    }

    @ApiOperation(value="删除用户")
    @DeleteMapping(value="/deleteUser")
    public int deleteUser(@RequestParam Integer id){
        int a=template.delete("deleteUser",id);
        return a;
    }






}
