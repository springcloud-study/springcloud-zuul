package com.zhihao.miao.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * @Auther : 苗志浩 (zhihao.miao@ele.me)
 * @Date :2017/8/14
 * @since 1.0
 */
//@Component
public class ErrorFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        Throwable throwable = context.getThrowable();
        logger.error("this is a ErrorFilter：{}",throwable.getCause().getMessage());
        context.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        context.set("error.message",throwable.getCause().getMessage());
        return null;
    }
}
