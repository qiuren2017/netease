package com.bsm.netease.dto.chatroom;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 聊天室发送消息返回数据
 */
@Data
public class SendMsgResponse implements Serializable {
    private String roomId;
    private String fromAccount;
    private String fromNick;
    private String fromAvator;
    private Integer type;
    private String ext;
    private String attach;
    private Date time;
    private String msgid_client;
    private String fromClientType;
    /**
     * 高优先级消息标记，不带此标记表示非高优先级
     */
    private Integer highPriorityFlag;
    /**
     * 消息被丢弃标记，传abandonRatio参数时才会返回此标记，不返回此标记代表未被丢弃
     */
    private Integer msgAbandonFlag;
}
