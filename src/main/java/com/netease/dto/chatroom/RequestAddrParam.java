package com.netease.dto.chatroom;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("请求聊天室地址与令牌参数")
public class RequestAddrParam implements Serializable{
    @ApiModelProperty(value = "聊天室id",required = true)
    private String roomid;
    @ApiModelProperty(value = "进入聊天室的账号",required = true)
    private String accid;
    @ApiModelProperty(value = "客户端使用类型, 默认1",dataType = "ClientTypeEnum")
    private Integer clienttype;
    @ApiModelProperty("客户端ip，传此参数时，会根据用户ip所在地区，返回合适的地址")
    private String clientip;
}
