package com.eastspider.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

    @GetMapping("/api/test")
    public String sayHello(HttpServletRequest request){
        return "hello world";
    }
}