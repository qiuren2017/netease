package com.bsm.netease.dto.chatroom;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("添加机器人参数")
public class AddRobotParam implements Serializable {
    @ApiModelProperty(value = "聊天室id", required = true)
    private String roomid;
    @ApiModelProperty(value = "机器人账号accid列表，必须是有效账号，账号数量上限100个", required = true)
    private List<String> accids;
    @ApiModelProperty("机器人信息扩展字段，请使用json格式，长度4096字符")
    private String roleExt;
    @ApiModelProperty("机器人进入聊天室通知的扩展字段，请使用json格式，长度2048字符\n")
    private String notifyExt;
}
