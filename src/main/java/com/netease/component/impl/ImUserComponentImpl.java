package com.netease.component.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.common.exception.BizException;
import com.netease.JsonUtils;
import com.netease.NeteaseUtil;
import com.netease.component.ImUserComponent;
import com.netease.dto.friend.AddFriendParam;
import com.netease.dto.friend.BlackAndMute;
import com.netease.dto.friend.UpdateFriendParam;
import com.netease.dto.friend.UserFriendDto;
import com.netease.dto.user.CreateUserResponse;
import com.netease.dto.user.ImUserDto;
import com.netease.model.NeteaseApiEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Component
public class ImUserComponentImpl implements ImUserComponent {
    @Resource
    private NeteaseUtil neteaseUtil;

    @Override
    public CreateUserResponse createUser(ImUserDto dto) {
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.user_create.getValue(), param);
        if (tdResult.getString("code").equals("200")) {
            CreateUserResponse userResponse = JsonUtils.jsonString2Object(tdResult.getJSONObject("info").toJSONString(), CreateUserResponse.class);
            return userResponse;
        }
        log.warn("网易云创建用户失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("createUser.error", "网易云创建用户失败");
    }

    @Override
    public void updateToken(String accid, String token) {
        JSONObject param = new JSONObject();
        param.put("accid", accid);
        param.put("token", token);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.user_update.getValue(), param);
        if (tdResult.getString("code").equals("200")) {
            return;
        }
        log.warn("网易云更新网易云通信token失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("updateToken.error", "网易云更新网易云通信token失败");
    }

    @Override
    public CreateUserResponse refreshToken(String accid) {
        JSONObject param = new JSONObject();
        param.put("accid", accid);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.user_refreshToken.getValue(), param);
        if (tdResult.getString("code").equals("200")) {
            CreateUserResponse userResponse = JsonUtils.jsonString2Object(tdResult.getJSONObject("info").toJSONString(), CreateUserResponse.class);
            return userResponse;
        }
        log.warn("网易云重置网易云通信token失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("refreshToken.error", "网易云重置网易云通信token失败");
    }

    @Override
    public void updateUinfo(ImUserDto dto) {
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.user_updateUinfo.getValue(), param);
        if (tdResult.getString("code").equals("200")) {
            return;
        }
        log.warn("网易云更新个人名片失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("updateUinfo.error", "网易云更新个人名片失败");
    }

    @Override
    public List<ImUserDto> getUinfos(String... accids) {
        if (accids.length > 200) {
            log.warn("查询用户名片，一次最多查询200条");
            throw new BizException("im.getUinfos.error", "一次最多查询200条");
        }
        JSONObject param = new JSONObject();
        param.put("accids", JSONArray.parseArray(JSON.toJSONString(accids)));
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.user_getUinfos.getValue(), param);
        if (tdResult.getString("code").equals("200")) {
            List<ImUserDto> list = tdResult.getJSONArray("uinfos").toJavaList(ImUserDto.class);
            return list;
        }
        log.warn("网易云查询用户名片失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("getUinfos.error", "网易云查询用户名片失败");
    }

    @Override
    public void blockUser(String accid, Boolean needkick) {
        JSONObject param = new JSONObject();
        param.put("accid", accid);
        param.put("needkick", needkick);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.user_block.getValue(), param);
        if (tdResult.getString("code").equals("200")) {
            return;
        }
        log.warn("网易云封禁网易云通信ID失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("blockUser.error", "网易云封禁网易云通信ID失败");
    }

    @Override
    public void unblock(String accid) {
        JSONObject param = new JSONObject();
        param.put("accid", accid);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.user_unblock.getValue(), param);
        if (tdResult.getString("code").equals("200")) {
            return;
        }
        log.warn("网易云解禁网易云通信ID失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("unblock.error", "网易云解禁网易云通信ID失败");
    }

    @Override
    public void setDonnop(String accid, Boolean donnopOpen) {
        JSONObject param = new JSONObject();
        param.put("accid", accid);
        param.put("donnopOpen", donnopOpen);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.user_setDonnop.getValue(), param);
        if (tdResult.getString("code").equals("200")) {
            return;
        }
        log.warn("网易云设置桌面端在线时，移动端是否需要推送失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("setDonnop.error", "网易云设置桌面端在线时，移动端是否需要推送失败");
    }

    @Override
    public void mute(String accid, Boolean mute) {
        JSONObject param = new JSONObject();
        param.put("accid", accid);
        param.put("mute", mute);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.user_mute.getValue(), param);
        if (tdResult.getString("code").equals("200")) {
            return;
        }
        log.warn("网易云账号全局禁言失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("mute.error", "网易云账号全局禁言失败");
    }

    @Override
    public void muteAv(String accid, Boolean mute) {
        JSONObject param = new JSONObject();
        param.put("accid", accid);
        param.put("mute", mute);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.user_muteAv.getValue(), param);
        if (tdResult.getString("code").equals("200")) {
            return;
        }
        log.warn("网易云账号全局禁用音视频失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("muteAv.error", "网易云账号全局禁用音视频失败");
    }

    @Override
    public void friendAdd(AddFriendParam dto) {
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.friend_add.getValue(), param);
        if (tdResult.getString("code").equals("200")) {
            return;
        }
        log.warn("网易云加好友失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("friendAdd.error", "网易云加好友失败");
    }

    @Override
    public void friendUpdate(UpdateFriendParam dto) {
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.friend_update.getValue(), param);
        if (tdResult.getString("code").equals("200")) {
            return;
        }
        log.warn("网易云更新好友相关信息失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("friendUpdate.error", "网易云更新好友相关信息失败");
    }

    @Override
    public void friendDelete(String accid, String faccid, Boolean isDeleteAlias) {
        JSONObject param = new JSONObject();
        param.put("accid", accid);
        param.put("faccid", faccid);
        param.put("isDeleteAlias", isDeleteAlias);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.friend_delete.getValue(), param);
        if (tdResult.getString("code").equals("200")) {
            return;
        }
        log.warn("网易云删除好友失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("friendDelete.error", "网易云删除好友失败");
    }

    @Override
    public List<UserFriendDto> getFriend(String accid, Long updatetime) {
        JSONObject param = new JSONObject();
        param.put("accid", accid);
        param.put("updatetime", updatetime);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.friend_get.getValue(), param);
        if (tdResult.getString("code").equals("200")) {
            List<UserFriendDto> list = tdResult.getJSONArray("friends").toJavaList(UserFriendDto.class);
            return list;
        }
        log.warn("网易云获取好友关系失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("getFriend.error", "网易云获取好友关系失败");
    }

    @Override
    public void setSpecialRelation(String accid, String targetAcc, Integer relationType, Integer value) {
        JSONObject param = new JSONObject();
        param.put("accid", accid);
        param.put("targetAcc", targetAcc);
        param.put("relationType", relationType);
        param.put("value", value);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.user_setSpecialRelation.getValue(), param);
        if (tdResult.getString("code").equals("200")) {
            return;
        }
        log.warn("网易云设置黑名单/静音失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("setSpecialRelation.error", "网易云设置黑名单/静音失败");
    }

    @Override
    public BlackAndMute listBlackAndMuteList(String accid) {
        JSONObject param = new JSONObject();
        param.put("accid", accid);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.user_listBlackAndMuteList.getValue(), param);
        if (tdResult.getString("code").equals("200")) {
            List<String> mutelist = tdResult.getJSONArray("mutelist").toJavaList(String.class);
            List<String> blacklist = tdResult.getJSONArray("blacklist").toJavaList(String.class);
            BlackAndMute blackAndMute = new BlackAndMute(mutelist, blacklist);
            return blackAndMute;
        }
        log.warn("网易云查看指定用户的黑名单和静音列表失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("listBlackAndMuteList.error", "网易云查看指定用户的黑名单和静音列表失败");
    }
}
