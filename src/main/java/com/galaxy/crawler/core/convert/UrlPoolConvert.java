package com.galaxy.crawler.core.convert;

import com.galaxy.crawler.core.domain.UrlPool;
import com.galaxy.crawler.repo.entity.UrlPoolEntity;
import org.springframework.beans.BeanUtils;

/**
 * @author hufeng
 * @version UrlPoolConvert.java, v 0.1 2020/7/6 02:08 Exp $
 */

public class UrlPoolConvert {
    public static UrlPool convert(UrlPoolEntity entity) {
        UrlPool urlPool = new UrlPool();
        BeanUtils.copyProperties(entity, urlPool);
        return urlPool;
    }
}
