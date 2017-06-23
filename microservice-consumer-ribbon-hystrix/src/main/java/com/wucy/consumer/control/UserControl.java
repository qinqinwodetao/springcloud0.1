package com.wucy.consumer.control;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.wucy.consumer.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
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
//@RibbonClient(name = "microservice-provider")
public class UserControl extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserControl.class);


    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @Autowired
    private RestTemplate restTemplate;


    @GetMapping(value = "/{id}")
    @HystrixCommand(fallbackMethod = "getUserByIdFallback")
    public User getUserById(@PathVariable Integer id){

       //return this.restTemplate().getForObject("http://microservice-provider/user/" + id, User.class);
        return restTemplate.getForObject("http://microservice-provider/user/" + id, User.class);
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




    public User getUserByIdFallback(@PathVariable Integer id){
        User user = new User();
        user.setId(-1);
        user.setUserName("fallback");
        user.setPassword("88888888");

        logger.error("getUserByIdFallback error & id is " + id );
        return user;
    }





}
