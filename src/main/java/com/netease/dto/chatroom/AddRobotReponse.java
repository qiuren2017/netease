package com.netease.dto.chatroom;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 添加机器人返回数据
 */
@Data
public class AddRobotReponse implements Serializable {
    private String failAccids;
    private String successAccids;
    private String oldAccids;

}
