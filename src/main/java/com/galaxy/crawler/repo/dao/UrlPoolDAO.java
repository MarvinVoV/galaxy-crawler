package com.galaxy.crawler.repo.dao;

import com.galaxy.crawler.repo.entity.UrlPoolEntity;
import com.galaxy.crawler.repo.mapper.UrlPoolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author hufeng
 * @version UrlPoolDAO.java, v 0.1 2020/7/6 01:16 Exp $
 */
@Component
public class UrlPoolDAO {
    @Autowired
    private UrlPoolMapper urlPoolMapper;

    public int save(UrlPoolEntity entity) {
        if (entity == null) {
            return -1;
        }
        if (entity.getCreateTime() == null) {
            entity.setCreateTime(new Date());
        }
        if (entity.getModifiedTime() == null) {
            entity.setModifiedTime(new Date());
        }
        return urlPoolMapper.insert(entity);
    }
}
