package com.bsm.netease.model;

import java.io.Serializable;

/**
 * 网易云api类型
 */
public enum NeteaseApiEnum implements Serializable {
    user_create("创建网易云通信ID", "https://api.netease.im/nimserver/user/create.action"),
    user_update("更新网易云通信token", "https://api.netease.im/nimserver/user/update.action"),
    user_refreshToken("重置网易云通信token", "https://api.netease.im/nimserver/user/refreshToken.action"),
    user_block("封禁网易云通信ID", "https://api.netease.im/nimserver/user/block.action"),
    user_unblock("解禁网易云通信ID", "https://api.netease.im/nimserver/user/unblock.action"),
    user_updateUinfo("更新用户名片", "https://api.netease.im/nimserver/user/updateUinfo.action"),
    user_getUinfos("获取用户名片", "https://api.netease.im/nimserver/user/getUinfos.action"),
    user_setDonnop("设置桌面端在线时，移动端是否需要推送", "https://api.netease.im/nimserver/user/setDonnop.action"),
    user_mute("账号全局禁言", "https://api.netease.im/nimserver/user/mute.action"),
    user_muteAv("账号全局禁用音视频", "https://api.netease.im/nimserver/user/muteAv.action"),
    friend_add("加好友", "https://api.netease.im/nimserver/friend/add.action"),
    friend_update("更新好友相关信息", "https://api.netease.im/nimserver/friend/update.action"),
    friend_delete("删除好友", "https://api.netease.im/nimserver/friend/delete.action"),
    friend_get("获取好友关系", "https://api.netease.im/nimserver/friend/get.action"),
    user_setSpecialRelation("设置黑名单/静音", "https://api.netease.im/nimserver/user/setSpecialRelation.action"),
    user_listBlackAndMuteList("查看指定用户的黑名单和静音列表", "https://api.netease.im/nimserver/user/listBlackAndMuteList.action"),
    sms_sendcode("发送短信/语音短信验证码", "https://api.netease.im/sms/sendcode.action"),
    sms_verifycode("校验验证码", "https://api.netease.im/sms/verifycode.action"),
    sms_sendtemplate("发送通知类和运营类短信","https://api.netease.im/sms/sendtemplate.action"),
    sms_querystatus("查询通知类和运营类短信发送状态","https://api.netease.im/sms/querystatus.action"),
    msg_sendMsg("发送普通消息", "https://api.netease.im/nimserver/msg/sendMsg.action"),
    msg_sendBatchMsg("批量发送点对点普通消息", "https://api.netease.im/nimserver/msg/sendBatchMsg.action"),
    msg_sendAttachMsg("发送自定义系统通知", "https://api.netease.im/nimserver/msg/sendAttachMsg.action"),
    msg_sendBatchAttachMsg("批量发送点对点自定义系统通知", "https://api.netease.im/nimserver/msg/sendBatchAttachMsg.action"),
    msg_upload("文件上传", "https://api.netease.im/nimserver/msg/upload.action"),
    msg_fileUpload("文件上传（multipart方式）", "https://api.netease.im/nimserver/msg/fileUpload.action"),
    msg_job_nos_del("上传NOS文件清理任务", "https://api.netease.im/nimserver/job/nos/del.action"),
    msg_recall("消息撤回", "https://api.netease.im/nimserver/msg/recall.action"),
    msg_broadcastMsg("发送广播消息", "https://api.netease.im/nimserver/msg/broadcastMsg.action"),
    team_create("创建群", "https://api.netease.im/nimserver/team/create.action"),
    team_add("拉人入群", "https://api.netease.im/nimserver/team/add.action"),
    team_kick("踢人出群", "https://api.netease.im/nimserver/team/kick.action"),
    team_remove("解散群", "https://api.netease.im/nimserver/team/remove.action"),
    team_update("编辑群资料", "https://api.netease.im/nimserver/team/update.action"),
    team_query("群信息与成员列表查询", "https://api.netease.im/nimserver/team/query.action"),
    team_queryDetail("获取群组详细信息", "https://api.netease.im/nimserver/team/queryDetail.action"),
    team_getMarkReadInfo("获取群组已读消息的已读详情信息", "https://api.netease.im/nimserver/team/getMarkReadInfo.action"),
    team_changeOwner("移交群主", "https://api.netease.im/nimserver/team/changeOwner.action"),
    team_addManager("任命管理员", "https://api.netease.im/nimserver/team/addManager.action"),
    team_removeManager("移除管理员", "https://api.netease.im/nimserver/team/removeManager.action"),
    team_joinTeams("获取某用户所加入的群信息", "https://api.netease.im/nimserver/team/joinTeams.action"),
    team_updateTeamNick("修改群昵称", "https://api.netease.im/nimserver/team/updateTeamNick.action"),
    team_muteTeam("修改消息提醒开关", "https://api.netease.im/nimserver/team/muteTeam.action"),
    team_muteTlist("禁言群成员", "https://api.netease.im/nimserver/team/muteTlist.action"),
    team_leave("主动退群", "https://api.netease.im/nimserver/team/leave.action"),
    team_muteTlistAll("将群组整体禁言", "https://api.netease.im/nimserver/team/muteTlistAll.action"),
    team_listTeamMute("获取群组禁言列表", "https://api.netease.im/nimserver/team/listTeamMute.action"),
    chatroom_create("创建聊天室", "https://api.netease.im/nimserver/chatroom/create.action"),
    chatroom_get("查询聊天室信息", "https://api.netease.im/nimserver/chatroom/get.action"),
    chatroom_getBatch("批量查询聊天室信息", "https://api.netease.im/nimserver/chatroom/getBatch.action"),
    chatroom_update("更新聊天室信息", "https://api.netease.im/nimserver/chatroom/update.action"),
    chatroom_toggleCloseStat("修改聊天室开/关闭状态", "https://api.netease.im/nimserver/chatroom/toggleCloseStat.action"),
    chatroom_setMemberRole("设置聊天室内用户角色", "https://api.netease.im/nimserver/chatroom/setMemberRole.action"),
    chatroom_requestAddr("请求聊天室地址", "https://api.netease.im/nimserver/chatroom/requestAddr.action"),
    chatroom_sendMsg("发送聊天室消息", "https://api.netease.im/nimserver/chatroom/sendMsg.action"),
    chatroom_addRobot("往聊天室内添加机器人", "https://api.netease.im/nimserver/chatroom/addRobot.action"),
    chatroom_removeRobot("从聊天室内删除机器人", "https://api.netease.im/nimserver/chatroom/removeRobot.action"),
    chatroom_temporaryMute("设置临时禁言状态", "https://api.netease.im/nimserver/chatroom/temporaryMute.action"),
    chatroom_queueOffer("往聊天室有序队列中新加或更新元素", "https://api.netease.im/nimserver/chatroom/queueOffer.action"),
    chatroom_queuePoll("从队列中取出元素", "https://api.netease.im/nimserver/chatroom/queuePoll.action"),
    chatroom_queueList("排序列出队列中所有元素", "https://api.netease.im/nimserver/chatroom/queueList.action"),
    chatroom_queueDrop("删除清理整个队列", "https://api.netease.im/nimserver/chatroom/queueDrop.action"),
    chatroom_queueInit("初始化队列", "https://api.netease.im/nimserver/chatroom/queueInit.action"),
    chatroom_muteRoom("将聊天室整体禁言", "https://api.netease.im/nimserver/chatroom/muteRoom.action"),
    chatroom_topn("查询聊天室统计指标TopN", "https://api.netease.im/nimserver/chatroom/topn.action"),
    chatroom_membersByPage("分页获取成员列表", "https://api.netease.im/nimserver/chatroom/membersByPage.action"),
    chatroom_queryMembers("批量获取在线成员信息", "https://api.netease.im/nimserver/chatroom/queryMembers.action"),
    chatroom_updateMyRoomRole("变更聊天室内的角色信息", "https://api.netease.im/nimserver/chatroom/updateMyRoomRole.action"),
    chatroom_queueBatchUpdateElements("批量更新聊天室队列元素", "https://api.netease.im/nimserver/chatroom/queueBatchUpdateElements.action"),
    chatroom_queryUserRoomIds("查询用户创建的开启状态聊天室列表", "https://api.netease.im/nimserver/chatroom/queryUserRoomIds.action"),
    chatroom_updateInOutNotification("关闭指定聊天室进出通知", "https://api.netease.im/nimserver/chatroom/updateInOutNotification.action"),;

    private String name;
    private String value;

    NeteaseApiEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
