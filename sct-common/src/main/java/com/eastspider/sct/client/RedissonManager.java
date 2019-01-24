package com.eastspider.sct.client;

import org.redisson.Redisson;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;

public class RedissonManager {

    private static final String RAtomicName = "genId_";

    private static Config config = new Config();
    private static RedissonClient redissonClient = null;

    public static void init(){
        try {
            Config config = new Config();
            config.useSingleServer().setAddress("redis://127.0.0.1:6379");
            redissonClient = Redisson.create(config);
            //清空自增的ID数字
            RAtomicLong atomicLong = redissonClient.getAtomicLong(RAtomicName);
            atomicLong.set(1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static RedissonClient getRedisson(){
        return redissonClient;
    }

    /** 获取redis中的原子ID */
    public static Long nextID(){
        RAtomicLong atomicLong = getRedisson().getAtomicLong(RAtomicName);
        atomicLong.incrementAndGet();
        return atomicLong.get();
    }
}