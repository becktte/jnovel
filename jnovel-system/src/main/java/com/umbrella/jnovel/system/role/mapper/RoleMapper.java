package com.umbrella.jnovel.system.role.mapper;

import com.umbrella.jnovel.system.role.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    List<Role> queryRoleList();
}
