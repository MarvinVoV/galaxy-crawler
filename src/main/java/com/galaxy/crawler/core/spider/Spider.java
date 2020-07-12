package com.galaxy.crawler.core.spider;


import com.galaxy.crawler.core.model.SpiderInput;
import com.galaxy.crawler.core.model.SpiderOutput;

import java.util.List;

/**
 * @author hufeng
 * @version Spider.java, v 0.1 2020/7/5 19:16 Exp $
 */

public interface Spider {
    String getName();

    List<String> getStartUrls();

    SpiderOutput parse(SpiderInput input);
}
