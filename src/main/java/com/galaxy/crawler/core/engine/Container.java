package com.galaxy.crawler.core.engine;

import com.galaxy.crawler.core.domain.Request;
import com.galaxy.crawler.core.scheduler.Scheduler;
import com.galaxy.crawler.core.spider.Spider;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hufeng
 * @version Container.java, v 0.1 2020/7/16 01:11 Exp $
 */
@Slf4j
public class Container implements Runnable {
    protected              Spider          spider;
    protected              ExecutorService executorService;
    protected final static int             STAT_INIT        = 0;
    protected final static int             STAT_RUNNING     = 1;
    protected final static int             STAT_STOPPED     = 2;
    protected              AtomicInteger   stat             = new AtomicInteger(STAT_INIT);
    protected              Scheduler       scheduler;
    protected              int             threadNum;
    protected              boolean         exitWhenComplete = true;
    protected              boolean         destroyWhenExit  = true;
    protected              ReentrantLock   nextUrlLock      = new ReentrantLock();
    protected              Condition       nextUrlCondition = nextUrlLock.newCondition();
    protected              List<Request>   startRequests;
    private                int             idleSleepTime    = 30000;


    public Container(Spider spider) {
        this.spider = spider;
        this.scheduler = spider.getScheduler();
        this.threadNum = spider.getThreadNum();
        this.startRequests = spider.getStartRequests();
    }

    public void initComponent() {
        if (executorService == null || executorService.isShutdown()) {
            executorService = Executors.newFixedThreadPool(threadNum);
        }

    }

    @Override
    public void run() {
        checkRunningStat();

        while (!Thread.currentThread().isInterrupted() && stat.get() == STAT_RUNNING) {
            final Request request = scheduler.poll();
            if (request == null) {
                if (exitWhenComplete) {
                    break;
                }
                // wait unit new url added
                waitNextUrl();
            } else {
                // todo 控制速率
                // todo 发布url ready事件
            }

        }

        stat.set(STAT_STOPPED);
        if (destroyWhenExit) {
            close();
        }
        log.info("Container closed");
    }

    private void waitNextUrl() {
        nextUrlLock.lock();
        // double check
        if (exitWhenComplete) {
            return;
        }
        try {
            nextUrlCondition.await(idleSleepTime, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            log.warn("waitNextUrl interrupted.", e);
        } finally {
            nextUrlLock.unlock();
        }
    }

    private void checkRunningStat() {
        while (true) {
            int statNow = stat.get();
            if (statNow == STAT_RUNNING) {
                throw new IllegalStateException("Container is already running!");
            }
            if (stat.compareAndSet(statNow, STAT_RUNNING)) {
                break;
            }
        }
    }

    public void close() {
        if (executorService != null) {
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(100, TimeUnit.MICROSECONDS)) {
                    log.warn("executorService still running..");
                    System.exit(0);
                }
            } catch (InterruptedException e) {
                log.warn("close executorService interrupted.");
            }
        }
    }
}
