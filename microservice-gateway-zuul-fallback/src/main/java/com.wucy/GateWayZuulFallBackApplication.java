package com.wucy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by wucy on 2017/6/15.
 */


@SpringBootApplication
@EnableZuulProxy //声明zuul代理
public class GateWayZuulFallBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayZuulFallBackApplication.class,args);
    }


}
