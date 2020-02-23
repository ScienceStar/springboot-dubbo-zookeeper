package com.common.service;

import com.common.domin.User;

/**
 * @InterfaceName UserService
 * @Description: TODO
 * @Author lxc
 * @Date 2020/2/21
 * @Version V1.0
 **/
public interface UserService {

    public User findUser();

    User getUserById(int id);
    int saveUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
}
