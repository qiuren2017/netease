package com.springboot.netease.model;

import com.common.util.IGlossary;

/**
 * 群操作权限类型
 */
public enum AuthTypeEnum implements IGlossary {
    ADMIN("管理员", 1),
    ALL("所有人", 2);

    private String name;
    private Integer value;

    AuthTypeEnum(String name, Integer value) {
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
