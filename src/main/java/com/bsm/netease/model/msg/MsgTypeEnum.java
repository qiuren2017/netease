package com.bsm.netease.model.msg;

import java.io.Serializable;

/**
 * 客户端类型
 */
public enum MsgTypeEnum implements Serializable {
    TEXT("文本", 0),
    PICTURE("图片", 1),
    VOICE("语音", 2),
    VIDEO("视频", 3),
    ADDRESS("地理位置", 4),
    FILE("文件", 6),
    TIPS("Tips", 10),
    CUSTOM("自定义", 100);

    private String name;
    private Integer value;

    MsgTypeEnum(String name, Integer value) {
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
