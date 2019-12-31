package com.bsm.netease.model.chatroom;

import com.common.util.IGlossary;

/**
 * 队列管理权限类型
 */
public enum QueuelevelTypeEnum implements IGlossary {
    ALL("所有人都有权限变更队列", 0),
    ADMIN("有主播管理员才能操作变更", 1);

    private String name;
    private Integer value;

    QueuelevelTypeEnum(String name, Integer value) {
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
