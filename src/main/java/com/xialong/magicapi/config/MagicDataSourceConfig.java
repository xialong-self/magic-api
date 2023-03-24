package com.xialong.magicapi.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.ssssssss.magicapi.datasource.model.DataSourceInfo;
import org.ssssssss.magicapi.datasource.model.MagicDynamicDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

/**
 * @author 夏龙
 * @description 加载magic-api多数据源
 * @create 2023/3/22 15:05
 */
@Configuration
public class MagicDataSourceConfig {


    @Bean
    //将配置文件注入Bean
    @ConfigurationProperties(prefix = "data")
    //条件注入，之注入满足条件的配置文件
    @Conditional(MultiDatasourceConfigCondition.class)
    public MultiDatasourceConfig multiDatasourceConfig() {
        return new MultiDatasourceConfig();
    }

    @Bean
    @ConditionalOnBean(MultiDatasourceConfig.class)
    public MagicDynamicDataSource magicDynamicDataSource(MultiDatasourceConfig multiDatasourceConfig, DataSource dataSource) {
        MagicDynamicDataSource dynamicDataSource = new MagicDynamicDataSource();
        dynamicDataSource.setDefault(dataSource); // 设置默认数据源
        multiDatasourceConfig.getDatasource().forEach((k, v) ->
                dynamicDataSource.add(k, createDataSource(v, HikariDataSource.class)));
        return dynamicDataSource;
    }

    //将配置文件中的配置信息写入magic-api配置中
    private DataSource createDataSource(DataSourceInfo config, Class<HikariDataSource> datasourceType) {
        DataSourceBuilder<HikariDataSource> dataSourceBuilder = DataSourceBuilder.create().type(datasourceType);
        return dataSourceBuilder.url(config.getUrl()).driverClassName(config.getDriverClassName())
                .username(config.getUsername()).password(config.getPassword()).build();
    }
}
