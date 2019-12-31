package com.springboot.netease.dto.team;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 群详情中的子集
 */
@Data
public class MemberItem implements Serializable {
    private String accid;
    private String custom;
    private Boolean mute;
    private String nick;
    private Date createtime;
    private Date updatetime;
}
