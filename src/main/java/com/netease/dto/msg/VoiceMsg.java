package com.netease.dto.msg;

import lombok.Data;

import java.io.Serializable;

/**
 * 语音消息
 */
@Data
public class VoiceMsg implements Serializable{
    /**
     * 音持续时长ms
     */
    private Integer dur;
    /**
     * 语音文件的md5值
     */
    private String md5;
    /**
     * 生成的url
     */
    private String url;
    /**
     * 语音消息格式，只能是aac格式
     */
    private String ext;
    /**
     * 语音文件大小
     */
    private Integer size;
}
