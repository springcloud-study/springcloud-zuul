package com.zhihao.miao;

import com.netflix.zuul.FilterProcessor;
import com.zhihao.miao.exception.DidiErrorAttributes;
import com.zhihao.miao.filter.AccessFilter;
import com.zhihao.miao.filter.DidiFilterProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

//使用@EnableZuulProxy注解开启zuul的api网关服务功能
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {
    public static void main(String[] args) {
        FilterProcessor.setProcessor(new DidiFilterProcessor());
        SpringApplication.run(ZuulApplication.class,args);
    }

//    @Bean
//    public AccessFilter accessFilter(){
//        return new AccessFilter();
//    }

//    @Bean
//    public PatternServiceRouteMapper serviceRouteMapper(){
//        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)","${version}/${name}");
//    }

//    @Bean
//    public DefaultErrorAttributes errorAttributes(){
//        return new DidiErrorAttributes();
//    }

}
