package com.netease.component;

import com.netease.dto.friend.AddFriendParam;
import com.netease.dto.friend.BlackAndMute;
import com.netease.dto.friend.UpdateFriendParam;
import com.netease.dto.friend.UserFriendDto;
import com.netease.dto.user.CreateUserResponse;
import com.netease.dto.user.ImUserDto;

import java.util.List;

/**
 * 用户接口，好友接口
 */
public interface ImUserComponent {
    /**
     * 创建im用户,accid必传
     *
     * @param dto
     * @return
     */
    CreateUserResponse createUser(ImUserDto dto);

    /**
     * 更新网易云通信token
     *
     * @param accid
     * @param token
     * @return
     */
    void updateToken(String accid, String token);

    /**
     * 重置网易云通信token
     *
     * @param accid
     * @return
     */
    CreateUserResponse refreshToken(String accid);

    /**
     * 更新用户名片
     *
     * @param dto
     * @return
     */
    void updateUinfo(ImUserDto dto);

    /**
     * 查询用户名片信息
     *
     * @param accids
     * @return
     */
    List<ImUserDto> getUinfos(String... accids);

    /**
     * 封禁网易云通信ID
     *
     * @param accid
     * @param needkick 是否踢掉被禁用户，true或false，默认false
     * @return
     */
    void blockUser(String accid, Boolean needkick);

    /**
     * 解禁网易云通信ID
     *
     * @param accid
     * @return
     */
    void unblock(String accid);

    /**
     * 设置桌面端在线时，移动端是否需要推送
     *
     * @param accid
     * @param donnopOpen 桌面端在线时，移动端是否不推送：true:移动端不需要推送，false:移动端需要推送
     */
    void setDonnop(String accid, Boolean donnopOpen);

    /**
     * 设置或取消账号的全局禁言状态
     * 账号被设置为全局禁言后，不能发送“点对点”、“群”、“聊天室”消息
     *
     * @param accid
     * @param mute  是否全局禁言：true：全局禁言，false:取消全局禁言
     */
    void mute(String accid, Boolean mute);

    /**
     * 账号全局禁用音视频
     * 账号被设置为禁用音视频后，不能发起点对点音视频、创建多人音视频、发起点对点白板、创建多人白板
     *
     * @param accid
     * @param mute  是否全局禁言：true：全局禁言，false:取消全局禁言
     */
    void muteAv(String accid, Boolean mute);

    /**
     * 加好友
     * @param dto
     */
    void friendAdd(AddFriendParam dto);

    /**
     * 更新好友相关信息
     * @param dto
     */
    void friendUpdate(UpdateFriendParam dto);

    /**
     * 删除好友关系
     * @param accid 发起者accid
     * @param faccid 要删除朋友的accid
     * @param isDeleteAlias 是否需要删除备注信息
     */
    void friendDelete(String accid,String faccid,Boolean isDeleteAlias);

    /**
     * 获取好友关系
     * 查询某时间点起到现在有更新的双向好友
     *
     * @param accid
     * @param updatetime 更新时间戳，接口返回该时间戳之后有更新的好友列表
     * @return
     */
    List<UserFriendDto> getFriend(String accid, Long updatetime);

    /**
     * 设置黑名单/静音
     *
     * @param accid
     * @param targetAcc    被加黑或加静音的帐号
     * @param relationType 本次操作的关系类型,1:黑名单操作，2:静音列表操作
     * @param value        操作值，0:取消黑名单或静音，1:加入黑名单或静音
     */
    void setSpecialRelation(String accid, String targetAcc, Integer relationType, Integer value);

    /**
     * 查看指定用户的黑名单和静音列表
     *
     * @param accid
     * @return
     */
    BlackAndMute listBlackAndMuteList(String accid);
}
