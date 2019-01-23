package com.eastspider.sct.service;

import com.alibaba.fastjson.JSONObject;
import com.eastspider.sct.dao.UserMapper;
import com.eastspider.sct.dao.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableDiscoveryClient
public class UserService {

    @Autowired
    DiscoveryClient client;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value="/user/{id}", method= RequestMethod.GET)
    public Object get(@PathVariable("id")Integer id) {
        User user = userMapper.selectById(id);
        ServiceInstance localInstance = client.getLocalServiceInstance();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user", user);
        jsonObject.put("serviceId", localInstance.getServiceId());
        jsonObject.put("host", localInstance.getHost());
        jsonObject.put("port", localInstance.getPort());

        return jsonObject;
    }
}
