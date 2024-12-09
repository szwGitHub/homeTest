package com.zh.test.controller;

import com.zh.test.model.request.UserDTO;
import com.zh.test.model.response.ResultBase;
import com.zh.test.pojo.TestUser;
import com.zh.test.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api("用户")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    //@ApiOperation(value = "新增用户信息",notes = "szw")
    public ResultBase insertUser(@RequestBody UserDTO userDTO){
        userService.insertUser(userDTO);
        return  ResultBase.ok("插入数据成功");
    }

    @RequestMapping(value = "/findUserByName/{name}", method = RequestMethod.GET)
    //@ApiOperation(value = "通过姓名查询用户信息",notes = "szw")
    public ResultBase findUser(@PathVariable String name){
        Map<String, Object> userMap = userService.findUserByName(name);
        return  ResultBase.ok("查询成功！！",userMap);
    }

    @RequestMapping(value = "/findUserById/{id}", method = RequestMethod.GET)
    //@ApiOperation(value = "通过ID查询用户信息",notes = "szw")
    public ResultBase findUserById(@PathVariable String id){
        Map<String, Object> userMap = userService.findUserById(id);
        return  ResultBase.ok("查询成功！！",userMap);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    //@ApiOperation(value = "修改用户信息",notes = "szw")
    public ResultBase updateUser(@RequestBody UserDTO userDTO){
        userService.updateUser(userDTO);
        return  ResultBase.ok("数据更新成功");
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    //@ApiOperation(value = "测试方法",notes = "szw")
    public ResultBase testMethod(@PathVariable String id){
        return  ResultBase.ok("测试成功！！");
    }
}
