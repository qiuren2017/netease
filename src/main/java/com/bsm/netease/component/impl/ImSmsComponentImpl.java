package com.bsm.netease.component.impl;

import com.alibaba.fastjson.JSONObject;
import com.bsm.netease.JsonUtils;
import com.bsm.netease.NeteaseUtil;
import com.bsm.netease.component.ImSmsComponent;
import com.bsm.netease.dto.sms.QuerystatusResponse;
import com.bsm.netease.dto.sms.SendcodeResponse;
import com.bsm.netease.dto.sms.SendtemplateParam;
import com.bsm.netease.model.NeteaseApiEnum;
import com.bsm.netease.model.NeteaseCode;
import com.common.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Component
public class ImSmsComponentImpl implements ImSmsComponent {
    @Resource
    private NeteaseUtil neteaseUtil;

    @Override
    public SendcodeResponse sendCode(String mobile, String authCode) {
        JSONObject param = new JSONObject();
        param.put("mobile", mobile);
        param.put("authCode", authCode);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.sms_sendcode.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            String msgSendId = tdResult.getString("msg");
            String objCode = tdResult.getString("obj");
            SendcodeResponse sendcodeResponse = new SendcodeResponse(msgSendId,objCode);
            return sendcodeResponse;
        }
        log.warn("网易云发送短信失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("sendCode.error", "网易云发送短信失败");
    }

    @Override
    public void verifycode(String mobile, String code) {
        JSONObject param = new JSONObject();
        param.put("mobile", mobile);
        param.put("code", code);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.sms_verifycode.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            return;
        }
        log.warn("网易云校验短信验证码失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("verifycode.error", "网易云校验短信验证码失败");
    }

    @Override
    public SendcodeResponse sendtemplate(SendtemplateParam dto) {
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.sms_sendtemplate.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            String msgSendId = tdResult.getString("msg");
            String objCode = tdResult.getString("obj");
            SendcodeResponse sendcodeResponse = new SendcodeResponse(msgSendId,objCode);
            return sendcodeResponse;
        }
        log.warn("网易云发送通知类和运营类短信失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("sendtemplate.error", "网易云发送通知类和运营类短信失败");
    }

    @Override
    public List<QuerystatusResponse> querystatus(Long sendid) {
        JSONObject param = new JSONObject();
        param.put("sendid", sendid);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.sms_querystatus.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            List<QuerystatusResponse> list = tdResult.getJSONArray("obj").toJavaList(QuerystatusResponse.class);
            return list;
        }
        log.warn("网易云查询通知类和运营类短信发送状态失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("querystatus.error", "网易云查询通知类和运营类短信发送状态失败");
    }



}
