package com.netease.dto.sms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 发送短信参数
 */
@Data
public class SendcodeParam implements Serializable {
    /**
     * 目标手机号，非中国大陆手机号码需要填写国家代码(如美国：+1-xxxxxxxxxx)或地区代码(如香港：+852-xxxxxxxx)
     */
    @ApiModelProperty(required = true)
    private String mobile;
    /**
     * 目标设备号，可选参数
     */
    private String deviceId;
    /**
     * 模板编号(如不指定则使用配置的默认模版)
     */
    private String templateid;
    /**
     * 验证码长度，范围4～10，默认为4
     */
    private String codeLen;
    /**
     * 客户自定义验证码，长度为4～10个数字
     如果设置了该参数，则codeLen参数无效
     */
    private String authCode;
    /**
     * 是否需要支持短信上行。true:需要，false:不需要
     说明：如果开通了短信上行抄送功能，该参数需要设置为true，其它情况设置无效
     */
    private String needUp;

    public SendcodeParam() {
    }

    public SendcodeParam(String mobile, String authCode) {
        this.mobile = mobile;
        this.authCode = authCode;
    }
}
