package com.umbrella.jnovel.system.role.model;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.umbrella.jnovel.system.model.BaseEntity;

/**
 * @Description TODO
 * @Author becktte
 * @Date 2019/5/23
 * @Version 1.0
 **/
public class Role extends BaseEntity {

    private String name;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
