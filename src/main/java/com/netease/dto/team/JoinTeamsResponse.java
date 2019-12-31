package com.netease.dto.team;

import lombok.Data;

import java.io.Serializable;

/**
 * 获取某个用户所加入高级群的群信息 返回数据
 */
@Data
public class JoinTeamsResponse  implements Serializable{
    private String tid;
    private String owner;
    private String tname;
    private Integer maxusers;
    private Integer size;
    private String custom;

}
