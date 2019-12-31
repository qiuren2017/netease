package com.netease.model.chatroom;

import java.io.Serializable;

/**
 * 成员角色类型
 */
public enum MembersTypeEnum implements Serializable {
    UNSET("未设置", 1),
    LIMITED("受限用户，黑名单或禁言", 2),
    COMMON("普通固定成员", 3),
    CREATOR("创建者", 4),
    MANAGER("管理员", 5),
    TEMPORARY("临时用户,非固定成员", 6);

    private String name;
    private Integer value;

    MembersTypeEnum(String name, Integer value) {
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
