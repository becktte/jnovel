package com.umbrella.jnovel.web.controller;

import com.umbrella.jnovel.system.role.model.Role;
import com.umbrella.jnovel.system.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description TODO
 * @Author becktte
 * @Date 2019/5/23
 * @Version 1.0
 **/
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/queryRoleList")
    @ResponseBody
    public List<Role> queryRoleList() {
        return roleService.queryRoleList();
    }
}
