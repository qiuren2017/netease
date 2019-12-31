package com.netease;

import cn.hutool.core.convert.Convert;
import com.alibaba.fastjson.JSONObject;
import com.common.exception.BizException;
import com.common.httpclient.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * 网易云通信工具类
 */
@Slf4j
@Component
public class NeteaseUtil {
    @Value("${netease.appKey}")
    private String appKey;
    @Value("${netease.appSecret}")
    private String appSecret;

    /**
     * 设置网易云的请求header
     */
    private void setHeader(HttpClientUtil clientUtil) {
        String nonce = UUID.randomUUID().toString();
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);
        clientUtil.setTimeOut(2000);
        clientUtil.putHeader("AppKey", appKey);
        clientUtil.putHeader("Nonce", nonce);
        clientUtil.putHeader("CurTime", curTime);
        clientUtil.putHeader("CheckSum", checkSum);
        clientUtil.putHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
    }

    /**
     * 请求网易云接口
     *
     * @param url
     * @param param
     * @return
     */
    public JSONObject doRequest(String url, JSONObject param) {
        Map<String, String> map = Convert.toMap(String.class, String.class, param);
        try {
            HttpClientUtil clientUtil = new HttpClientUtil();
            setHeader(clientUtil);
            String re = clientUtil.sendHttpPost(url, map);
            return JsonUtils.json2JsonObject(re);
        } catch (Exception e) {
            log.error("请求网易云接口异常,im.doRequest.error,", e);
            log.error("地址：{},参数：{}" + url, param);
            throw new BizException("im.doRequest", "网易云请求错误");
        }
    }
}
