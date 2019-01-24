package com.eastspider.sct.client;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

public class DistributedRedisLock {

    public static void main(String args[]) {
        redisLock();
    }

    private static void redisLock(){
        RedissonManager.init(); //初始化
        RedissonClient redissonClient = RedissonManager.getRedisson();
        String key = "redisLock_test123";
        RLock mylock = redissonClient.getLock(key);
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        mylock.lock(1, TimeUnit.MINUTES);
                        System.err.println("======lock======"+Thread.currentThread().getName());
                        Thread.sleep(1000); //获得锁之后可以进行相应的处理
                        System.err.println("======获得锁后进行相应的操作======");
                        System.err.println("======unlock======"+Thread.currentThread().getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        mylock.unlock();
                    }
                }
            });
            t.start();
        }
    }
}