package com.zhihao.miao.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

/**
 * @Auther : 苗志浩 (zhihao.miao@ele.me)
 * @Date :2017/8/8
 * @since 1.0
 */
@Component
public class ErrorExtFilter extends SendErrorFilter{

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 30; //大于ErrorFilter的值
    }


    //只处理post过滤器抛出异常的过滤器
    @Override
    public boolean shouldFilter() {
        //判断，仅处理来自post过滤器引起的异常
        RequestContext context = RequestContext.getCurrentContext();
        ZuulFilter failedFilter =(ZuulFilter)context.get("failed.filter");
        if(failedFilter != null && failedFilter.filterType().equals("post")){
            return true;
        }

        return false;

    }
}
