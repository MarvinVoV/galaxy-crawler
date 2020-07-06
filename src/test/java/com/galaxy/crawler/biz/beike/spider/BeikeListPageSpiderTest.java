package com.galaxy.crawler.biz.beike.spider;

import com.galaxy.crawler.biz.beike.model.UrlInfo;
import com.galaxy.crawler.core.domain.UrlPool;
import com.galaxy.crawler.core.model.result.OutputResult;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hufeng
 * @version BeikeListPageSpiderTest.java, v 0.1 2020/7/6 02:17 Exp $
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class BeikeListPageSpiderTest {
    @Autowired
    private BeikeListPageSpider beikeListPageSpider;

    @Test
    public void testParse() throws Exception {
        String url = "https://sh.ke.com/ershoufang/pg3/";

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
        assertTrue(outputResult.isSuccess());
        System.out.println(outputResult.getData());
    }


}