package com.netease.dto.team;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 踢人参数
 */
@Data
public class KickParam implements Serializable {
    @ApiModelProperty(value = "群唯一标识",required = true)
    private String tid;
    @ApiModelProperty(value = "群主的accid",required = true)
    private String owner;
    @ApiModelProperty(value = "被移除人的accid，用户账号")
    private String member;
    @ApiModelProperty(value = "移除多个账号：[\"aaa\",\"bbb\"]，一次最多200个")
    private List<String> members;
    @ApiModelProperty(value = "扩展字段")
    private String attach;
}
