package com.springboot.netease.dto.chatroom;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("往聊天室有序队列中新加或更新元素参数")
public class QueueOfferParam implements Serializable {
    /**
     * 聊天室id
     */
    @ApiModelProperty(required = true)
    private String roomid;
    /**
     * elementKey,新元素的UniqKey,长度限制128字符
     */
    @ApiModelProperty(required = true)
    private String key;
    /**
     * elementValue,新元素内容，长度限制4096字符
     */
    @ApiModelProperty(required = true)
    private String value;
    /**
     * 提交这个新元素的操作者accid，默认为该聊天室的创建者，若operator对应的帐号不存在，会返回404错误。
     若指定的operator不在线，则添加元素成功后的通知事件中的操作者默认为聊天室的创建者；
     若指定的operator在线，则通知事件的操作者为operator。
     */
    private String operator;
    /**
     * 这个新元素的提交者operator的所有聊天室连接在从该聊天室掉线或者离开该聊天室的时候，提交的元素是否需要删除。
     true：需要删除；false：不需要删除。默认false。
     当指定该参数为true时，若operator当前不在该聊天室内，则会返回403错误。
     */
    @JSONField(name = "transient")
    private String transient_param;
}
