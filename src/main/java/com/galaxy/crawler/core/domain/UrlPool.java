package com.galaxy.crawler.core.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author hufeng
 * @version UrlPool.java, v 0.1 2020/7/6 02:07 Exp $
 */
@Data
public class UrlPool {
    private int    id;
    private String url;
    private String status;
    private String extInfo;
    private Date   createTime;
    private Date   modifiedTime;

}
