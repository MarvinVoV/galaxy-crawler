package com.galaxy.crawler.core.downloader;


import com.galaxy.crawler.core.model.request.DownloadRequest;
import com.galaxy.crawler.core.model.result.DownloadResult;

/**
 * @author hufeng
 * @version DataCollector.java, v 0.1 2020/7/5 19:24 Exp $
 */

public interface Downloader<T> {
    DownloadResult<T> download(DownloadRequest param);
}
