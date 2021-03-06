package com.netease.model.team;

import com.common.util.IGlossary;

/**
 * 群建好后，sdk操作时
 */
public enum JoinmodeTypeEnum implements IGlossary {
    NOT_VERIFY("不用验证", 0),
    VERIFY("需要验证", 1),
    FORBID("不允许任何人加入", 2);

    private String name;
    private Integer value;

    JoinmodeTypeEnum(String name, Integer value) {
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
