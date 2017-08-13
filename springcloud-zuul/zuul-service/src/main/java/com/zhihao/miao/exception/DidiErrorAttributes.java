package com.zhihao.miao.exception;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * @Auther : 苗志浩 (zhihao.miao@ele.me)
 * @Date :2017/8/9
 * @since 1.0
 */
public class DidiErrorAttributes extends DefaultErrorAttributes{


    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String,Object> result = super.getErrorAttributes(requestAttributes,includeStackTrace);
        result.put("error","missing error");
        return result;
    }
}
