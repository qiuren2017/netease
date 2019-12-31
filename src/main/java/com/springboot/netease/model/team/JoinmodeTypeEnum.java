package com.springboot.netease.model.team;

import com.common.util.IGlossary;

/**
 * 加入群验证类型
 */
public enum  JoinmodeTypeEnum implements IGlossary{
    VERIFY("不用验证", 0),
    NO_VERIFY("需要验证", 1),
    FORBID("不允许任何人加入", 2);

    private String name;
    private Integer value;

    JoinmodeTypeEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
