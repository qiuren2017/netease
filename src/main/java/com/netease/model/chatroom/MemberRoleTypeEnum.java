package com.netease.model.chatroom;

import java.io.Serializable;

/**
 * 设置聊天室内用户角色返回数据type
 */
public enum MemberRoleTypeEnum implements Serializable {
    LIMITED("受限用户,黑名单+禁言", 1),
    COMMON("普通固定成员", 2),
    CREATOR("创建者", 3),
    MANAGER("管理员", 4),
    TEMPORARY("临时用户,非固定成员", 5);

    private String name;
    private Integer value;

    MemberRoleTypeEnum(String name, Integer value) {
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
