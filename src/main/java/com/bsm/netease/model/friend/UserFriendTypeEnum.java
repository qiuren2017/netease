package com.bsm.netease.model.friend;

import com.common.util.IGlossary;

/**
 * 好友关系类型
 */
public enum UserFriendTypeEnum implements IGlossary {
    direct("直接加好友", 1),
    request("请求加好友", 2),
    agree("同意加好友", 3),
    refuse("拒绝加好友",4);

    private String name;
    private Integer value;

    UserFriendTypeEnum(String name, Integer value) {
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
