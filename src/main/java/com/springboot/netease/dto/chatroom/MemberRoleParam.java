package com.springboot.netease.dto.chatroom;

import com.springboot.netease.model.chatroom.OptTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("设置聊天室内用户角色参数")
public class MemberRoleParam implements Serializable {
    @ApiModelProperty(value = "聊天室id", required = true)
    private String roomid;
    @ApiModelProperty(value = "操作者账号accid", required = true)
    private String operator;
    @ApiModelProperty(value = "被操作者账号accid", required = true)
    private String target;
    /**
     * @see OptTypeEnum
     */
    @ApiModelProperty(value = "操作:1: 设置为管理员,2:设置普通等级用户,-1:设为黑名单用户,-2:设为禁言用户", required = true)
    private Integer opt;
    @ApiModelProperty(value = "true:设置；false:取消设置", required = true)
    private Boolean optvalue;
    @ApiModelProperty("通知扩展字段，长度限制2048，请使用json格式")
    private String notifyExt;
}
