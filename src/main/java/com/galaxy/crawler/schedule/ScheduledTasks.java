package com.galaxy.crawler.schedule;

import com.alibaba.fastjson.JSON;
import com.galaxy.crawler.biz.beike.model.UrlInfo;
import com.galaxy.crawler.biz.beike.spider.BeikeListPageSpider;
import com.galaxy.crawler.core.domain.enums.UrlPoolStatus;
import com.galaxy.crawler.core.model.result.OutputResult;
import com.galaxy.crawler.repo.dao.UrlPoolDAO;
import com.galaxy.crawler.repo.entity.UrlPoolEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hufeng
 * @version ScheduledTasks.java, v 0.1 2020/7/6 02:32 Exp $
 */

@Component
@Slf4j
public class ScheduledTasks {
    private int                 totalPage = 100;
    private int                 no        = 1;
    @Autowired
    private BeikeListPageSpider beikeListPageSpider;
    @Autowired
    private UrlPoolDAO          urlPoolDAO;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        try {
            log.info("The time is now {}", DateFormatUtils.format(new Date(), "HH:mm:ss"));
            if (no > totalPage) {
                return;
            }
            String url = "https://sh.ke.com/ershoufang/pg" + no + "/";

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("Host", "sh.ke.com");
            httpGet.setHeader("Connection", "keep-alive");
            httpGet.setHeader("Cache-Control", "no-cache");
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36");
            httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
            httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-US;q=0.7");
            httpGet.setHeader("Pragma", " no-cache");
            httpGet.setHeader("Cookie", "select_city=310000;");


            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity httpEntity = response.getEntity();
            String html = EntityUtils.toString(httpEntity);

            OutputResult<UrlInfo> outputResult = beikeListPageSpider.parse(html);
            if (outputResult.isSuccess()) {
                UrlInfo urlInfo = outputResult.getData();
                UrlPoolEntity entity = new UrlPoolEntity();
                entity.setUrl(urlInfo.getUrl());
                Map<String, String> map = new HashMap<>();
                map.put("detailId", urlInfo.getDetailId());
                map.put("expoId", urlInfo.getExpoId());

                entity.setExtInfo(JSON.toJSONString(map));
                entity.setStatus(UrlPoolStatus.SUCCESS.getCode());
                urlPoolDAO.save(entity);
            }
        } catch (IOException e) {
            log.error("error", e);
        }
        no++;
    }

}
