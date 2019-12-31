package com.springboot.netease.component.impl;

import com.alibaba.fastjson.JSONObject;
import com.common.exception.BizException;
import com.common.util.StringUtils;
import com.springboot.netease.JsonUtils;
import com.springboot.netease.NeteaseUtil;
import com.springboot.netease.component.ImMsgComponent;
import com.springboot.netease.dto.msg.*;
import com.springboot.netease.model.NeteaseApiEnum;
import com.springboot.netease.model.NeteaseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.Multipart;
import java.util.List;

@Slf4j
@Component
public class ImMsgComponentImpl implements ImMsgComponent {
    @Resource
    private NeteaseUtil neteaseUtil;

    @Override
    public SendMsgResponse sendMsg(SendMsgParam dto) {
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.msg_sendMsg.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            SendMsgResponse msgResponse = JsonUtils.jsonString2Object(tdResult.getJSONObject("data").toJSONString(), SendMsgResponse.class);
            return msgResponse;
        }
        log.warn("网易云发送普通消息失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("sendMsg.error", "网易云发送普通消息失败");
    }

    @Override
    public SendBatchMsgResponse sendBatchMsg(SendBatchMsgParam dto) {
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.msg_sendBatchMsg.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            SendBatchMsgResponse msgResponse = JsonUtils.jsonString2Object(tdResult.toJSONString(), SendBatchMsgResponse.class);
            return msgResponse;
        }
        log.warn("网易云批量发送点对点普通消息失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("sendBatchMsg.error", "网易云批量发送点对点普通消息失败");
    }

    @Override
    public void sendAttachMsg(SendAttachMsgParam dto) {
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.msg_sendAttachMsg.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            return;
        }
        log.warn("网易云发送自定义系统通知失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("sendAttachMsg.error", "网易云发送自定义系统通知失败");
    }

    @Override
    public String sendBatchAttachMsg(SendBatchAttachMsgParam dto) {
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.msg_sendBatchAttachMsg.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            String unregister = tdResult.getString("unregister");
            return unregister;
        }
        log.warn("网易云批量发送点对点自定义系统通知失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("sendBatchAttachMsg.error", "网易云批量发送点对点自定义系统通知失败");
    }

    @Override
    public String upload(UploadParam dto) {
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.msg_upload.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            String unregister = tdResult.getString("url");
            return unregister;
        }
        log.warn("网易云文件上传失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("upload.error", "网易云文件上传失败");
    }

    @Override
    public String fileUpload(Multipart content, String type, Boolean ishttps, Integer expireSec, String tag) {
        JSONObject param = new JSONObject();
        param.put("content", content);
        if (StringUtils.isNotBlank(type)) {
            param.put("type", type);
        }
        if (ishttps != null) {
            param.put("ishttps", ishttps);
        }
        if (expireSec != null) {
            param.put("expireSec", expireSec);
        }
        if (StringUtils.isNotBlank(tag)) {
            param.put("tag", tag);
        }
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.msg_fileUpload.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            String url = tdResult.getString("url");
            return url;
        }
        log.warn("网易云文件上传失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("fileUpload.error", "网易云文件上传失败");
    }

    @Override
    public String job_nos_del(long startTime, long endTime, String contentType, String tag) {
        JSONObject param = new JSONObject();
        param.put("startTime", startTime);
        param.put("endTime", endTime);
        if (StringUtils.isNotBlank(contentType)) {
            param.put("contentType", contentType);
        }
        if (StringUtils.isNotBlank(tag)) {
            param.put("tag", tag);
        }
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.msg_job_nos_del.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            String taskid = tdResult.getJSONObject("data").getString("taskid");
            return taskid;
        }
        log.warn("网易云上传NOS文件清理任务失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("job_nos_del.error", "网易云上传NOS文件清理任务失败");
    }

    @Override
    public void recall(RecallParam dto) {
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.msg_recall.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            return;
        }
        log.warn("网易云消息撤回失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("jrecall.error", "网易云消息撤回失败");
    }

    @Override
    public BroadcastMsgResponse broadcastMsg(String body, String from, Boolean isOffline, Integer ttl, List<String> targetOs) {
        JSONObject param = new JSONObject();
        param.put("body", body);
        if (StringUtils.isNotBlank(from)) {
            param.put("from", from);
        }
        if (isOffline != null) {
            param.put("isOffline", isOffline);
        }
        if (ttl != null) {
            param.put("ttl", ttl);
        }
        if (targetOs != null && targetOs.size() > 0) {
            param.put("targetOs", targetOs);
        }
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.msg_broadcastMsg.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            BroadcastMsgResponse msgResponse = JsonUtils.jsonString2Object(tdResult.getJSONObject("msg").toJSONString(),BroadcastMsgResponse.class);
            return msgResponse;
        }
        log.warn("网易云发送广播消息失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("broadcastMsg.error", "网易云发送广播消息失败");
    }
}
