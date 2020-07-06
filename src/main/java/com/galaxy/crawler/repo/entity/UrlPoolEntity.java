package com.galaxy.crawler.repo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hufeng
 * @version UrlPoolEntity.java, v 0.1 2020/7/6 00:48 Exp $
 */
@Getter
@Setter
public class UrlPoolEntity implements Serializable {
    private int    id;
    private String url;
    private String status;
    private String extInfo;
    private Date   createTime;
    private Date   modifiedTime;
}
