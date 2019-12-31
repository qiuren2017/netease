package com.springboot.netease.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 创建用户信息
 */
@Data
public class ImUserDto implements Serializable {
    /**
     * 网易云通信ID，最大长度32字符，必须保证一个APP内唯一（只允许字母、数字、半角下划线_、会统一小写处理
     */
    private String accid;
    /**
     * 网易云通信ID昵称，最大长度64字符
     */
    private String name;
    /**
     * 网易云通信ID头像URL,最大长度1024
     */
    private String icon;
    /**
     * 网易云通信ID可以指定登录token值，最大长度128字符，并更新，如果未指定，会自动生成token，并在创建成功后返回
     */
    private String token;
    /**
     * 用户签名，最大长度256字符
     */
    private String sign;
    /**
     * 用户email，最大长度64字符
     */
    private String email;
    /**
     * 用户生日，最大长度16字符
     */
    private String birth;
    /**
     * 用户mobile，最大长度32字符,非中国大陆手机号码需要填写国家代码(如美国：+1-xxxxxxxxxx)或地区代码(如香港：+852-xxxxxxxx)
     */
    private String mobile;
    /**
     * 用户性别，0表示未知，1表示男，2女表示女，其它会报参数错误
     */
    private Integer gender;
    /**
     * 额外参数 json
     */
    private String ex;

    /**
     * 默认
     */
    public ImUserDto() {
    }

    /**
     * 用户注册
     * @param accid
     * @param name
     * @param token
     * @param mobile
     * @param gender
     */
    public ImUserDto(String accid, String name, String token, String mobile, Integer gender) {
        this.accid = accid;
        this.name = name;
        this.token = token;
        this.mobile = mobile;
        this.gender = gender;
    }

}
