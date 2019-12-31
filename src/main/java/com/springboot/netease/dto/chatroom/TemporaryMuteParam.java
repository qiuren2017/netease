package com.springboot.netease.dto.chatroom;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("设置临时禁言状态参数")
public class TemporaryMuteParam implements Serializable {
    @ApiModelProperty(value = "聊天室id",required = true)
    private String roomid;
    @ApiModelProperty(value = "操作者accid,必须是管理员或创建者",required = true)
    private String operator;
    @ApiModelProperty(value = "被禁言的目标账号accid",required = true)
    private String target;
    @ApiModelProperty(value = "0:解除禁言;>0设置禁言的秒数，不能超过2592000秒(30天)",required = true)
    private Long muteDuration;
    @ApiModelProperty(value = "操作完成后是否需要发广播")
    private Boolean needNotify;
    @ApiModelProperty("通知广播事件中的扩展字段，长度限制2048字符")
    private String notifyExt;
}
