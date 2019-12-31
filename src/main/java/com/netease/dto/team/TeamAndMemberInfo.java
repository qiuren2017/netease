package com.netease.dto.team;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 查询群信息返回数据
 */
@Data
public class TeamAndMemberInfo implements Serializable {
    private String tid;
    private String tname;
    private String owner;
    private String announcement;
    private String intro;
    private Integer maxusers;
    private Integer joinmode;
    private Integer size;
    private String custom;
    private String clientCustom;
    private Boolean mute;
    private Date createtime;
    private Date updatetime;
    private List<String> admins;
    private List<String> members;
}
