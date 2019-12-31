package com.springboot.netease.model.chatroom;

import java.io.Serializable;

/**
 * 操作类型
 */
public enum  OptTypeEnum implements Serializable {
    ADMIN("设置为管理员，operator必须是创建者", 1),
    COMMON("设置普通等级用户，operator必须是创建者或管理员", 2),
    BLACK("设为黑名单用户，operator必须是创建者或管理员", -1),
    MUTE("设为禁言用户，operator必须是创建者或管理员", -2);

    private String name;
    private Integer value;

    OptTypeEnum(String name, Integer value) {
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
