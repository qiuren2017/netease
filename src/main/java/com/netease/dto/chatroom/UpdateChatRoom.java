package com.netease.dto.chatroom;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("修改聊天室参数")
public class UpdateChatRoom implements Serializable{
    @ApiModelProperty(value = "聊天室id", required = true)
    private String roomid;
    @ApiModelProperty(value = "聊天室名称，长度限制128个字符")
    private String name;
    @ApiModelProperty(value = "公告，长度限制4096个字符")
    private String announcement;
    @ApiModelProperty(value = "直播地址，长度限制1024个字符")
    private String broadcasturl;
    @ApiModelProperty(value = "扩展字段，长度限制4096个字符")
    private String ext;
    @ApiModelProperty(value = "是否需要发送更新通知事件，默认true")
    private Boolean needNotify;
    @ApiModelProperty(value = "通知事件扩展字段，长度限制2048")
    private String notifyExt;
    @ApiModelProperty(value = "队列管理权限：0:所有人都有权限变更队列，1:只有主播管理员才能操作变更")
    private Integer queuelevel;
}
