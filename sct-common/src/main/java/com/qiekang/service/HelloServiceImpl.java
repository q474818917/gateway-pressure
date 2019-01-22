package com.qiekang.service;

import org.springframework.stereotype.Service;

import com.qiekang.facade.HelloService;

@Service("helloService")
public class HelloServiceImpl implements HelloService {

	@Override
	public String replyName(String name) {
		return name;
	}

}
