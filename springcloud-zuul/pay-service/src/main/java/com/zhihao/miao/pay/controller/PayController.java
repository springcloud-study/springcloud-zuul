package com.zhihao.miao.pay.controller;


import com.zhihao.miao.pay.bean.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/pay")
public class PayController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/index")
    private String index(){
        return "pay index";
    }

    @PostMapping("/payOrder")
    private String payOrder(@RequestBody Order order){
        logger.info("payOrder方法被调用"+order);
        return "pay success";
    }

}
