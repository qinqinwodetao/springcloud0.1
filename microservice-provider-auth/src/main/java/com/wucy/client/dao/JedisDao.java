package com.wucy.client.dao;

import com.wucy.client.entity.Jedis;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wucy on 2017/6/15.
 */
public interface JedisDao extends JpaRepository<Jedis,Integer> {


}
