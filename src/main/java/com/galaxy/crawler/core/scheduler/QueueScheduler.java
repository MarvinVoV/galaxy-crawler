package com.galaxy.crawler.core.scheduler;

import com.galaxy.crawler.core.domain.Request;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author hufeng
 * @version QueueScheduler.java, v 0.1 2020/7/14 00:58 Exp $
 */
@Component
public class QueueScheduler implements Scheduler {
    private BlockingQueue<Request> queue = new LinkedBlockingDeque<>();

    @Override
    public void push(Request request) {
        queue.add(request);
    }

    @Override
    public Request poll() {
        return queue.poll();
    }
}
