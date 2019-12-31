package com.springboot.netease.dto.msg;

import lombok.Data;

import java.io.Serializable;

/**
 * 图片消息格式
 */
@Data
public class PictureMsg implements Serializable {
    /**
     * 图片name
     */
    private String name;
    /**
     * 图片文件md5
     */
    private String md5;
    /**
     * 生成的url
     */
    private String url;
    /**
     * 图片后缀
     */
    private String ext;
    /**
     * 宽
     */
    private Integer w;
    /**
     * 高
     */
    private Integer h;
    /**
     * 图片大小
     */
    private Integer size;

}
