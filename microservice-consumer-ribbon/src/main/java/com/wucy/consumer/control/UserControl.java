package com.wucy.consumer.control;

import com.wucy.consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wucy on 2017/6/16.
 */
@RestController
@RequestMapping(value = "/user")
public class UserControl {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable Integer id){

        return this.restTemplate().getForObject("http://MICROSERVICE-PROVIDER/user/" + id, User.class);
    }


    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }


    /**
     *
     * @return
     */
    @GetMapping(value = "/getServiceInstance")
    public ServiceInstance getServiceInstance(){
        return loadBalancerClient.choose("MICROSERVICE-PROVIDER");
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }

}
