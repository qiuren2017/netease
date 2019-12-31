package com.bsm.netease.model.chatroom;

import java.io.Serializable;

/**
 * 客户端类型
 */
public enum ClientTypeEnum implements Serializable {
    weblink("客户端为web端时使用", 1),
    commonlink("客户端为非web端时使用", 2),
    wechatlink("微信小程序使用",3);

    private String name;
    private Integer value;

    ClientTypeEnum(String name, Integer value) {
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
