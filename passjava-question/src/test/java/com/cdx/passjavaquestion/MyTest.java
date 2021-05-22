package com.cdx.passjavaquestion;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.UUID;

@SpringBootTest
public class MyTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testStringRedisTemplate() {
        // 初始化redis组件
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        // 存储数据
        opsForValue.set("面条大师", "面条大师" + UUID.randomUUID().toString());
        // 查询数据
        String value = opsForValue.get("面条大师");
        System.out.println(value);
    }
}
