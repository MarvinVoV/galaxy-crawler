package com.galaxy.crawler.core.engine;

import com.galaxy.crawler.core.domain.Request;
import com.galaxy.crawler.core.model.event.RequestReadyEvent;
import com.galaxy.crawler.core.scheduler.Scheduler;
import com.galaxy.crawler.core.spider.Spider;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hufeng
 * @version Engine.java, v 0.1 2020/7/11 18:10 Exp $
 */
public class Engine {
    private Map<String, Spider> spiderMap = new HashMap<>();
    private ExecutorService executorService = Executors.newFixedThreadPool(20);
    private EventBus eventBus = new EventBus();

    public Engine(String scanPackage) {
        // todo
        // load class instance
    }

    public Engine(Class<? extends Spider> spiders) {
        // todo
    }
    private void initRequests() {
        spiderMap.entrySet().forEach(entry-> {
            Spider spider = entry.getValue();
            Scheduler scheduler = spider.getScheduler();
            spider.getStartRequests().forEach(scheduler::push);
        });
    }
    public void startup() {
        initRequests();
        // todo 根据spider配置 起对应的线程



            // todo 通知对应的downloader 下载


    }


    @Subscribe
    @AllowConcurrentEvents
    public void onRequestReady(RequestReadyEvent event) {

    }


}
