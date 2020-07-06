package com.galaxy.crawler.core.spider;


import com.galaxy.crawler.core.model.result.OutputResult;

/**
 * @author hufeng
 * @version PageParser.java, v 0.1 2020/7/5 19:16 Exp $
 */

public interface Spider<T> {

    OutputResult<T> parse(String html);
}
