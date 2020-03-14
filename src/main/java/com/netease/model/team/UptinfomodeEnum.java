package com.netease.model.team;

import com.common.util.IGlossary;

/**
 * 谁可以修改群资料
 */
public enum UptinfomodeEnum implements IGlossary {
    ADMIN("管理员(默认)", 0),
    EVERYONE("所有人", 1);

    private String name;
    private Integer value;

    UptinfomodeEnum(String name, Integer value) {
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
