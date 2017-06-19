package com.wucy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by wucy on 2017/5/26.
 */
@SpringBootApplication
@EnableEurekaServer
public class ApplicationEurekaServer {

    public static void main(String[] args) {

        SpringApplication.run(ApplicationEurekaServer.class , args);


    }


}
