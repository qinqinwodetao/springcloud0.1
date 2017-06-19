package com.wucy.consumer.service;

import com.wucy.consumer.configuration.FeignConfiguration;
import com.wucy.consumer.entity.User;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wucy on 2017/6/16.
 */
@FeignClient(name = "MICROSERVICE-PROVIDER" , configuration = FeignConfiguration.class)
public interface UserFeignClient {

    // @RequestMapping(value = "/user/{id}")
    @RequestLine("GET /user/{id}")
    User findUserById(@PathVariable("id") Integer id);
}
