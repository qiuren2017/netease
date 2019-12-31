package com.netease.dto.msg;

import lombok.Data;

import java.io.Serializable;

/**
 * 文件消息格式
 */
@Data
public class FileMsg implements Serializable {
    /**
     * 文件名
     * BlizzardReg.ttf
     */
    private String name;
    /**
     * 文件MD5
     */
    private String md5;
    /**
     * 文件URL
     */
    private String url;
    /**
     * 文件后缀类型
     */
    private String ext;
    /**
     * 文件大小
     */
    private Integer size;

}
