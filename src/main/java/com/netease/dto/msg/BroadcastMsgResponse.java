package com.netease.dto.msg;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 发送广播消息 返回数据
 */
@Data
public class BroadcastMsgResponse implements Serializable {
    private String broadcastId;
    private String body;
    private String isOffline;
    private Date createTime;
    private Date expireTime;
    private List<String> targetOs;
}
