package com.umbrella.jnovel.system.annotation;


import com.umbrella.jnovel.system.constant.LimitType;

import java.lang.annotation.*;

/**
 * @author yeyongjian
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Limit {

    String name() default "";

    String key() default "";

    String prefix() default "";

    int period();

    int count();

    LimitType limitType() default LimitType.CUSTOMER;
}
