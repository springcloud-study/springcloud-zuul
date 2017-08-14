package com.zhihao.miao.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String index(){
       logger.info("user index");
       return "user index";
    }

    @GetMapping("/home")
    public String home(){
        logger.info("user home");
        return "user home";
    }

    public String index2(){
        logger.info("user index2");
        throw new NullPointerException("空指针异常");
    }

    @GetMapping("/sidecar")
    public String sidecar(){
        String response = restTemplate.getForObject("http://zuul-sidecar/",String.class);
        return response;
    }
}
