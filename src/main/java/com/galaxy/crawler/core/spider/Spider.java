package com.galaxy.crawler.core.spider;

import com.galaxy.crawler.core.domain.Request;
import com.galaxy.crawler.core.downloader.Downloader;
import com.galaxy.crawler.core.pageprocessor.PageProcessor;
import com.galaxy.crawler.core.pipeline.Pipeline;
import com.galaxy.crawler.core.scheduler.Scheduler;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author hufeng
 * @version Spider.java, v 0.1 2020/7/14 02:01 Exp $
 */
@Slf4j
public class Spider {
    private String id;

    private List<PageProcessor> pageProcessors;

    private Downloader downloader;

    private Scheduler scheduler;

    private List<Pipeline> pipelines;

    private List<Request> startRequests;

    private int threadNum = 1;

    public List<Request> getStartRequests() {
        return startRequests;
    }

    public Scheduler getScheduler() {
        return scheduler;
    }

    public int getThreadNum() {
        return threadNum;
    }
}
