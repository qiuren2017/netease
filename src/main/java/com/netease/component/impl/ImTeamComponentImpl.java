package com.netease.component.impl;

import com.alibaba.fastjson.JSONObject;
import com.common.exception.BizException;
import com.common.util.StringUtils;
import com.netease.JsonUtils;
import com.netease.NeteaseUtil;
import com.netease.component.ImTeamComponent;
import com.netease.dto.team.*;
import com.netease.model.NeteaseApiEnum;
import com.netease.model.NeteaseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ImTeamComponentImpl implements ImTeamComponent {
    @Resource
    private NeteaseUtil neteaseUtil;

    @Override
    public CreateTeamResponse createTeam(CreateTeamParam dto) {
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.team_create.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            String tid = tdResult.getString("tid");
            List<String> faccid = new ArrayList<>();
            JSONObject faccidJOB = tdResult.getJSONObject("faccid");
            if (faccidJOB != null) {
                faccid = faccidJOB.getJSONArray("accid").toJavaList(String.class);
            }
            CreateTeamResponse teamResponse = new CreateTeamResponse(tid, faccid);
            return teamResponse;
        }
        log.warn("网易云创建群失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("createTeam.error", "网易云创建群失败");
    }

    @Override
    public CreateTeamResponse addToTeam(AddToTeamParam dto) {
        if (StringUtils.isBlank(dto.getAttach())) {
            dto.setAttach("拉人");
        }
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.team_add.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            String tid = tdResult.getString("tid");
            List<String> faccid = new ArrayList<>();
            JSONObject faccidObj = tdResult.getJSONObject("faccid");
            if (faccidObj != null) {
                faccid = faccidObj.getJSONArray("accid").toJavaList(String.class);
            }
            CreateTeamResponse teamResponse = new CreateTeamResponse(tid, faccid);
            return teamResponse;
        }
        log.warn("网易云拉人入群失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("addToTeam.error", "网易云拉人入群失败");
    }

    @Override
    public void kick(KickParam dto) {
        if (StringUtils.isBlank(dto.getAttach())) {
            dto.setAttach("踢人");
        }
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.team_kick.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            return;
        }
        log.warn("网易云踢人出群失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("kick.error", "网易云踢人出群失败");
    }

    @Override
    public void remove(String tid, String owner) {
        JSONObject param = new JSONObject();
        param.put("tid", tid);
        param.put("owner", owner);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.team_remove.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            return;
        }
        log.warn("网易云解散群失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("remove.error", "网易云解散群失败");
    }

    @Override
    public void updateTeam(UpdateTeamParam dto) {
        JSONObject param = JsonUtils.object2JsonObject(dto);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.team_update.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            return;
        }
        log.warn("网易云编辑群资料失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("updateTeam.error", "网易云编辑群资料失败");
    }

    @Override
    public List<TeamAndMemberInfo> queryTeamAndMembers(List<String> tids, Integer ope) {
        JSONObject param = new JSONObject();
        param.put("tids", tids);
        param.put("ope", ope);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.team_query.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            List<TeamAndMemberInfo> list = tdResult.getJSONArray("tinfos").toJavaList(TeamAndMemberInfo.class);
            return list;
        }
        log.warn("网易云群信息与成员列表查询失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("queryTeamAndMembers.error", "网易云群信息与成员列表查询失败");
    }

    @Override
    public TeamDetail queryDetail(String tid) {
        JSONObject param = new JSONObject();
        param.put("tids", tid);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.team_queryDetail.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            TeamDetail teamDetail = JsonUtils.jsonString2Object(tdResult.getJSONObject("tinfo").toJSONString(), TeamDetail.class);
            return teamDetail;
        }
        log.warn("网易云获取群组详细信息失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("queryDetail.error", "网易云获取群组详细信息失败");
    }

    @Override
    public MarkReadInfo getMarkReadInfo(String tid, String msgid, String fromAccid, boolean snapshot) {
        JSONObject param = new JSONObject();
        param.put("tids", tid);
        param.put("msgid", msgid);
        param.put("fromAccid", fromAccid);
        param.put("snapshot", snapshot);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.team_getMarkReadInfo.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            MarkReadInfo markReadInfo = JsonUtils.jsonString2Object(tdResult.getJSONObject("data").toJSONString(), MarkReadInfo.class);
            return markReadInfo;
        }
        log.warn("网易云获取群组已读消息的已读详情信息失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("getMarkReadInfo.error", "网易云获取群组已读消息的已读详情信息失败");
    }

    @Override
    public void changeOwner(String tid, String owner, String newowner, Integer leave) {
        JSONObject param = new JSONObject();
        param.put("tid", tid);
        param.put("owner", owner);
        param.put("newowner", newowner);
        param.put("leave", leave);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.team_changeOwner.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            return;
        }
        log.warn("网易云移交群主失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("changeOwner.error", "网易云移交群主失败");
    }

    @Override
    public void addManager(String tid, String owner, List<String> members) {
        JSONObject param = new JSONObject();
        param.put("tids", tid);
        param.put("owner", owner);
        param.put("members", members);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.team_addManager.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            return;
        }
        log.warn("网易云任命管理员失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("addManager.error", "网易云任命管理员失败");
    }

    @Override
    public void removeManager(String tid, String owner, List<String> members) {
        JSONObject param = new JSONObject();
        param.put("tids", tid);
        param.put("owner", owner);
        param.put("members", members);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.team_removeManager.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            return;
        }
        log.warn("网易云解除管理员失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("removeManager.error", "网易云解除管理员失败");
    }

    @Override
    public List<JoinTeamsResponse> joinTeams(String accid) {
        JSONObject param = new JSONObject();
        param.put("accid", accid);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.team_joinTeams.getValue(), param);
        Integer code = tdResult.getInteger("code");
        if (code.equals(NeteaseCode.SUCC.getCode())) {
            if (code > 0) {
                List<JoinTeamsResponse> list = tdResult.getJSONArray("infos").toJavaList(JoinTeamsResponse.class);
                return list;
            }
            return new ArrayList<JoinTeamsResponse>();
        }
        log.warn("网易云获取某用户所加入的群信息失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("joinTeams.error", "网易云获取某用户所加入的群信息失败");
    }

    @Override
    public void updateTeamNick(String tid, String owner, String accid, String nick, String custom) {
        JSONObject param = new JSONObject();
        param.put("tid", tid);
        param.put("owner", owner);
        param.put("accid", accid);
        if (StringUtils.isNotBlank(nick)) {
            param.put("nick", nick);
        }
        if (StringUtils.isNotBlank(custom)) {
            param.put("custom", custom);
        }
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.team_updateTeamNick.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            return;
        }
        log.warn("网易云修改群昵称失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("updateTeamNick.error", "网易云修改群昵称失败");
    }

    @Override
    public void muteTeam(String tid, String accid, Integer ope) {
        JSONObject param = new JSONObject();
        param.put("tid", tid);
        param.put("accid", accid);
        param.put("ope", ope);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.team_muteTeam.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            return;
        }
        log.warn("网易云修改消息提醒开关失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("muteTeam.error", "网易云修改消息提醒开关失败");
    }

    @Override
    public void muteTlist(String tid, String owner, String accid, Integer mute) {
        JSONObject param = new JSONObject();
        param.put("tid", tid);
        param.put("owner", owner);
        param.put("accid", accid);
        param.put("mute", mute);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.team_muteTlist.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            return;
        }
        log.warn("网易云禁言群成员失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("muteTlist.error", "网易云禁言群成员失败");
    }

    @Override
    public void leave(String tid, String accid) {
        JSONObject param = new JSONObject();
        param.put("tid", tid);
        param.put("accid", accid);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.team_leave.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            return;
        }
        log.warn("网易云主动退群失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("leave.error", "网易云主动退群失败");
    }

    @Override
    public void muteTlistAll(String tid, String owner, Boolean mute, Integer muteType) {
        JSONObject param = new JSONObject();
        param.put("tid", tid);
        param.put("owner", owner);
        //两者不能同时为空
        if (mute == null && muteType == null) {
            throw new BizException("no.param", "缺少参数");
        }
        if (mute != null) {
            param.put("mute", mute);
        }
        if (muteType != null) {
            param.put("muteType", muteType);
        }
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.team_muteTlistAll.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            return;
        }
        log.warn("网易云将群组整体禁言失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("muteTlistAll.error", "网易云将群组整体禁言失败");
    }

    @Override
    public List<TeamMuteResponse> listTeamMute(String tid, String owner) {
        JSONObject param = new JSONObject();
        param.put("tid", tid);
        param.put("owner", owner);
        JSONObject tdResult = neteaseUtil.doRequest(NeteaseApiEnum.team_listTeamMute.getValue(), param);
        if (tdResult.getInteger("code").equals(NeteaseCode.SUCC.getCode())) {
            List<TeamMuteResponse> list = tdResult.getJSONArray("mutes").toJavaList(TeamMuteResponse.class);
            return list;
        }
        log.warn("网易云获取群组禁言列表失败，tdResult={},参数={}", tdResult, param);
        throw new BizException("listTeamMute.error", "网易云获取群组禁言列表失败");
    }
}
