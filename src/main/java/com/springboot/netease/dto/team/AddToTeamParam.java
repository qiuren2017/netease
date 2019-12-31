package com.springboot.netease.dto.team;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 拉人入群参数
 */
@Data
public class AddToTeamParam implements Serializable {
    /**
     * 群唯一标识
     */
    @ApiModelProperty(required = true)
    private String tid;
    /**
     * 群主用户帐号
     */
    @ApiModelProperty(required = true)
    private String owner;
    /**
     * ["aaa","bbb"](JSONArray对应的accid，如果解析出错会报414)，一次最多拉200个成员
     */
    @ApiModelProperty(required = true)
    private List<String> members;
    /**
     * 管理后台建群时，0不需要被邀请人同意加入群，1需要被邀请人同意才可以加入群
     */
    @ApiModelProperty(required = true)
    private Integer magree;
    /**
     * 邀请发送的文字，最大长度150字符
     */
    @ApiModelProperty(required = true)
    private String msg;
    /**
     * 自定义扩展字段，最大长度512
     */
    private String attach;

}
