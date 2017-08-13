package com.zhihao.miao.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther : 苗志浩 (zhihao.miao@ele.me)
 * @Date :2017/8/6
 * @since 1.0
 */
@Controller
public class UserController2 {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/testRedirect")
    public String testRedirect(){
        logger.info("user2 testRedirect");
        return "redirect:hello.html";
    }
}
