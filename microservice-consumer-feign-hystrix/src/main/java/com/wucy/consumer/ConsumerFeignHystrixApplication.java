package com.wucy.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by wucy on 2017/6/15.
 */


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker  //hystrix.stream  api监控数据
public class ConsumerFeignHystrixApplication {


    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignHystrixApplication.class,args);


    }


}
