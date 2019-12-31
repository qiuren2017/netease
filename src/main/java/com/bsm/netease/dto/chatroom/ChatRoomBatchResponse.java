package com.bsm.netease.dto.chatroom;

import lombok.Data;

import java.util.List;

/**
 * 批量查询聊天室返回数据
 */
@Data
public class ChatRoomBatchResponse {
    /**
     * 不存在的聊天室id列表
     */
    private List<String> noExistRooms;
    /**
     * 聊天室列表
     */
    private List<ChatRoomInfo> succRooms;
    /**
     * 失败的聊天室id,有可能是查的时候有500错误
     */
    private List<String> failRooms;

    public ChatRoomBatchResponse() {
    }

    public ChatRoomBatchResponse(List<String> noExistRooms, List<ChatRoomInfo> succRooms, List<String> failRooms) {
        this.noExistRooms = noExistRooms;
        this.succRooms = succRooms;
        this.failRooms = failRooms;
    }
}
