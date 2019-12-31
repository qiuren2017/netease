package com.springboot.netease.dto.chatroom;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("批量更新聊天室队列元素参数")
public class QueueBatchUpdateElementsParam implements Serializable {
    @ApiModelProperty(value = "聊天室id",required = true)
    private String roomid;
    @ApiModelProperty(value = "操作者accid,必须是管理员或创建者",required = true)
    private String operator;
    @ApiModelProperty(value = "更新的key-value对，最大200个，示例：{\"k1\":\"v1\",\"k2\":\"v2\"}",required = true)
    private List<element> elements;
    @ApiModelProperty("是否需要发送更新通知事件，默认true")
    private Boolean needNotify;
    @ApiModelProperty("通知事件扩展字段，长度限制2048")
    private String notifyExt;
}
