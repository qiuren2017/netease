package com.bsm.netease.dto.chatroom;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("创建聊天室返回数据")
public class CreateChatRoomResponse implements Serializable {
    private String roomid;
    private Boolean valid;
    private String announcement;
    private String name;
    private String broadcasturl;
    private String ext;
    private String creator;
}
