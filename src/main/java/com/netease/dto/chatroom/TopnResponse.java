package com.netease.dto.chatroom;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 查询聊天室统计指标TopN返回数据
 */
@Data
public class TopnResponse implements Serializable {
    /**
     * 聊天室ID号
     */
    private String roomId;
    /**
     * 该聊天室内的活跃数
     */
    private Integer activeNums;
    /**
     * 计时间点，单位秒，按天统计的是当天的0点整点；按小时统计的是指定小时的整点
     */
    private Date datetime;
    /**
     * 进入人次数量
     */
    private Integer enterNums;
    /**
     * 进入人次数量
     */
    private Integer msgs;
    /**
     * 统计周期，HOUR表示按小时统计；DAY表示按天统计
     */
    private String period;
}
