package com.galaxy.crawler.core.model.event;

import com.galaxy.crawler.core.spider.Spider;
import lombok.Data;

/**
 * @author hufeng
 * @version Event.java, v 0.1 2020/7/14 02:57 Exp $
 */
@Data
public abstract class BaseEvent {
    protected Spider spider;
}
