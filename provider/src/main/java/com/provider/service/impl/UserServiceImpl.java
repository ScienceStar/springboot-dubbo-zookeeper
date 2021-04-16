package com.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.common.domin.User;
import com.provider.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.common.service.UserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName UserServiceImpl
 * @Description: TODO
 * @Author lxc
 * @Date 2020/2/21
 * @Version V1.0
 **/
@Service(version = "1.0.1")
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired UserMapper userMapper;
    @Autowired private RedisTemplate redisTemplate;

    @Override
    public User findUser() {
        return userMapper.getOne(1);
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    /**
     * 获取user逻辑：
     * 如果缓存存在，从缓存中获取user信息
     * 如果缓存不存在，从 DB 中获取user信息，然后插入缓存
     */
    @Override
    public User getUserById(int id) {
        //从缓存中获取城市信息
        String key = "user_"+id;
        ValueOperations<String,User> operations = redisTemplate.opsForValue();

        //缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        User u = operations.get(key);
        System.out.println("是否有缓存："+hasKey+"  缓存中的值是："+u);
        if(hasKey){
            User user = operations.get(key);
            LOGGER.info("UserImpl.updateUser() : 从缓存中获取了user >> " + user.toString());
            return user;
        }
        //从数据库中获取user数据
        User user = userMapper.getUserById(id);

        //插入缓存
        operations.set(key, user, 4, TimeUnit.HOURS);
        LOGGER.info("UserImpl.findUserById() :user插入缓存 >> " + user.toString());
        return user;
    }

    public int saveUser(User user){
        return userMapper.saveUser(user);
    }

    /**
     * 更新user逻辑：
     * 如果缓存存在，从缓存中删除user信息
     * 如果缓存不存在，不操作
     */
    public int updateUser(User user){
        int ret = userMapper.updateUser(user);

        //缓存存在，删除缓存
        String key = "user_" + user.getUserId();
        boolean haskey = redisTemplate.hasKey(key);
        if (haskey){
            redisTemplate.delete(key);
            LOGGER.info("UserImmpl.updateUser() : 从缓存中删除user >> " + user.toString());
        }
        return ret;
    }

    /**
     * 删除user逻辑：
     * 如果缓存存在，从缓存中删除user信息
     * 如果缓存不存在，不操作
     */
    public int deleteUser(int id){
        int ret = userMapper.deleteUser(id);

        //缓存存在，删除缓存
        String key = "user_" + id;
        System.out.println("key的值为： " +key);
        boolean haskey = redisTemplate.hasKey(key);
        ValueOperations<String,User> operations = redisTemplate.opsForValue();
        User u = operations.get(key);
        System.out.println("是否有缓存："+haskey+"  缓存中的值是："+u);
        if (haskey){
            LOGGER.info("UserImmpl.updateUser() : 从缓存中删除user >> " + operations.get(key));
            redisTemplate.delete(key);
        }
        return ret;
    }
}
