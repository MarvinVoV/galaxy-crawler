package com.galaxy.crawler.core.model.event;

import com.galaxy.crawler.core.domain.Request;
import lombok.Data;

/**
 * @author hufeng
 * @version RequestReadyEvent.java, v 0.1 2020/7/14 02:58 Exp $
 */
@Data
public class RequestReadyEvent extends BaseEvent {
    private Request request;
}
