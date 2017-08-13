package com.zhihao.miao.filter;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @Auther : 苗志浩 (zhihao.miao@ele.me)
 * @Date :2017/8/8
 * @since 1.0
 */
public class DidiFilterProcessor extends FilterProcessor{

    @Override
    public Object processZuulFilter(ZuulFilter filter) throws ZuulException {
        try{
            return super.processZuulFilter(filter);
        }catch (ZuulException e){
            RequestContext requestContext = RequestContext.getCurrentContext();
            requestContext.set("failed.filter",filter);
            throw e;
        }
    }
}
