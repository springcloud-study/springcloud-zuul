package com.zhihao.miao.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther : 苗志浩 (zhihao.miao@ele.me)
 * @Date :2017/8/9
 * @since 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public String ArithmeticHandler(Exception e){
        return "global error " + e.getClass().getName();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String error(Exception e){
        return "global error" + e.getMessage();
    }
}
