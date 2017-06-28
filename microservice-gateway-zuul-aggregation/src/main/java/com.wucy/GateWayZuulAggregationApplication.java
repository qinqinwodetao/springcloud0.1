package com.wucy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wucy on 2017/6/15.
 */


@SpringBootApplication
@EnableZuulProxy //声明zuul代理
public class GateWayZuulAggregationApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayZuulAggregationApplication.class,args);
    }



    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
