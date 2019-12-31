package com.springboot.netease.dto.team;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 获取群组已读消息的已读详情信息返回数据
 */
@Data
public class MarkReadInfo implements Serializable{
    private Integer readSize;
    private Integer unreadSize;
    private List<String> readAccids;
    private List<String> unreadAccids;

}
