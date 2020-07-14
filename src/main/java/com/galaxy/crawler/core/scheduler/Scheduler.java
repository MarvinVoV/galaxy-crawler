package com.galaxy.crawler.core.scheduler;

import com.galaxy.crawler.core.domain.Request;

/**
 * @author hufeng
 * @version Scheduler.java, v 0.1 2020/7/11 18:17 Exp $
 */

public interface Scheduler {
    void push(Request request);

    Request poll();
}
