package com.eastspider.sct.client;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

public class RedissonClientX {

    private static RedissonClientX redissonClientX = new RedissonClientX();
    private final RedissonClient redissonClient;

    private RedissonClientX() {
        Config config = null;
        try {
            config = Config.fromYAML(new ClassPathResource("redisson.yaml").getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        redissonClient = Redisson.create(config);
    }

    public static RedissonClientX getInstance() {
        if(redissonClientX == null) {
            redissonClientX = new RedissonClientX();
        }
        return redissonClientX;
    }

    public RedissonClient getRedissonClient() {
        return redissonClient;
    }
}
