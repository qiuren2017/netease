package com.netease.dto.sms;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 查询通知类和运营类短信发送状态 返回数据
 */
@Data
public class QuerystatusResponse implements Serializable {
    /**
     * 发送状态：0-未发送,1-发送成功,2-发送失败,3-反垃圾
     */
    private Integer status;
    private String mobile;
    private Date updatetime;
}
