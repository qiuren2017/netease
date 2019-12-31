package com.bsm.netease.dto.msg;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 消息撤回参数
 */
@Data
public class RecallParam implements Serializable {
    /**
     * 要撤回消息的msgid
     */
    @ApiModelProperty(required = true)
    private String deleteMsgid;
    /**
     * 要撤回消息的创建时间
     */
    @ApiModelProperty(required = true)
    private Long timetag;
    /**
     * 7:表示点对点消息撤回，8:表示群消息撤回
     */
    @ApiModelProperty(required = true)
    private Integer type;
    /**
     * 发消息的accid
     */
    @ApiModelProperty(required = true)
    private String from;
    /**
     * 如果点对点消息，为接收消息的accid,如果群消息，为对应群的tid
     */
    @ApiModelProperty(required = true)
    private String to;
    /**
     * 可以带上对应的描述
     */
    private String msg;
    /**
     * 1表示绕过撤回时间检测，其它为非法参数，最多撤回近30天内的消息。如果需要撤回时间检测，不填即可。
     */
    private Integer ignoreTime;
    /**
     * 推送文案，android以此为推送显示文案；ios若未填写payload，显示文案以pushcontent为准。
     * 超过500字符后，会对文本进行截断。
     */
    private String pushcontent;
    /**
     * 推送对应的payload,必须是JSON,不超过2K字符l
     */
    private String payload;


}
