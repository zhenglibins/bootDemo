package com.example.constants;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2018/8/4.
 */
public enum RedisKey {

    MY_FIRST_TEST("MY_FIRST_TEST", "diyige", "MY_FIRST", 10L, TimeUnit.MINUTES);

    private String name;
    private String desc;
    private String father;
    private Long timeout;
    private TimeUnit timeUnit;

    RedisKey(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    RedisKey(String name, String desc, String father) {
        this.name = name;
        this.desc = desc;
        this.father = father;
    }

    RedisKey(String name, String desc, String father, Long timeout, TimeUnit timeUnit) {
        this.name = name;
        this.desc = desc;
        this.father = father;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getFather() {
        return father;
    }

    public Long getTimeout() {
        return timeout;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }


}
