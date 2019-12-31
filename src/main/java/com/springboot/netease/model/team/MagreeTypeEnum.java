package com.springboot.netease.model.team;

import com.common.util.IGlossary;

public enum MagreeTypeEnum implements IGlossary{
    INVITE("不需要被邀请人同意加入群", 0),
    INIVITE("需要被邀请人同意才可以加入群", 1);

    private String name;
    private Integer value;

    MagreeTypeEnum(String name, Integer value) {
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
