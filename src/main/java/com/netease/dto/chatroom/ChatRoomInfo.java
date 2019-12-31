package com.netease.dto.chatroom;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChatRoomInfo implements Serializable {
    private String roomid;
    private Boolean valid;
    private Boolean muted;
    private String announcement;
    private String name;
    private String broadcasturl;
    private Integer onlineusercount;
    private String ext;
    private String creator;
    private Integer queuelevel;
}
