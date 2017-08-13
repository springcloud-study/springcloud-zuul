package com.zhihao.miao.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * @Auther : 苗志浩 (zhihao.miao@ele.me)
 * @Date :2017/8/8
 * @since 1.0
 */
@Component
public class ThrowExceptionFilter extends ZuulFilter{

    private static Logger logger = LoggerFactory.getLogger(ThrowExceptionFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /*
    @Override
    public Object run() {
        logger.info("this is a pre filter,it will throw a RuntimeException");
        RequestContext context = RequestContext.getCurrentContext();
        try{
            doSomething();
        }catch (Exception e){
            context.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            context.set("error.message",e.getMessage());
        }

        return null;
    }
    */

    @Override
    public Object run() {
        logger.info("this is a pre filter,it will throw a RuntimeException");
        doSomething();
        return null;
    }

    private void doSomething(){
        throw new RuntimeException("exist some errors....");
    }
}
