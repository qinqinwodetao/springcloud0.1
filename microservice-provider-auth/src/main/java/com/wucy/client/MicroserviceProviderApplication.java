package com.wucy.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by wucy on 2017/6/15.
 */


@SpringBootApplication
@EnableEurekaClient
public class MicroserviceProviderApplication {


    public static void main(String[] args) {
        SpringApplication.run(MicroserviceProviderApplication.class,args);


    }


}
