package com.umbrella.jnovel.system.user.mapper;

import com.umbrella.jnovel.system.user.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findUser();
}
