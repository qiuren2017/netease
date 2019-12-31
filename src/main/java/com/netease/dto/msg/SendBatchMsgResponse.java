package com.netease.dto.msg;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 批量发送点对点普通消息 返回数据
 */
@Data
public class SendBatchMsgResponse implements Serializable {
    /**
     * 消息接受者对应的消息ID，returnMsgId参数为true时才返回
     */
    private JSONArray msgids;
    /**
     * 消息发送的时间戳
     */
    private Date timetag;
    /**
     * 未注册的帐号
     */
    private String unregister;
}
