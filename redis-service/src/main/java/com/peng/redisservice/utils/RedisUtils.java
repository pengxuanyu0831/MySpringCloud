package com.peng.redisservice.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

/**
 * @program MySpringCloud
 * @description:
 * @author: pengxuanyu
 * @create: 2021/03/13 16:49
 */

@Component
@Slf4j
public class RedisUtils {
    @Autowired
    private JedisPool jedisPool;

    // 通过key 获取 value
    public String get(String key,int indexdb){
        Jedis jedis = null;
        String value = null;
        try{
            jedis = jedisPool.getResource();
            jedis.select(indexdb);
            value = jedis.get(key);
            log.info(value);
        }catch (Exception e){
            log.info(e.getMessage());
        }finally {
            returnResource(jedisPool, jedis);
        }
        return value;
    }

    public String set(String key,String value,int indexdb){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            jedis.select(indexdb);
            return jedis.set(key, value);
        }catch (Exception e){
            log.info("报错内容为："+e.getMessage());
            return "0";
        }finally {
            returnResource(jedisPool,jedis);
        }
    }

    public static void returnResource(JedisPool jedisPool ,Jedis jedis){
        if(jedis != null){
            jedisPool.getResource();
        }
    }

    public long expire(String key,int value,int indexdb){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            jedis.select(indexdb);
            return jedis.expire(key,value);
        }catch (Exception e){
            log.info(e.getMessage());
            return 0L;
        }finally {
            returnResource(jedisPool,jedis);
        }

    }
}
