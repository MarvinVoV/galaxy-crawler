package com.galaxy.crawler.repo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author hufeng
 * @version RedisTest.java, v 0.1 2020/7/11 18:40 Exp $
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis(){
        stringRedisTemplate.opsForValue().set("a", "hello");
        assertEquals("hello", stringRedisTemplate.opsForValue().get("a"));

    }
}
