package com.netease.component;

import com.netease.dto.msg.*;

import javax.mail.Multipart;
import java.util.List;

/**
 * 发送消息、通知
 */
public interface ImMsgComponent {
    /**
     * 发送普通消息
     *
     * @param dto
     * @return
     */
    SendMsgResponse sendMsg(SendMsgParam dto);

    /**
     * 批量发送点对点普通消息
     *
     * @param dto
     * @return
     */
    SendBatchMsgResponse sendBatchMsg(SendBatchMsgParam dto);

    /**
     * 发送自定义系统通知
     * 1.自定义系统通知区别于普通消息，方便开发者进行业务逻辑的通知；
     * 2.目前支持两种类型：点对点类型和群类型（仅限高级群），根据msgType有所区别。
     *
     * @param dto
     */
    void sendAttachMsg(SendAttachMsgParam dto);

    /**
     * 批量发送点对点自定义系统通知
     *
     * @param dto
     * @return 未注册的帐号列表字符串
     */
    String sendBatchAttachMsg(SendBatchAttachMsgParam dto);

    /**
     * 上传文件
     * 文件上传，字符流需要base64编码，最大15M
     *
     * @param dto
     * @return 返回文件地址
     */
    String upload(UploadParam dto);

    /**
     * 文件上传（multipart方式）,最大15M
     *
     * @param content   最大15M的字符流
     * @param type      上传文件类型
     * @param ishttps   返回的url是否需要为https的url，true或false，默认false
     * @param expireSec 文件过期时长，单位：秒，必须大于等于86400
     * @param tag       文件的应用场景，不超过32个字符
     * @return
     */
    String fileUpload(Multipart content, String type, Boolean ishttps, Integer expireSec, String tag);

    /**
     * 上传NOS文件清理任务
     *
     * @param startTime   被清理文件的开始时间，必须小于endTime且大于0，endTime和startTime不能之间不能超过7天
     * @param endTime     被清理文件的结束时间，必须大于startTime且早于今天（即只可以清理今天以前的文件）
     * @param contentType 被清理的文件类型，文件类型包含contentType则被清理 如原始文件类型为"image/png"，contentType参数为"image",则满足被清理条件
     * @param tag         被清理文件的应用场景，完全相同才被清理 如上传文件时知道场景为"usericon",tag参数为"usericon"，则满足被清理条件
     * @return taskid 清理任务id
     */
    String job_nos_del(long startTime, long endTime, String contentType, String tag);

    /**
     * 消息撤回
     * 消息撤回接口，可以撤回一定时间内的点对点与群消息
     *
     * @param dto
     */
    void recall(RecallParam dto);

    /**
     * 发送广播消息
     * 广播消息，可以对应用内的所有用户发送广播消息，广播消息目前暂不支持第三方推送（APNS、小米、华为等）；
     * 广播消息支持离线存储，并可以自定义设置离线存储的有效期，最多保留最近100条离线广播消息；
     * 此接口受频率控制，一个应用一分钟最多调用10次，一天最多调用1000次，超过会返回416状态码；
     *
     * @param body      广播消息内容，最大4096字符
     * @param from      发送者accid, 用户帐号
     * @param isOffline 是否存离线，true或false，默认false
     * @param ttl       存离线状态下的有效期，单位小时，默认7天
     * @param targetOs  目标客户端，默认所有客户端，jsonArray，格式：["ios","aos","pc","web","mac"]
     * @return
     */
    BroadcastMsgResponse broadcastMsg(String body, String from, Boolean isOffline, Integer ttl, List<String> targetOs);

}
