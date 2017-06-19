package test;


import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis 测试
 * Created by wucy on 2017/6/13.
 */
public class JedisDemo1 {

    private static final Logger log = LoggerFactory.getLogger(JedisDemo1.class);


    @Test
    public void jedisConnectingTest(){
        Jedis jedis = new Jedis("127.0.0.1",6379);

        jedis.set("name","123");

        String value = jedis.get("name").toString();
        log.info("jedisConnectingTest value={}",value);

        Assert.assertEquals("123",value);

        jedis.close();

    }


    @Test
    public void jedisPoolTest(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(0);

        JedisPool jedisPool = new JedisPool("127.0.0.1",6379);

        Jedis jedis = null;

        jedis = jedisPool.getResource();

        System.out.println( jedis.hgetAll("1111"));
        jedis.set("name","123");

        String value = jedis.get("name").toString();


        System.out.println(value);
        Assert.assertEquals("123",value);


    }



}
