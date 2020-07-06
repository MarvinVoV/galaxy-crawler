package com.galaxy.crawler.core.domain.enums;

/**
 * @author hufeng
 * @version PoolStatus.java, v 0.1 2020/7/6 02:56 Exp $
 */

public enum UrlPoolStatus {
    INIT("init", "init"),
    SUCCESS("success", "success"),
    ;

    private String code;
    private String desc;

    UrlPoolStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
