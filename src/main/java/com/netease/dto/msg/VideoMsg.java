package com.netease.dto.msg;

import lombok.Data;

import java.io.Serializable;

/**
 * 视频消息
 */
@Data
public class VideoMsg implements Serializable {
    /**
     * 视频持续时长ms
     */
    private Integer dur;
    /**
     * 视频文件的md5值
     */
    private String md5;
    /**
     * 生成的url
     */
    private String url;
    /**
     * 宽
     */
    private Integer w;
    /**
     * 高
     */
    private Integer h;
    /**
     * 视频格式
     */
    private String ext;
    /**
     * 视频文件大小
     */
    private Integer size;
}
