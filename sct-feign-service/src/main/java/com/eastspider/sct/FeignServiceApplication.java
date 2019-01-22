package com.eastspider.sct;

import com.eastspider.sct.dao.UserMapper;
import com.eastspider.sct.dao.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class FeignServiceApplication {

    @Autowired
    DiscoveryClient client;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public String hello() {
        User user = userMapper.selectById(1);
        ServiceInstance localInstance = client.getLocalServiceInstance();
        return "Hello World: "+ localInstance.getServiceId()+":"+localInstance.getHost()+":"+localInstance.getPort();
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignServiceApplication.class, args);
    }

}
