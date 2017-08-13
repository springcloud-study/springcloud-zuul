package com.zhihao.miao.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther : 苗志浩 (zhihao.miao@ele.me)
 * @Date :2017/8/5
 * @since 1.0
 */
public class AccessFilter extends ZuulFilter{

    private Logger logger = LoggerFactory.getLogger(getClass());

    //过滤器的类型，它决定过滤器在请求的哪个生命周期中执行，这里定义为pre，代表会在请求被理由之前执行。
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行
    @Override
    public int filterOrder() {
        return 0;
    }

    //判断该过滤器是否需要被执行。这里我们直接返回了true，因此该过滤器对所有的请求都生效。实际运行中我们可以利用该函数
    //来指定过滤器的有效范围。
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器的具体执行逻辑。
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info("send {} request to {}",request.getMethod(),request.getRequestURI().toString());

        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null){
            logger.warn("access token is empty");
            ctx.setSendZuulResponse(false); //令zuul过滤该请求，不对其进行路由
            ctx.setResponseStatusCode(401); //设置返回的错误码
        }

        logger.info("access token ok");
        return null;
    }


}
