package com.netease.dto.sms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 发送通知类和运营类短信参数
 */
@Data
public class SendtemplateParam implements Serializable{
    /**
     * 模板编号(由客户顾问配置之后告知开发者)
     */
    @ApiModelProperty(required = true)
    private Integer templateid;
    /**
     * 接收者号码列表，JSONArray格式,如["186xxxxxxxx","186xxxxxxxx"]，限制接收者号码个数最多为100个；
     非中国大陆手机号码需要填写国家代码(如美国：+1-xxxxxxxxxx)或地区代码(如香港：+852-xxxxxxxx)
     */
    @ApiModelProperty(required = true)
    private List<String> mobiles;
    /**
     * 短信参数列表，用于依次填充模板，JSONArray格式，每个变量长度不能超过30字，如["xxx","yyy"];对于不包含变量的模板，
     * 不填此参数表示模板即短信全文内容
     *
     * 模板中若含变量则必须包含此参数
     */
    private List<String> params;
    /**
     * 是否需要支持短信上行。true:需要，false:不需要
     说明：如果开通了短信上行抄送功能，该参数需要设置为true，其它情况设置无效
     */
    private Boolean needUp;
}
