package com.galaxy.crawler.core.model.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author hufeng
 * @version CollectorParam.java, v 0.1 2020/7/5 19:34 Exp $
 */
@Data
public class DownloadRequest implements Serializable {
    private String              url;
    private Map<String, String> headers;
}
