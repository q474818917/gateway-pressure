package com.eastspider.sct.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.eastspider.sct.api.SendService;

@Service
public class SendServiceImpl implements SendService {

    @Override
    public String sendMessage(String message) {
        return message;
    }
}
