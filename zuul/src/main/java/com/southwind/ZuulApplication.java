package com.southwind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;


@EnableZuulProxy  //包含了@EnableZuulServer 设置该类是网关启动类
@EnableAutoConfiguration
public class ZuulApplication {

    public static void main(String []args){
        SpringApplication.run(ZuulApplication.class,args);
    }

}
