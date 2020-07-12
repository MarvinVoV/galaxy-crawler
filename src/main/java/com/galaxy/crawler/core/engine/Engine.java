package com.galaxy.crawler.core.engine;

import com.galaxy.crawler.core.spider.Spider;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hufeng
 * @version Engine.java, v 0.1 2020/7/11 18:10 Exp $
 */
@Component
public class Engine implements ApplicationContextAware {
    private ExecutorService    executorService = Executors.newFixedThreadPool(10);
    private ApplicationContext applicationContext;

    public void init() {
        Map<String, Spider> spiderMap = applicationContext.getBeansOfType(Spider.class);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

    }
}
