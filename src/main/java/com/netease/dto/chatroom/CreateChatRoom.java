package com.netease.dto.chatroom;

import com.netease.model.chatroom.QueuelevelTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("创建聊天室参数")
public class CreateChatRoom implements Serializable {
    @ApiModelProperty(value = "聊天室属主的账号accid", required = true)
    private String creator;
    @ApiModelProperty(value = "聊天室名称，长度限制128个字符", required = true)
    private String name;
    @ApiModelProperty("公告，长度限制4096个字符")
    private String announcement;
    @ApiModelProperty("直播地址，长度限制1024个字符")
    private String broadcasturl;
    @ApiModelProperty("扩展字段，json，最长4096字符")
    private String ext;
    /**
     * @see QueuelevelTypeEnum
     */
    @ApiModelProperty(value = "队列管理权限：0:所有人都有权限变更队列，1:只有主播管理员才能操作变更。默认0")
    private Integer queuelevel;
}
