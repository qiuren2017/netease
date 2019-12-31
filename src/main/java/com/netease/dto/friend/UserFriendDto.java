package com.netease.dto.friend;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 好友关系
 */
@Data
public class UserFriendDto implements Serializable {
    /**
     * 发起者accid
     */
    private String accid;
    /**
     * 接收者accid
     */
    private String faccid;
    /**
     * 1直接加好友，2请求加好友，3同意加好友，4拒绝加好友
     */
    private Integer type;
    /**
     * 加好友对应的请求消息，第三方组装，最长256字符
     */
    private String msg;
    /**
     * 服务器端扩展字段，限制长度256 此字段client端只读，server端读写
     */
    private String serverex;
    /**
     * 创建日期
     */
    private Date createtime;

    private Boolean bidirection;

}
