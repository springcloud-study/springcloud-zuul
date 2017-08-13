package com.zhihao.miao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther : 苗志浩 (zhihao.miao@ele.me)
 * @Date :2017/8/6
 * @since 1.0
 */
@RestController
public class HelloController {

    @RequestMapping("/local/hello")
    public String hello(){
        return "hello world local";
    }
}
