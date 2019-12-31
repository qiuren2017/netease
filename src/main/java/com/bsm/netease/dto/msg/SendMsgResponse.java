package com.bsm.netease.dto.msg;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 发送消息后返回数据
 */
@Data
public class SendMsgResponse implements Serializable {
    private String msgid;
    private Date timetag;
    private Boolean antispam;
}
