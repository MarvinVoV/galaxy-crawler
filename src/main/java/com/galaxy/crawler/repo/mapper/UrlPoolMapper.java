package com.galaxy.crawler.repo.mapper;

import com.galaxy.crawler.repo.entity.UrlPoolEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author hufeng
 * @version UrlPoolMapper.java, v 0.1 2020/7/6 00:49 Exp $
 */
@Repository
@Mapper
public interface UrlPoolMapper {
    int insert(UrlPoolEntity urlPoolEntity);
}
