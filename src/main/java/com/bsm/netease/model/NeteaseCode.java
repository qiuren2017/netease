package com.bsm.netease.model;

import lombok.extern.slf4j.Slf4j;

/**
 * 网易云状态码
 */
@Slf4j
public enum NeteaseCode {
    SUCC(200, "操作成功"),
    ERROR_201(201, "客户端版本不对，需升级sdk"),
    ERROR_301(301, "被封禁"),
    ERROR_302(302, "用户名或密码错误"),
    ERROR_315(315, "IP限制"),
    ERROR_403(403, "非法操作或没有权限"),
    ERROR_404(404, "对象不存在"),
    ERROR_405(405, "参数长度过长"),
    ERROR_406(406, "对象只读"),
    ERROR_408(404, "客户端请求超时"),
    ERROR_413(413, "验证失败(短信服务)"),
    ERROR_414(414, "参数错误"),//地区和手机号不匹配
    ERROR_415(415, "客户端网络问题"),//地区和手机号不匹配
    ERROR_416(416, "频率控制"),
    ERROR_417(417, "重复操作"),
    ERROR_418(418, "通道不可用(短信服务)"),
    ERROR_419(419, "数量超过上限"),
    ERROR_422(422, "账号被禁用"),
    ERROR_423(423, "帐号被禁言"),
    ERROR_431(431, "HTTP重复请求"),
    ERROR_500(500, "服务器内部错误"),
    ERROR_503(503, "服务器繁忙"),
    ERROR_508(508, "消息撤回时间超限"),
    ERROR_509(509, "无效协议"),
    ERROR_514(514, "服务不可用"),
    ERROR_998(998, "解包错误"),
    ERROR_999(999, "打包错误"),

    //****************群相关错误码**********************//

    ERROR_801(801, "群人数达到上限"),
    ERROR_802(802, "没有权限"),
    ERROR_803(803, "群不存在"),
    ERROR_804(804, "用户不在群"),
    ERROR_805(805, "群类型不匹配"),
    ERROR_806(806, "创建群数量达到限制"),
    ERROR_807(807, "群成员状态错误"),
    ERROR_808(808, "申请成功"),
    ERROR_809(809, "已经在群内"),
    ERROR_810(810, "邀请成功"),
    ERROR_811(811, "@账号数量超过限制"),
    ERROR_812(812, "群禁言，普通成员不能发送消息"),
    ERROR_813(813, "群拉人部分成功"),
    ERROR_814(814, "禁止使用群组已读服务"),
    ERROR_815(815, "群管理员人数超过上限"),

    //********************音视频、白板通话相关错误码*********************//
    ERROR_9102(9102, "通道失效"),
    ERROR_9103(9103, "已经在他端对这个呼叫响应过了"),
    ERROR_11001(11001, "通话不可达，对方离线状态"),
    //***********************聊天室相关错误码*************************//
    ERROR_13001(13001, "IM主连接状态异常"),
    ERROR_13002(13002, "聊天室状态异常"),
    ERROR_13003(13003, "账号在黑名单中,不允许进入聊天室"),
    ERROR_13004(13004, "在禁言列表中,不允许发言"),
    ERROR_13005(13005, "用户的聊天室昵称、头像或成员扩展字段被反垃圾"),
    //***************************特定业务相关错误码*****************************//
    ERROR_10431(10431, "输入email不是邮箱"),
    ERROR_10432(10432, "输入mobile不是手机号码"),
    ERROR_10433(10433, "注册输入的两次密码不相同"),
    ERROR_10434(10434, "企业不存在"),
    ERROR_10435(10435, "登陆密码或帐号不对"),
    ERROR_10436(10436, "app不存在"),
    ERROR_10437(10437, "email已注册"),
    ERROR_10438(10438, "手机号已注册"),
    ERROR_10441(10441, "app名字已经存在");

    private Integer code;
    private String msg;

    NeteaseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 根据状态码获取提示信息
     *
     * @param code
     * @return
     */
    public static String getErrorInfo(Integer code) {
        for (NeteaseCode ele : values()) {
            if (ele.getCode().equals(code)) return ele.getMsg();
        }
        log.info("网易云返回状态码：" + code);
        return "未知错误";
    }

}
