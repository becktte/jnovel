package com.umbrella.jnovel.system.config;

/**
 * @Description 动态切换数据源上下文
 * @Author becktte
 * @Date 2019/5/23
 * @Version 1.0
 **/
public class DynamicDataSourceContext {

    private static ThreadLocal<String> DATASOURCE_CONTEXT = new ThreadLocal<>();

    public static void setDataSourceType(String datasourceContext) {
        DATASOURCE_CONTEXT.set(datasourceContext);
    }

    public static String getDataSourceType() {
        return DATASOURCE_CONTEXT.get();
    }

    public static void clear() {
        DATASOURCE_CONTEXT.remove();
    }
}
