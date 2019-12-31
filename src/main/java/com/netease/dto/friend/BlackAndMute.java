package com.netease.dto.friend;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 黑名单和静音列表数据
 */
@Data
public class BlackAndMute implements Serializable {
    /**
     * 静音列表
     */
    private List<String> mutelist;
    /**
     * 黑名单列表
     */
    private List<String> blacklist;

    public BlackAndMute() {
    }

    public BlackAndMute(List<String> mutelist, List<String> blacklist) {
        this.mutelist = mutelist;
        this.blacklist = blacklist;
    }
}
