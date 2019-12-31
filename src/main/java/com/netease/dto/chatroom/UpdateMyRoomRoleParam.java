package com.netease.dto.chatroom;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("变更聊天室内的角色信息参数")
public class UpdateMyRoomRoleParam implements Serializable {
    @ApiModelProperty(value = "聊天室id",required = true)
    private String roomid;
    @ApiModelProperty(value = "需要变更角色信息的accid",required = true)
    private String accid;
    @ApiModelProperty("变更的信息是否需要持久化，默认false，仅对聊天室固定成员生效")
    private Boolean save;
    @ApiModelProperty("是否需要做通知")
    private Boolean needNotify;
    @ApiModelProperty("通知的内容，长度限制2048")
    private String notifyExt;
    @ApiModelProperty("聊天室室内的角色信息：昵称，不超过64个字符")
    private String nick;
    @ApiModelProperty("聊天室室内的角色信息：头像")
    private String avator;
    @ApiModelProperty("聊天室室内的角色信息：开发者扩展字段")
    private String ext;
}
