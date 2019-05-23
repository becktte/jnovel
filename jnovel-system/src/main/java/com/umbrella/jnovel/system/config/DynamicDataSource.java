package com.umbrella.jnovel.system.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @Description 动态数据源
 * @Author becktte
 * @Date 2019/5/23
 * @Version 1.0
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {

    public DynamicDataSource(DataSource defaultDataSource, Map<Object, Object> targetMap) {
        super.setTargetDataSources(targetMap);
        super.setDefaultTargetDataSource(defaultDataSource);
        super.afterPropertiesSet();
    }


    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContext.getDataSourceType();
    }
}
