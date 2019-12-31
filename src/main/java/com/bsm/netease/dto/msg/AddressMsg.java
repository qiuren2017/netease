package com.bsm.netease.dto.msg;

import lombok.Data;

import java.io.Serializable;

/**
 * 地理位置消息格式
 */
@Data
public class AddressMsg implements Serializable {
    /**
     * 地理位置title
     * 中国 浙江省 杭州市 网商路 599号
     */
    private String title;
    /**
     * 经度
     */
    private Double lng;
    /**
     * 纬度
     */
    private Double lat;

}
