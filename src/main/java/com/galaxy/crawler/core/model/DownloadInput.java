package com.galaxy.crawler.core.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hufeng
 * @version DownloadRequest.java, v 0.1 2020/7/11 17:51 Exp $
 */
@Data
public class DownloadInput {
    private String              url;
    private Map<String, String> cookies = new HashMap<>();
    private Map<String, String> headers = new HashMap<>();
}
