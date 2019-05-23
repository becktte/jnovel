package com.umbrella.jnovel.system.model;

import java.util.Date;

/**
 * @Description TODO
 * @Author becktte
 * @Date 2019/5/23
 * @Version 1.0
 **/
public class BaseEntity {
    protected Long id;

    protected Date ctime;

    protected Date rtime;

    protected String isvalid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getRtime() {
        return rtime;
    }

    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }

    public String getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(String isvalid) {
        this.isvalid = isvalid;
    }
}
