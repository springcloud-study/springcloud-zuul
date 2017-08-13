package com.zhihao.miao.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Auther : 苗志浩 (zhihao.miao@ele.me)
 * @Date :2017/8/12
 * @since 1.0
 */

//@Component
public class DefaultRedirectFilter extends ZuulFilter {

   private Logger log = LoggerFactory.getLogger(getClass());


    @Value("${zuul.defaultRoute}")
    private String defaultRoute;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    // only run if we have a default route defined and we are on the default
    @Override
    public boolean shouldFilter() {
        String requestURI = RequestContext.getCurrentContext().getRequest().getRequestURI();
        if (log.isDebugEnabled()) {
            log.debug("defaultRoute=" + defaultRoute);
            log.debug("requestURI=" + requestURI);
        }

        return defaultRoute != null && requestURI.startsWith("/") && requestURI.endsWith(".html");
    }

    @Override
    public Object run() {
        if (log.isDebugEnabled()) {
            log.debug("DefaultRedirectFilter: sending redirect " + defaultRoute);
        }
        try {
            String requestURI = RequestContext.getCurrentContext().getRequest().getRequestURI();
            requestURI = defaultRoute+"/"+requestURI;
            RequestContext.getCurrentContext().getResponse().sendRedirect(requestURI);
        } catch (java.io.IOException e) {
            // not sure what to do
            if (log.isDebugEnabled()) {
                log.debug("run: IOException on sendRedirect() " + e);
            }
        }
        //if (HTTPRequestUtils.getInstance().getQueryParams() == null) {
        //    RequestContext.getCurrentContext().setRequestQueryParams(new HashMap<String, List<String>>());
        //}
        return null;
    }
}
