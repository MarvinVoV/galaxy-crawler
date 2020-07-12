package com.galaxy.crawler.core.downloader;


import com.galaxy.crawler.core.model.DownloadInput;
import com.galaxy.crawler.core.model.DownloadOutput;

/**
 * @author hufeng
 * @version DataCollector.java, v 0.1 2020/7/5 19:24 Exp $
 */

public interface Downloader {
    DownloadOutput download(DownloadInput downloadInput);
}
