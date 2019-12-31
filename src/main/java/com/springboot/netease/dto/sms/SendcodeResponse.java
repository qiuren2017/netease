package com.springboot.netease.dto.sms;

import lombok.Data;

import java.io.Serializable;

/**
 * 发送短信返回数据
 */
@Data
public class SendcodeResponse implements Serializable {
    /**
     * 此次发送的sendid
     */
    private String msgSendId;
    /**
     * 此次发送的验证码
     */
    private String objCode;

    public SendcodeResponse() {
    }

    public SendcodeResponse(String msgSendId, String objCode) {
        this.msgSendId = msgSendId;
        this.objCode = objCode;
    }
}
