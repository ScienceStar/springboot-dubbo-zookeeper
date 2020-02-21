package com.provider.mapper;

import com.common.domin.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @InterfaceName UserMapper
 * @Description: TODO
 * @Author lxc
 * @Date 2020/2/21
 * @Version V1.0
 **/
@Mapper
public interface UserMapper {

    @Results(id = "userMap", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "age", property = "age"),
            @Result(column = "sex", property = "sex")})
    @Select("SELECT * FROM user")
    List<User> getAll();

    @Select("SELECT * FROM user t WHERE t.id = #{id}")
    @ResultMap("userMap")
    User getOne(Long id);
}
