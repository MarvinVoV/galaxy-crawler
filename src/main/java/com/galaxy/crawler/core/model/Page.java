package com.galaxy.crawler.core.model;

import com.galaxy.crawler.core.domain.Request;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hufeng
 * @version Page.java, v 0.1 2020/7/14 01:49 Exp $
 */
@Data
public class Page {
    private List<Request> targetRequests = new ArrayList<>();

}
