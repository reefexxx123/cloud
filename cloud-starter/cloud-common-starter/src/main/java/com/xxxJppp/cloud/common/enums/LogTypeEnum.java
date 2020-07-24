package com.xxxJppp.cloud.common.enums;

/**
 * 日志类型
 *
 * @author xxxJppp
 * @date 2020/4/30 10:25
 */
public enum LogTypeEnum {
    /**
     * 数据库
     */
    DB("db", "数据库"),
    /**
     * redis
     */
    REDIS("redis", "redis"),
    /**
     * kafka
     */
    KAFKA("kafka", "kafka");

    private String name;
    private String description;

    LogTypeEnum(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
