package com.eastspider.sct.service;

import com.alibaba.fastjson.JSONObject;
import com.eastspider.sct.client.RedissonClientX;
import com.eastspider.sct.dao.UserMapper;
import com.eastspider.sct.dao.po.User;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

@RestController
@EnableDiscoveryClient
public class UserService {

    @Autowired
    DiscoveryClient client;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value="/user/{id}", method= RequestMethod.GET)
    public Object get(@PathVariable("id")Integer id) {
        RedissonClientX redissonClientX =  RedissonClientX.getInstance();
        RedissonClient redissonClient = redissonClientX.getRedissonClient();

        JSONObject jsonObject = new JSONObject();

        RLock rLock = redissonClient.getLock("user-" + id);;

        try {
            System.out.println("当前时间---->" + System.currentTimeMillis());
            if(rLock.tryLock(0, 2, TimeUnit.SECONDS)) {
                User user = userMapper.selectById(id);
                ServiceInstance localInstance = client.getLocalServiceInstance();

                jsonObject.put("user", user);
                jsonObject.put("serviceId", localInstance.getServiceId());
                jsonObject.put("host", localInstance.getHost());
                jsonObject.put("port", localInstance.getPort());
            }
            System.out.println("当前时间---->" + System.currentTimeMillis());
        }catch(InterruptedException e) {
            e.printStackTrace();
        }finally {
            rLock.unlock();
        }
        return jsonObject;
    }
}
