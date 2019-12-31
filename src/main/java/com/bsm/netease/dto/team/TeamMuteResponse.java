package com.bsm.netease.dto.team;

import lombok.Data;

import java.io.Serializable;

/**
 * 获取群组禁言列表 返回数据
 */
@Data
public class TeamMuteResponse implements Serializable {
    private String tid;
    private String accid;
    private String nick;
    private Integer type;

}
