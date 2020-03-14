package com.netease.model.team;

import com.common.util.IGlossary;

/**
 * 被邀请人同意方式
 */
public enum BeinvitemodeEnum implements IGlossary {
    AGREE("需要同意(默认)", 0),
    DIS_AGREE("不需要同意", 1);

    private String name;
    private Integer value;

    BeinvitemodeEnum(String name, Integer value) {
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
