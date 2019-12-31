package com.bsm.netease.dto.msg;

import lombok.Data;

import java.io.Serializable;

/**
 * 文本消息格式
 */
@Data
public class TextMsg implements Serializable {
    private String msg;
}
