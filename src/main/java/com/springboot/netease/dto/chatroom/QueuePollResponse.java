package com.springboot.netease.dto.chatroom;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("从队列中取出元素 返回数据")
public class QueuePollResponse implements Serializable {
    private String key;
    private String value;
}
