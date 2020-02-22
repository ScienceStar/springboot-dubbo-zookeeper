package com.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.common.domin.User;
import com.common.service.IPersonService;
import com.provider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName PersonServiceImpl
 * @Description: TODO
 * @Author lxc
 * @Date 2020/2/22
 * @Version V1.0
 **/
@Service(version = "1.0.0")
public class PersonServiceImpl implements IPersonService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findUser() {
        return userMapper.getOne((long) 1);
    }
}
