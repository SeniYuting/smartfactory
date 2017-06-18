package com.adc.utils;

import java.util.Map;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.jdbc.datasource.lookup.DataSourceLookup;
/**
 * 数据源配置工具类
 * @author Victor_Zhou
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {  
	  
    /*  
     * 该方法必须要重写  方法是为了根据数据库标示符取得当前的数据库 
     */  
    @Override  
    public Object determineCurrentLookupKey() {  
        return DataSourceContextHolder.getDataSource();  
    }  
  
    @Override  
    public void setDataSourceLookup(DataSourceLookup dataSourceLookup) {  
        super.setDataSourceLookup(dataSourceLookup);  
    }  
  
    @Override  
    public void setDefaultTargetDataSource(Object defaultTargetDataSource) {  
        super.setDefaultTargetDataSource(defaultTargetDataSource);  
    }  
  
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override  
    public void setTargetDataSources(Map targetDataSources) {  
        super.setTargetDataSources(targetDataSources);  
        //重点  
        super.afterPropertiesSet();  
    }  
  
}  
