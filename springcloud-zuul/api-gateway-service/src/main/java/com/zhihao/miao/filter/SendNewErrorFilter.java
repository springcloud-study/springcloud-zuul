package com.zhihao.miao.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Auther : 苗志浩 (zhihao.miao@ele.me)
 * @Date :2017/8/14
 * @since 1.0
 */
//@Component
public class SendNewErrorFilter extends ZuulFilter{

    private Logger log = LoggerFactory.getLogger(getClass());

    protected static final String SEND_ERROR_FILTER_RAN = "sendErrorFilter.ran";

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
        RequestContext ctx = RequestContext.getCurrentContext();
        // only forward to errorPath if it hasn't been forwarded to already
        return ctx.containsKey("error.status_code")
                && !ctx.getBoolean(SEND_ERROR_FILTER_RAN, false);
    }

    @Override
    public Object run() {
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            HttpServletRequest request = ctx.getRequest();

            HttpServletResponse servletResponse = ctx.getResponse();
            servletResponse.setCharacterEncoding("UTF-8");
            OutputStream outStream = servletResponse.getOutputStream();
            String errormessage = "error,try again later!!";
            InputStream is = new ByteArrayInputStream(errormessage.getBytes(servletResponse.getCharacterEncoding()));
            writeResponse(is,outStream);
        }
        catch (Exception ex) {
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }

    private void writeResponse(InputStream zin, OutputStream out) throws Exception {
        byte[] bytes = new byte[1024];
        int bytesRead = -1;
        while ((bytesRead = zin.read(bytes)) != -1) {
            out.write(bytes, 0, bytesRead);
        }
    }
}
