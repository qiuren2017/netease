package com.bsm.netease.dto.msg;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 上传文件参数
 */
@Data
public class UploadParam implements Serializable {
    /**
     * 字符流base64串(Base64.encode(bytes)) ，最大15M的字符流
     */
    @ApiModelProperty(required = true)
    private String content;
    /**
     * 上传文件类型
     */
    private String type;
    /**
     * 返回的url是否需要为https的url，true或false，默认false
     */
    @JSONField(name = "ishttps")
    private Boolean ishttps;
    /**
     * 文件过期时长，单位：秒，必须大于等于86400
     */
    private Integer expireSec;
    /**
     * 文件的应用场景，不超过32个字符
     */
    private Integer tag;
}
