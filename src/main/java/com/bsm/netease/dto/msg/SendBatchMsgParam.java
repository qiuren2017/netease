package com.bsm.netease.dto.msg;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 批量发送点对点普通消息参数
 */
@Data
public class SendBatchMsgParam implements Serializable {
    /**
     * 发送者accid
     */
    private String fromAccid;
    /**
     * ["aaa","bbb"]，最多500
     */
    private List<String> toAccids;
    /**
     * 消息类型
     *
     * @see com.bsm.netease.model.msg.MsgTypeEnum
     */
    private Integer type;
    /**
     * 最大长度5000字符，JSON格式
     */
    private String body;
    /**
     * 发消息时特殊指定的行为选项,Json格式，可用于指定消息的漫游，存云端历史，发送方多端同步，推送，消息抄送等特殊行为;
     * option中字段不填时表示默认值 option示例:
     * {"push":false,"roam":true,"history":false,"sendersync":true,"route":false,"badge":false,"needPushNick":true}
     *
     * @see com.bsm.netease.model.msg.OptionTypeEnum
     */
    private String option;
    /**
     * 推送文案,最长500个字符，android以此为推送显示文案；ios若未填写payload，显示文案以pushcontent为准。
     */
    private String pushcontent;
    /**
     * 推送对应的payload,必须是JSON,不能超过2k字符。
     */
    private String payload;
    /**
     * 开发者扩展字段，长度限制1024字符
     */
    private String ext;
    /**
     * 可选，反垃圾业务ID，实现“单条消息配置对应反垃圾”，若不填则使用原来的反垃圾配置
     */
    private String bid;
    /**
     * 可选，单条消息是否使用易盾反垃圾，可选值为0。
     * 0：（在开通易盾的情况下）不使用易盾反垃圾而是使用通用反垃圾，包括自定义消息。
     * 若不填此字段，即在默认情况下，若应用开通了易盾反垃圾功能，则使用易盾反垃圾来进行垃圾消息的判断
     */
    private Integer useYidun;
    /**
     * 是否需要返回消息ID
     * false：不返回消息ID（默认值）
     * true：返回消息ID（toAccids包含的账号数量不可以超过100个）
     */
    private Boolean returnMsgid;

}
