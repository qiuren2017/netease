package com.bsm.netease.dto.friend;

import com.bsm.netease.model.friend.UserFriendTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 加好友参数
 */
@Data
public class AddFriendParam implements Serializable {
    @ApiModelProperty(value = "加好友发起者accid", required = true)
    private String accid;
    @ApiModelProperty(value = "加好友接收者accid", required = true)
    private String faccid;
    /**
     * @see UserFriendTypeEnum
     */
    @ApiModelProperty(value = "添加好友类型：1直接加好友，2请求加好友，3同意加好友，4拒绝加好友", required = true)
    private Integer type;
    @ApiModelProperty("加好友对应的请求消息")
    private String msg;
    @ApiModelProperty("服务器端扩展字段")
    private String serverex;
}
