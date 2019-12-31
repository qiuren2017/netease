package com.springboot.netease.dto.team;

import com.springboot.netease.model.team.JoinmodeTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CreateTeamParam implements Serializable {
    /**
     * 群名称，最大长度64字符
     */
    @ApiModelProperty(required = true)
    private String tname;
    /**
     * 群主用户帐号，最大长度32字符
     */
    @ApiModelProperty(required = true)
    private String owner;
    /**
     * 邀请的群成员列表。["aaa","bbb"](JSONArray对应的accid，如果解析出错会报414)，members与owner总和上限为200。members中无需再加owner自己的账号。
     */
    @ApiModelProperty(required = true)
    private List<String> members;
    /**
     * 群公告，最大长度1024字符
     */
    private String announcement;
    /**
     * 群描述，最大长度512字符
     */
    private String intro;
    /**
     * 邀请发送的文字，最大长度150字符
     */
    @ApiModelProperty(required = true)
    private String msg;
    /**
     * 管理后台建群时，0不需要被邀请人同意加入群，1需要被邀请人同意才可以加入群。其它会返回414
     */
    @ApiModelProperty(required = true)
    private Integer magree;
    /**
     * 群建好后，sdk操作时，0不用验证，1需要验证,2不允许任何人加入
     *
     * @see JoinmodeTypeEnum
     */
    @ApiModelProperty(required = true)
    private Integer joinmode;
    /**
     * 自定义高级群扩展属性，第三方可以跟据此属性自定义扩展自己的群属性。（建议为json）,最大长度1024字符
     */
    private String custom;
    /**
     * 群头像，最大长度1024字符
     */
    private String icon;
    /**
     * 被邀请人同意方式，0-需要同意(默认),1-不需要同意
     */
    private Integer beinvitemode;
    /**
     * 谁可以邀请他人入群，0-管理员(默认),1-所有人
     */
    private Integer invitemode;
    /**
     * 谁可以修改群资料，0-管理员(默认),1-所有人
     */
    private Integer uptinfomode;
    /**
     * 谁可以更新群自定义属性，0-管理员(默认),1-所有人
     */
    private Integer upcustommode;
    /**
     * 该群最大人数(包含群主)，范围：2至应用定义的最大群人数(默认:200)
     */
    private Integer teamMemberLimit;

}
