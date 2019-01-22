package com.eastspider.sct;

import com.alibaba.dubbo.config.annotation.Reference;
import com.eastspider.sct.api.SendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
public class DubboConsumerBootstrap {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference
    private SendService sendService;

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            logger.info(sendService.sendMessage("mercyblitz"));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerBootstrap.class).close();
    }
}
