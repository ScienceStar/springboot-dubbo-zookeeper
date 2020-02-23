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
    @Reference(version = "1.0.1")
    private UserService userService;

    @Resource
    @Reference(version = "1.0.1")
    private IPersonService personService;

    @GetMapping("getUser")
    public User getUser(){
        User user = userService.findUser();
        System.out.println("进入客户端控制器.............");
        System.out.println(user.getUserId()+"\n"+
                           user.getName()+"\n"+
                           user.getAge()+"\n"+
                           user.getSex());
        return userService.findUser();
    }

    @GetMapping("getPerson")
    public User getPerson(){
        User user = personService.findUser();
        System.out.println("进入客户端控制器.............");
        System.out.println(user.getUserId()+"\n"+
                user.getName()+"\n"+
                user.getAge()+"\n"+
                user.getSex());
        return personService.findUser();
    }

    @GetMapping("getUserById")
    public User getUserById(){
        System.out.println("进来了！！！！！！！！！！！！！！！！");
        System.out.println(userService.hashCode()+"!!!!!!!!!!!!!!!!");
        int id = 1;
        return userService.getUserById(id);
    }

    @GetMapping("saveUser")
    public void saveUser(){
        System.out.println("进来了！！！！！！！！！！！！！！！！");
        System.out.println(userService.hashCode()+"!!!!!!!!!!!!!!!!");
        User user = new User();
        user.setName("赵洋");
        user.setAge(12);
        user.setSex("女");
        int i = userService.saveUser(user);
        System.out.println("是否保存成功？-------------"+i);
    }

    @GetMapping("updateUser")
    public void updateUser(){
        System.out.println("进来了！！！！！！！！！！！！！！！！");
        System.out.println(userService.hashCode()+"!!!!!!!!!!!!!!!!");
        User user = new User();
        user.setUserId(1);
        user.setName("赵洋");
        user.setAge(13);
        user.setSex("男");
        int i = userService.updateUser(user);
        System.out.println("是否保存成功？-------------"+i);
    }

    @GetMapping("deleteUser")
    public void deleteUser(){
        System.out.println("进来了！！！！！！！！！！！！！！！！");
        System.out.println(userService.hashCode()+"!!!!!!!!!!!!!!!!");
        int id = 3;
        int i = userService.deleteUser(id);
        System.out.println("是否保存成功？-------------"+i);
    }
}
