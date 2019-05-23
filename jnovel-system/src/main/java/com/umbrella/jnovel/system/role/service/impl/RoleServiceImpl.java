package com.umbrella.jnovel.system.role.service.impl;

import com.umbrella.jnovel.system.annotation.DataSource;
import com.umbrella.jnovel.system.enums.DataSourceType;
import com.umbrella.jnovel.system.role.mapper.RoleMapper;
import com.umbrella.jnovel.system.role.model.Role;
import com.umbrella.jnovel.system.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author becktte
 * @Date 2019/5/23
 * @Version 1.0
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    @DataSource(DataSourceType.SLAVER)
    public List<Role> queryRoleList() {
        return roleMapper.queryRoleList();
    }
}
