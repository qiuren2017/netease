package com.bsm.netease.dto.chatroom;

import com.bsm.netease.model.chatroom.MemberRoleTypeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 设置聊天室内用户角色返回数据
 */
@Data
public class MemberRoleResponse implements Serializable{
    private String roomid;
    private Integer level;
    private String accid;
    /**
     * @see MemberRoleTypeEnum
     */
    private String type;
}
