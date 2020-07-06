package com.galaxy.crawler.biz.beike.spider;

import com.galaxy.crawler.biz.beike.model.UrlInfo;
import com.galaxy.crawler.core.model.result.OutputResult;
import com.galaxy.crawler.core.spider.Spider;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author hufeng
 * @version BeikeListPageSpider.java, v 0.1 2020/7/6 02:06 Exp $
 */
@Component
@Slf4j
public class BeikeListPageSpider implements Spider<UrlInfo> {
    @Override
    public OutputResult<UrlInfo> parse(String html) {
        OutputResult<UrlInfo> result = new OutputResult<>();
        UrlInfo urlInfo = new UrlInfo();
        result.setSuccess(true);
        result.setData(urlInfo);

        if (StringUtils.isEmpty(html)) {
            throw new RuntimeException("empty html");
        }
        Document doc = Jsoup.parse(html);
        Elements elements = doc.select("ul.sellListContent");
        if (elements.isEmpty()) {
            log.warn("empty content");
            throw new RuntimeException("empty elements");
        }

        elements.forEach(element -> {
            Element metaInfo = element.select("a.img.VIEWDATA.CLICKDATA.maidian-detail").first();
            if (metaInfo == null) {
                log.warn("data-action is empty");
                return;
            }
            String linkHref = metaInfo.attr("href");
            String dataAction = metaInfo.attr("data-action");
            Arrays.stream(dataAction.split("&")).forEach(item -> {
                System.out.println(item);
                String[] kv = item.split("=");

                if (kv.length == 2) {
                    String k = kv[0];
                    String v = kv[1];

                    if (StringUtils.equals(k, "housedel_id")) {
                        urlInfo.setDetailId(v);
                    }
                    if ("fb_expo_id".equals(k)) {
                        urlInfo.setExpoId(v);
                    }
                }
            });
            urlInfo.setUrl(linkHref +"?fb_expo_id=" + urlInfo.getExpoId());
        });
        return result;
    }
}
