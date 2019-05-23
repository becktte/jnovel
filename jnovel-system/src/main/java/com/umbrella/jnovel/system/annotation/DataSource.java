package com.umbrella.jnovel.system.annotation;

import com.umbrella.jnovel.system.enums.DataSourceType;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DataSource {
    public DataSourceType value() default DataSourceType.MASTER;
}
