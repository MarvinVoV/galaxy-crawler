package com.galaxy.crawler.core.pageprocessor;


import com.galaxy.crawler.core.domain.Request;
import com.galaxy.crawler.core.model.Page;

import java.util.List;

/**
 * @author hufeng
 * @version PageProcessor.java, v 0.1 2020/7/5 19:16 Exp $
 */

public interface PageProcessor {
    List<Request> startRequests();

    void process(Page page);
}
