package com.wucy.client.control;

import com.wucy.client.dao.JedisDao;
import com.wucy.client.entity.Jedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wucy on 2017/6/15.
 */

@RestController
@RefreshScope //从Git服务刷新配置
@RequestMapping(value = "/jedisApp")
public class JedisAppControl {

    @Autowired
    private JedisDao jedisDao;


    @Value("${jedis.ip}")
    private String jedisIp;

    @Value("${jedis.port}")
    private String jedisPort;

    @GetMapping(value = "/jedisHello")
    public String jedisHello(){

        return  "jedisIp:" + jedisIp + "||" + "jedisPort：" + jedisPort;

    }

    @GetMapping(value = "/jedis/{id}")
    public Jedis getJedisById(@PathVariable Integer id){
        return jedisDao.findOne(id);

    }


    @PostMapping(value = "getJedis")
    public List<Jedis> getJedis(){


        return  jedisDao.findAll();
    }


}
