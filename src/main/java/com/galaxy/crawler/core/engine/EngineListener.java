package com.galaxy.crawler.core.engine;

import com.galaxy.crawler.core.engine.event.UrlExtractEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author hufeng
 * @version : EngineListener.java, v 0.1 2020年07月13日 10:02 上午 hufeng Exp $
 */
@Component
public class EngineListener {
    @EventListener
    public void onUrlExtractEvent(UrlExtractEvent event) {

    }
}