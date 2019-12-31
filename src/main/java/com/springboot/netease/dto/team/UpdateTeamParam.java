package com.springboot.netease.dto.team;

import com.springboot.netease.model.team.JoinmodeTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 编辑群资料参数
 */
@Data
public class UpdateTeamParam implements Serializable {
    @ApiModelProperty(value = "群Id",required = true)
    private String tid;
    @ApiModelProperty(value = "群名称")
    private String tname;
    @ApiModelProperty(value = "群主用户帐号",required = true)
    private String owner;
    @ApiModelProperty(value = "群公告")
    private String announcement;
    @ApiModelProperty(value = "群描述")
    private String intro;
    /**
     * @see JoinmodeTypeEnum
     */
    @ApiModelProperty(value = "加入群：0不用验证，1需要验证,2不允许任何人加入")
    private Integer joinmode;
    @ApiModelProperty(value = "自定义高级群扩展属性")
    private String custom;
    @ApiModelProperty(value = "群头像")
    private String icon;
    @ApiModelProperty(value = "被邀请人同意方式，0-需要同意(默认),1-不需要同意。")
    private Integer beinvitemode;
    @ApiModelProperty(value = "谁可以邀请他人入群，0-管理员(默认),1-所有人")
    private Integer invitemode;
    @ApiModelProperty(value = "谁可以修改群资料，0-管理员(默认),1-所有人")
    private Integer uptinfomode;
    @ApiModelProperty(value = "谁可以更新群自定义属性，0-管理员(默认),1-所有人")
    private Integer upcustommode;
    @ApiModelProperty(value = "该群最大人数(包含群主)，范围：2至应用定义的最大群人数(默认:200)")
    private Integer teamMemberLimit;
}
