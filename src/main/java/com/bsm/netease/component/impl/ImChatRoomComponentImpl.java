package com.bsm.netease.component.impl;

import com.alibaba.fastjson.JSONObject;
import com.bsm.netease.JsonUtils;
import com.bsm.netease.NeteaseUtil;
import com.bsm.netease.component.ImChatRoomComponent;
import com.bsm.netease.dto.chatroom.*;
import com.bsm.netease.model.NeteaseApiEnum;
import com.bsm.netease.model.NeteaseCode;
import com.common.exception.BizException;
import com.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class ImChatRoomComponentImpl implements ImChatRoomComponent {
    @Resource
    private NeteaseUtil neteaseUtil;

    @Override
    public CreateChatRoomResponse create(CreateChatRoom dto) {
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_create.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            CreateChatRoomResponse roomResponse = JsonUtils.jsonString2Object(tdResult.getJSONObject("chatroom").toJSONString(), CreateChatRoomResponse.class);
            return roomResponse;
        }
        log.warn("网易云创建聊天室失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("create.error", "网易云创建聊天室失败");
    }

    @Override
    public ChatRoomInfo get(String roomid, boolean needOnlineUserCount) {
        JSONObject param = new JSONObject();
        param.put("roomid", roomid);
        param.put("needOnlineUserCount", needOnlineUserCount);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_get.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            ChatRoomInfo chatroom = JsonUtils.jsonString2Object(tdResult.getJSONObject("chatroom").toJSONString(), ChatRoomInfo.class);
            return chatroom;
        }
        log.warn("网易云查询聊天室信息失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("get.error", "网易云查询聊天室信息失败");
    }

    @Override
    public ChatRoomBatchResponse getBatch(List<String> roomids, boolean needOnlineUserCount) {
        JSONObject param = new JSONObject();
        param.put("roomids", roomids);
        param.put("needOnlineUserCount", needOnlineUserCount);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_getBatch.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            List<String> noExistRooms = tdResult.getJSONArray("noExistRooms").toJavaList(String.class);
            List<String> failRooms = tdResult.getJSONArray("failRooms").toJavaList(String.class);
            List<ChatRoomInfo> succRooms = tdResult.getJSONArray("succRooms").toJavaList(ChatRoomInfo.class);
            ChatRoomBatchResponse batchResponse = new ChatRoomBatchResponse(noExistRooms, succRooms, failRooms);
            return batchResponse;
        }
        log.warn("网易云批量查询聊天室信息失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("getBatch.error", "网易云批量查询聊天室信息失败");
    }

    @Override
    public CreateChatRoomResponse update(UpdateChatRoom dto) {
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_update.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            CreateChatRoomResponse chatroom = JsonUtils.jsonString2Object(tdResult.getJSONObject("chatroom").toJSONString(), CreateChatRoomResponse.class);
            return chatroom;
        }
        log.warn("网易云更新聊天室信息失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("update.error", "网易云更新聊天室信息失败");
    }

    @Override
    public CreateChatRoomResponse toggleCloseStat(String roomid, String operator, Boolean valid) {
        JSONObject param = new JSONObject();
        param.put("roomid", roomid);
        param.put("operator", operator);
        param.put("valid", valid);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_toggleCloseStat.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            CreateChatRoomResponse chatroom = JsonUtils.jsonString2Object(tdResult.getJSONObject("desc").toJSONString(), CreateChatRoomResponse.class);
            return chatroom;
        }
        log.warn("网易云修改聊天室开/关闭状态失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("update.error", "网易云修改聊天室开/关闭状态失败");
    }

    @Override
    public MemberRoleResponse setMemberRole(MemberRoleParam dto) {
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_setMemberRole.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            MemberRoleResponse chatroom = JsonUtils.jsonString2Object(tdResult.getJSONObject("desc").toJSONString(), MemberRoleResponse.class);
            return chatroom;
        }
        log.warn("网易云设置聊天室内用户角色失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("setMemberRole.error", "网易云设置聊天室内用户角色失败");
    }

    @Override
    public List<String> requestAddr(RequestAddrParam dto) {
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_requestAddr.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            List<String> addrs = tdResult.getJSONArray("addr").toJavaList(String.class);
            return addrs;
        }
        log.warn("网易云请求聊天室地址与令牌失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("requestAddr.error", "网易云请求聊天室地址与令牌失败");
    }

    @Override
    public SendMsgResponse sendMsg(SendMsgParam dto) {
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_sendMsg.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            SendMsgResponse msgResponse = JsonUtils.jsonString2Object(tdResult.getJSONObject("desc").toJSONString(),SendMsgResponse.class);
            return msgResponse;
        }
        log.warn("网易云发送聊天室消息失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("sendMsg.error", "网易云发送聊天室消息失败");
    }

    @Override
    public AddRobotReponse addRobot(AddRobotParam dto) {
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_addRobot.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            AddRobotReponse addRobotReponse = JsonUtils.jsonString2Object(tdResult.getJSONObject("desc").toJSONString(), AddRobotReponse.class);
            return addRobotReponse;
        }
        log.warn("网易云往聊天室内添加机器人失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("addRobot.error", "网易云往聊天室内添加机器人失败");
    }

    @Override
    public AddRobotReponse removeRobot(String roomid, List<String> accids) {
        JSONObject param = new JSONObject();
        param.put("roomid", roomid);
        param.put("accids", accids);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_removeRobot.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            AddRobotReponse addRobotReponse = JsonUtils.jsonString2Object(tdResult.getJSONObject("desc").toJSONString(), AddRobotReponse.class);
            return addRobotReponse;
        }
        log.warn("网易云从聊天室内删除机器人失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("removeRobot.error", "网易云从聊天室内删除机器人失败");
    }

    @Override
    public Long temporaryMute(TemporaryMuteParam dto) {
        JSONObject param =JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_temporaryMute.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            Long muteDuration = tdResult.getJSONObject("desc").getLong("muteDuration");
            return muteDuration;
        }
        log.warn("网易云设置临时禁言状态失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("temporaryMute.error", "网易云设置临时禁言状态失败");
    }

    @Override
    public void queueOffer(QueueOfferParam dto) {
        JSONObject param =JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_queueOffer.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            return;
        }
        log.warn("网易云往聊天室有序队列中新加或更新元素失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("queueOffer.error", "网易云往聊天室有序队列中新加或更新元素失败");
    }

    @Override
    public QueuePollResponse queuePoll(String roomid, String key) {
        JSONObject param = new JSONObject();
        param.put("roomid",roomid);
        if(StringUtils.isNotBlank(key)){
            param.put("key",key);
        }
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_queuePoll.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            QueuePollResponse response = JsonUtils.jsonString2Object(tdResult.getJSONObject("desc").toJSONString(),QueuePollResponse.class);
            return response;
        }
        log.warn("网易云从队列中取出元素失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("queuePoll.error", "网易云从队列中取出元素失败");
    }

    @Override
    public List<QueuePollResponse> queueList(String roomid) {
        JSONObject param = new JSONObject();
        param.put("roomid",roomid);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_queueList.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            List<QueuePollResponse> responses = tdResult.getJSONObject("desc").getJSONArray("list").toJavaList(QueuePollResponse.class);
            return responses;
        }
        log.warn("网易云排序列出队列中所有元素失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("queueList.error", "网易云排序列出队列中所有元素失败");
    }

    @Override
    public void queueDrop(String roomid) {
        JSONObject param = new JSONObject();
        param.put("roomid",roomid);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_queueDrop.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            return;
        }
        log.warn("网易云删除清理整个队列失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("queueDrop.error", "网易云删除清理整个队列失败");
    }

    @Override
    public void queueInit(String roomid, Integer sizeLimit) {
        JSONObject param = new JSONObject();
        param.put("roomid",roomid);
        param.put("sizeLimit",sizeLimit);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_queueInit.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            return;
        }
        log.warn("网易云初始化队列失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("queueInit.error", "网易云初始化队列失败");
    }

    @Override
    public void muteRoom(MuteRoomParam dto) {
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_muteRoom.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            return;
        }
        log.warn("网易云将聊天室整体禁言失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("muteRoom.error", "网易云将聊天室整体禁言失败");
    }

    @Override
    public List<TopnResponse> topn(Integer topn, Long timestamp, String period, String orderby) {
        JSONObject param = new JSONObject();
        if(topn!=null){
            param.put("topn",topn);
        }
        if(timestamp!=null){
            param.put("timestamp",timestamp);
        }
        if(StringUtils.isNotBlank(period)){
            param.put("period",period);
        }
        if(StringUtils.isNotBlank(orderby)){
            param.put("orderby",orderby);
        }
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_topn.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            List<TopnResponse> list = tdResult.getJSONArray("data").toJavaList(TopnResponse.class);
            return list;
        }
        log.warn("网易云查询聊天室统计指标TopN失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("topn.error", "网易云查询聊天室统计指标TopN失败");
    }

    @Override
    public List<MembersResponse> membersByPage(String roomid, Integer type, Long endtime, Integer limit) {
        JSONObject param = new JSONObject();
        param.put("roomid",roomid);
        param.put("type",type);
        param.put("endtime",endtime);
        param.put("limit",limit);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_membersByPage.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            List<MembersResponse> list = tdResult.getJSONObject("desc").getJSONArray("data").toJavaList(MembersResponse.class);
            return list;
        }
        log.warn("网易云分页获取成员列表失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("membersByPage.error", "网易云分页获取成员列表失败");
    }

    @Override
    public List<MembersResponse> queryMembers(String roomid, String... accids) {
        JSONObject param = new JSONObject();
        param.put("roomid",roomid);
        param.put("accids", Arrays.asList(accids));
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_queryMembers.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            List<MembersResponse> list = tdResult.getJSONObject("desc").getJSONArray("data").toJavaList(MembersResponse.class);
            return list;
        }
        log.warn("网易云批量获取在线成员信息失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("queryMembers.error", "网易云批量获取在线成员信息失败");
    }

    @Override
    public void updateMyRoomRole(UpdateMyRoomRoleParam dto) {
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_updateMyRoomRole.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            return;
        }
        log.warn("网易云变更聊天室内的角色信息失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("updateMyRoomRole.error", "网易云变更聊天室内的角色信息失败");
    }

    @Override
    public List<String> queueBatchUpdateElements(QueueBatchUpdateElementsParam dto) {
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_queueBatchUpdateElements.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            List<String> list = tdResult.getJSONObject("desc").getJSONArray("noExistElementKey").toJavaList(String.class);
            return list;
        }
        log.warn("网易云批量更新聊天室队列元素失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("queueBatchUpdateElements.error", "网易云批量更新聊天室队列元素失败");
    }

    @Override
    public List<String> queryUserRoomIds(String creator) {
        JSONObject param = new JSONObject();
        param.put("creator",creator);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_queryUserRoomIds.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            List<String> list = tdResult.getJSONObject("desc").getJSONArray("roomids").toJavaList(String.class);
            return list;
        }
        log.warn("网易云查询用户创建的开启状态聊天室列表失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("queryUserRoomIds.error", "网易云查询用户创建的开启状态聊天室列表失败");
    }

    @Override
    public void updateInOutNotification(String roomid, Boolean close) {
        JSONObject param = new JSONObject();
        param.put("roomid",roomid);
        param.put("close",close);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.chatroom_updateInOutNotification.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            return;
        }
        log.warn("网易云关闭指定聊天室进出通知失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("updateInOutNotification.error", "网易云关闭指定聊天室进出通知失败");
    }
}
