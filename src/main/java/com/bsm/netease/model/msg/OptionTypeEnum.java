package com.bsm.netease.model.msg;

import java.io.Serializable;

/**
 * 消息字段说明
 */
public enum  OptionTypeEnum implements Serializable{
    roam("该消息是否需要漫游，默认true（需要app开通漫游消息功能）", 0),
    history("该消息是否存云端历史，默认true", 1),
    sendersync("该消息是否需要发送方多端同步，默认true", 2),
    push("该消息是否需要APNS推送或安卓系统通知栏推送，默认true", 3),
    route("该消息是否需要抄送第三方；默认true (需要app开通消息抄送功能)", 4),
    badge("该消息是否需要计入到未读计数中，默认true", 6),
    needPushNick("推送文案是否需要带上昵称，不设置该参数时默认true", 10),
    persistent("是否需要存离线消息，不设置该参数时默认true", 100);

    private String name;
    private Integer value;

    OptionTypeEnum(String name, Integer value) {
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
