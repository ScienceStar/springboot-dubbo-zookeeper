package com.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.common.domin.User;
import com.common.service.IPersonService;
import com.common.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author lxc
 * @Date 2020/2/21
 * @Version V1.0
 **/
@RestController
public class UserController {

    @Resource
    @Reference(version="1.0.0")
    private UserService userService;

    @Resource
    @Reference(version="1.0.0")
    private IPersonService personService;

    @GetMapping("getUser")
    public User getUser(){
        User user = userService.findUser();
        System.out.println("进入客户端控制器.............");
        System.out.println(user.getId()+"\n"+
                           user.getName()+"\n"+
                           user.getAge()+"\n"+
                           user.getSex());
        return userService.findUser();
    }

    @GetMapping("getPerson")
    public User getPerson(){
        User user = personService.findUser();
        System.out.println("进入客户端控制器.............");
        System.out.println(user.getId()+"\n"+
                user.getName()+"\n"+
                user.getAge()+"\n"+
                user.getSex());
        return personService.findUser();
    }
}
