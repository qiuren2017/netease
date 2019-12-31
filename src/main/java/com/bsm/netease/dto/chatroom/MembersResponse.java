package com.bsm.netease.dto.chatroom;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 聊天室成员信息返回数据
 */
@Data
public class MembersResponse implements Serializable {
    /**
     * 聊天室id
     */
    private String roomid;
    /**
     * 用户accid
     */
    private String accid;
    /**
     * 聊天室内的昵称
     */
    private String nick;
    /**
     * 聊天室内的头像
     */
    private String avator;
    private String ext;
    /**
     * 角色类型
     * @see com.bsm.netease.model.chatroom.MembersTypeEnum
     */
    private String type;
    /**
     * 成员级别（若未设置成员级别，则无此字段）
     */
    private Integer level;
    /**
     * 是否在线
     */
    private Boolean onlineStat;
    /**
     * 进入聊天室的时间点
     */
    private Date enterTime;
    /**
     * 是否在黑名单中（若未被拉黑，则无此字段）
     */
    private Boolean blacklisted;
    /**
     * 是否被禁言（若未被禁言，则无此字段）
     */
    private Boolean muted;
    /**
     * 是否被临时禁言（若未被临时禁言，则无此字段）
     */
    private Boolean tempMuted;
    /**
     * 临时禁言的解除时长,单位秒（若未被临时禁言，则无此字段）
     */
    private Long tempMuteTtl;
    /**
     * 是否是聊天室机器人（若不是机器人，则无此字段）
     */
    private Boolean isRobot;
    /**
     * 机器人失效的时长，单位秒（若不是机器人，则无此字段）
     */
    private Integer robotExpirAt;
}
