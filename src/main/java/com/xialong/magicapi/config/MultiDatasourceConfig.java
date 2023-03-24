package com.xialong.magicapi.config;

import org.ssssssss.magicapi.datasource.model.DataSourceInfo;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 夏龙
 * @description 自定义配置文件类
 * @create 2023/3/22 15:12
 */
public class MultiDatasourceConfig {
    private Map<String, DataSourceInfo> datasource=new HashMap<>();

    public Map<String, DataSourceInfo> getDatasource(){
        return datasource;
    }

    public void setDatasource(Map<String,DataSourceInfo> datasource){
        this.datasource=datasource;
    }
}
