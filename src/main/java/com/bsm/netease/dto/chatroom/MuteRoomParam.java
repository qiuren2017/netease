package com.bsm.netease.dto.chatroom;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("将聊天室整体禁言参数")
public class MuteRoomParam implements Serializable {
    @ApiModelProperty(value = "聊天室id",required = true)
    private String roomid;
    @ApiModelProperty(value = "操作者accid，必须是管理员或创建者",required = true)
    private String operator;
    @ApiModelProperty(value = "是否禁言",required = true)
    private Boolean mute;
    @ApiModelProperty("是否需要通知")
    private Boolean needNotify;
    @ApiModelProperty("通知参数:json")
    private String notifyExt;
}
