package com.umbrella.jnovel.web.aspect;

import com.umbrella.jnovel.system.annotation.DataSource;
import com.umbrella.jnovel.system.config.DynamicDataSourceContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description 处理动态数据源
 * @Author becktte
 * @Date 2019/5/23
 * @Version 1.0
 **/
@Aspect
@Component
public class DataSourceAspect {

    @Pointcut("@annotation(com.umbrella.jnovel.system.annotation.DataSource)")
    public void doPointcut(){}

    @Around("doPointcut()")
    public Object inceptor(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        DataSource dataSource = method.getAnnotation(DataSource.class);
        if (dataSource != null) {
            DynamicDataSourceContext.setDataSourceType(dataSource.value().name());
        }
        try {
            return joinPoint.proceed();
        } finally {
            DynamicDataSourceContext.clear();
        }
    }
}
