package com.example.config;

import org.springframework.beans.factory.InitializingBean;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lenovo on 2018/6/26.
 */
public class MultipleDataSource implements InitializingBean {

    private Set<String> dataSources;
    private String defaultDataSource;
    private Set<String> startupNeededDataSources;

    public String getDefaultDataSource() {
        return defaultDataSource;
    }

    public void setDefaultDataSource(String defaultDataSource) {
        this.defaultDataSource = defaultDataSource;
    }

    public MultipleDataSource(List<String> dataSources) {
        this.dataSources = new HashSet(dataSources);
        this.defaultDataSource = (String)dataSources.get(0);
    }

    public Set<String> getDataSources() {
        return dataSources;
    }

    public void setDataSources(Set<String> dataSources) {
        this.dataSources = dataSources;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
