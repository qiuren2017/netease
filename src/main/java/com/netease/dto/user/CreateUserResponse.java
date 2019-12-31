package com.netease.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 建立用户返回数据
 */
@Data
public class CreateUserResponse implements Serializable {
    private String accid;
    private String name;
    private String token;
}
