package com.xxxJppp.cloud.common.enums;

/**
 * 数据权限枚举
 * @author xxxJppp
 * @version 1.0
 * @date 2020/7/17
 */
public enum DataScopeTypeEnum {

    /**
     * 全部
     */
    ALL(1, "全部"),
    /**
     * 自定义
     */
    CUSTOMIZE(2, "自定义"),
    /**
     * 本级
     */
    THIS_LEVEL(3, "本级"),

    /**
     * 本级以及子级
     */
    THIS_LEVEL_CHILDREN(4, "本级以及子级");



    private int type;
    private String description;


    public static DataScopeTypeEnum valueOf(int type) {
        for (DataScopeTypeEnum typeVar : DataScopeTypeEnum.values()) {
            if (typeVar.getType() == type) {
                return typeVar;
            }
        }
        return ALL;
    }

    DataScopeTypeEnum(int type, String description) {
        this.type = type;
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
