package com.netease.component;

import com.netease.dto.sms.QuerystatusResponse;
import com.netease.dto.sms.SendcodeResponse;
import com.netease.dto.sms.SendtemplateParam;

import java.util.List;

/**
 * 发送短信
 */
public interface ImSmsComponent {
    /**
     * 发送短信验证码
     *
     * @param mobile   目标手机号，非中国大陆手机号码需要填写国家代码(如美国：+1-xxxxxxxxxx)或地区代码(如香港：+852-xxxxxxxx)
     * @param authCode 客户自定义验证码，长度为4～10个数字 如果设置了该参数，则codeLen参数无效
     * @return
     */
    SendcodeResponse sendCode(String mobile, String authCode);

    /**
     * 校验短信验证码
     *
     * @param mobile 目标手机号，非中国大陆手机号码需要填写国家代码(如美国：+1-xxxxxxxxxx)或地区代码(如香港：+852-xxxxxxxx)
     * @param code   验证码
     * @return
     */
    void verifycode(String mobile, String code);

    /**
     * 发送通知类和运营类短信
     *
     * @param dto
     * @return
     */
    SendcodeResponse sendtemplate(SendtemplateParam dto);

    /**
     * 查询通知类和运营类短信发送状态
     *
     * @param sendid
     * @return
     */
    List<QuerystatusResponse> querystatus(Long sendid);
}
