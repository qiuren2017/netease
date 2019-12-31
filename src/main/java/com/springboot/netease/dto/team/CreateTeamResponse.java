package com.springboot.netease.dto.team;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 创建群返回数据
 */
@Data
public class CreateTeamResponse implements Serializable {
    @ApiModelProperty("第三方群ID")
    private String tid;
    @ApiModelProperty("群数量超限时，返回失败的accid列表")
    private List<String> faccid;

    public CreateTeamResponse() {
    }

    public CreateTeamResponse(String tid, List<String> faccid) {
        this.tid = tid;
        this.faccid = faccid;
    }
}
