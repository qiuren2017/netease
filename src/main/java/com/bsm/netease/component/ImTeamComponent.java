package com.bsm.netease.component;

import com.bsm.netease.dto.team.*;

import java.util.List;

/**
 * 群接口
 */
public interface ImTeamComponent {
    /**
     * 创建群
     *
     * @param dto
     * @return
     */
    CreateTeamResponse createTeam(CreateTeamParam dto);

    /**
     * 拉人入群
     *
     * @param dto
     * @return
     */
    CreateTeamResponse addToTeam(AddToTeamParam dto);

    /**
     * 踢人出群
     *
     * @param dto
     */
    void kick(KickParam dto);

    /**
     * 解散群
     *
     * @param tid   群id
     * @param owner 群主用户帐号
     */
    void remove(String tid, String owner);

    /**
     * 编辑群资料
     *
     * @param dto
     */
    void updateTeam(UpdateTeamParam dto);

    /**
     * 群信息与成员列表查询
     *
     * @param tids 群id列表，如["3083","3084"]
     * @param ope  1表示带上群成员列表，0表示不带群成员列表，只返回群信息
     * @return
     */
    List<TeamAndMemberInfo> queryTeamAndMembers(List<String> tids, Integer ope);

    /**
     * 获取群组详细信息
     *
     * @param tid 群id
     * @return
     */
    TeamDetail queryDetail(String tid);

    /**
     * 获取群组已读消息的已读详情信息
     *
     * @param tid       群id
     * @param msgid     发送群已读业务消息时服务器返回的消息ID
     * @param fromAccid 消息发送者账号
     * @param snapshot  是否返回已读、未读成员的accid列表，默认为false
     * @return
     */
    MarkReadInfo getMarkReadInfo(String tid, String msgid, String fromAccid, boolean snapshot);

    /**
     * 移交群主
     *
     * @param tid      群唯一标识
     * @param owner    群主用户帐号
     * @param newowner 新群主帐号
     * @param leave    1:群主解除群主后离开群，2：群主解除群主后成为普通成员
     */
    void changeOwner(String tid, String owner, String newowner, Integer leave);

    /**
     * 任命管理员
     *
     * @param tid     群唯一标识
     * @param owner   群主用户帐号
     * @param members ["aaa","bbb"],最多10个
     */
    void addManager(String tid, String owner, List<String> members);

    /**
     * 移除管理员
     *
     * @param tid     群唯一标识
     * @param owner   群主用户帐号
     * @param members ["aaa","bbb"],最多10个
     */
    void removeManager(String tid, String owner, List<String> members);

    /**
     * 获取某用户所加入的群信息
     *
     * @param accid
     * @return
     */
    List<JoinTeamsResponse> joinTeams(String accid);

    /**
     * 修改群昵称
     *
     * @param tid
     * @param owner
     * @param accid
     * @param nick
     * @param custom
     */
    void updateTeamNick(String tid, String owner, String accid, String nick, String custom);

    /**
     * 修改消息提醒开关
     *
     * @param tid   群唯一标识
     * @param accid 要操作的群成员accid
     * @param ope   1：关闭消息提醒，2：打开消息提醒
     */
    void muteTeam(String tid, String accid, Integer ope);

    /**
     * 禁言群成员
     *
     * @param tid   群唯一标识
     * @param owner 群主accid
     * @param accid 禁言对象的accid
     * @param mute  1-禁言，0-解禁
     */
    void muteTlist(String tid, String owner, String accid, Integer mute);

    /**
     * 主动退群
     *
     * @param tid   群唯一标识
     * @param accid 退群的accid
     */
    void leave(String tid, String accid);

    /**
     * 将群组整体禁言
     *
     * @param tid      群唯一标识
     * @param owner    群主的accid
     * @param mute     true:禁言，false:解禁(mute和muteType至少提供一个，都提供时按mute处理)
     * @param muteType 禁言类型 0:解除禁言，1:禁言普通成员 3:禁言整个群(包括群主)
     */
    void muteTlistAll(String tid, String owner, Boolean mute, Integer muteType);

    /**
     * 获取群组禁言列表
     *
     * @param tid 群唯一标识
     * @param owner 群主的accid
     * @return
     */
    List<TeamMuteResponse> listTeamMute(String tid, String owner);

}
