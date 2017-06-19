package com.wucy.consumer.control;

import com.wucy.consumer.entity.User;
import com.wucy.consumer.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wucy on 2017/6/16.
 */
@RestController
@RequestMapping(value = "/user")
public class UserControl {

    @Autowired
    private UserFeignClient userFeignClient;


    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable Integer id){
        return userFeignClient.findUserById(id);
    }


    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

}
