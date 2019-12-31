package com.netease.dto.friend;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 更新好友相关信息参数
 */
@Data
public class UpdateFriendParam implements Serializable{
    @ApiModelProperty(value = "发起者accid",required = true)
    private String accid;
    @ApiModelProperty(value = "要修改朋友的accid",required = true)
    private String faccid;
    @ApiModelProperty("给好友增加备注名，限制长度128，可设置为空字符串")
    private String alias;
    @ApiModelProperty("修改ex字段，限制长度256，可设置为空字符串")
    private String ex;
    @ApiModelProperty("修改serverex字段，限制长度256，可设置为空字符串")
    private String serverex;
}
