package com.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.provider.mapper.UserMapper;
import com.common.domin.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.common.service.UserService;

/**
 * @ClassName UserServiceImpl
 * @Description: TODO
 * @Author lxc
 * @Date 2020/2/21
 * @Version V1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired UserMapper userMapper;

    @Override
    public User findUser() {
        return userMapper.getOne( 1);
    }
}
