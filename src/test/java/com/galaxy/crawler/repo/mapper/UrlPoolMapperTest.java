package com.galaxy.crawler.repo.mapper;

import com.galaxy.crawler.repo.entity.UrlPoolEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hufeng
 * @version UrlPoolMapperTest.java, v 0.1 2020/7/6 01:26 Exp $
 */
@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class UrlPoolMapperTest {
    @Autowired
    private UrlPoolMapper urlPoolMapper;

    @Test
    public void insert() {
        UrlPoolEntity entity = new UrlPoolEntity();
        entity.setId(1);
        entity.setStatus("xx");
        entity.setUrl("hell");
        entity.setCreateTime(new Date());
        entity.setModifiedTime(new Date());
        int result = urlPoolMapper.insert(entity);
        assertTrue(result > 0);
    }


}