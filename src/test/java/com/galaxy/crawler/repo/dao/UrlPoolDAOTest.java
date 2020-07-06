package com.galaxy.crawler.repo.dao;

import com.galaxy.crawler.repo.entity.UrlPoolEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hufeng
 * @version UrlPoolDAOTest.java, v 0.1 2020/7/6 01:59 Exp $
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(false)
class UrlPoolDAOTest {
    @Autowired
    private UrlPoolDAO urlPoolDAO;
    @Test
    public void testSave() {
        UrlPoolEntity entity = new UrlPoolEntity();
        entity.setId(1);
        entity.setStatus("xx");
        entity.setUrl("hell");
        entity.setCreateTime(new Date());
        entity.setModifiedTime(new Date());
        assertTrue(urlPoolDAO.save(entity) > 0);

    }

}