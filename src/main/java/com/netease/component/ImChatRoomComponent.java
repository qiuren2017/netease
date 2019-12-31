package com.netease.component;

import com.netease.dto.chatroom.*;

import java.util.List;

/**
 * 聊天室接口
 */
public interface ImChatRoomComponent {
    /**
     * 创建聊天室
     * @param dto
     * @return
     */
    CreateChatRoomResponse create(CreateChatRoom dto);

    /**
     * 查询聊天室信息
     * @param roomid 聊天室id
     * @param needOnlineUserCount 是否需要返回在线人数，true或false，默认false
     */
    ChatRoomInfo get(String roomid, boolean needOnlineUserCount);

    /**
     * 批量查询聊天室信息
     * @param roomids 多个roomid，格式为：["6001","6002","6003"],限20个
     * @param needOnlineUserCount
     * @return
     */
    ChatRoomBatchResponse getBatch(List<String> roomids,boolean needOnlineUserCount);

    /**
     * 更新聊天室信息
     * @param dto
     * @return
     */
    CreateChatRoomResponse update(UpdateChatRoom dto);

    /**
     * 修改聊天室开/关闭状态
     * @param roomid
     * @param operator 操作者账号，必须是创建者才可以操作
     * @param valid false:关闭聊天室；true:打开聊天室
     * @return
     */
    CreateChatRoomResponse toggleCloseStat(String roomid,String operator,Boolean valid);

    /**
     * 设置聊天室内用户角色
     * @param dto
     * @return
     */
    MemberRoleResponse setMemberRole(MemberRoleParam dto);

    /**
     * 请求聊天室地址与令牌
     * @param dto
     * @return
     */
    List<String> requestAddr(RequestAddrParam dto);

    /**
     * 发送聊天消息
     * @param dto
     * @return
     */
    SendMsgResponse sendMsg(SendMsgParam dto);

    /**
     * 添加机器人
     * @param dto
     * @return
     */
    AddRobotReponse addRobot(AddRobotParam dto);

    /**
     * 从聊天室内删除机器人
     * @param roomid
     * @param accids 机器人账号accid列表，必须是有效账号，账号数量上限100个
     * @return
     */
    AddRobotReponse removeRobot(String roomid,List<String> accids);

    /**
     * 设置临时禁言状态
     * @param dto
     * @return
     */
    Long temporaryMute(TemporaryMuteParam dto);

    /**
     * 往聊天室有序队列中新加或更新元素
     * 往聊天室有序队列中新加或更新元素。若该元素由用户A添加，之后再由用户B更新，则该元素的所有者为用户B。
     * @param dto
     */
    void queueOffer(QueueOfferParam dto);

    /**
     * 从队列中取出元素
     * @param roomid 聊天室id
     * @param key 目前元素的elementKey,长度限制128字符，不填表示取出头上的第一个
     * @return
     */
    QueuePollResponse queuePoll(String roomid,String key);

    /**
     * 排序列出队列中所有元素
     * @param roomid
     * @return
     */
    List<QueuePollResponse> queueList(String roomid);

    /**
     * 删除清理整个队列
     * @param roomid
     */
    void queueDrop(String roomid);

    /**
     * 初始化队列
     * @param roomid 聊天室id
     * @param sizeLimit 队列长度限制，0~1000
     */
    void queueInit(String roomid,Integer sizeLimit);

    /**
     * 将聊天室整体禁言
     * @param dto
     */
    void muteRoom(MuteRoomParam dto);

    /**
     * 查询聊天室统计指标TopN
     * @param topn topn值，可选值 1~500，默认值100
     * @param timestamp 需要查询的指标所在的时间坐标点，不提供则默认当前时间，单位秒/毫秒皆可
     * @param period 统计周期，可选值包括 hour/day, 默认hour
     * @param orderby 取排序值,可选值 active/enter/message,分别表示按日活排序，进入人次排序和消息数排序， 默认active
     * @return
     */
    List<TopnResponse> topn(Integer topn, Long timestamp, String period, String orderby);

    /**
     * 分页获取成员列表
     * @param roomid
     * @param type
     * @param endtime
     * @param limit
     * @return
     */
    List<MembersResponse> membersByPage(String roomid,Integer type,Long endtime,Integer limit);

    /**
     * 批量获取在线成员信息
     * @param roomid 聊天室id
     * @param accids ["abc","def"], 账号列表，最多200条
     * @return
     */
    List<MembersResponse> queryMembers(String roomid,String... accids);

    /**
     * 变更聊天室内的角色信息
     * @param dto
     */
    void updateMyRoomRole(UpdateMyRoomRoleParam dto);

    /**
     * 批量更新聊天室队列元素
     * @param dto
     * @return 未存在的key
     */
    List<String> queueBatchUpdateElements(QueueBatchUpdateElementsParam dto);

    /**
     * 查询用户创建的开启状态聊天室列表
     * @param creator 聊天室创建者accid
     * @return 聊天室列表 ['a','b','c']
     */
    List<String> queryUserRoomIds(String creator);

    /**
     * 关闭指定聊天室进出通知
     * @param roomid 聊天室ID
     * @param close 是否关闭进出通知
     */
    void updateInOutNotification(String roomid,Boolean close);

}
