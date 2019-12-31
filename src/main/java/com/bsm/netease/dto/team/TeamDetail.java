package com.bsm.netease.dto.team;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 群詳情返回数据
 */
@Data
public class TeamDetail implements Serializable {
    private String tid;
    private String tname;
    private String icon;
    private String announcement;
    private Integer uptinfomode;
    private Integer maxusers;
    private String intro;
    private Integer upcustommode;
    private Integer beinvitemode;
    private Integer joinmode;
    private Integer invitemode;
    private Boolean mute;
    private String custom;
    private String clientCustom;
    private Date createtime;
    private Date updatetime;
    private MemberItem owner;
    private List<MemberItem> admins;
    private List<MemberItem> members;

}
