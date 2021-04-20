package com.peng.base.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

/**
 * @program MySpringCloud
 * @description:
 * @author: pengxuanyu
 * @create: 2021/04/20 22:14
 */

@Slf4j
@Service
public class RedisUtils {
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;


    ValueOperations<Object, Object> stringOps;
    ListOperations<Object, Object> listOps;
    SetOperations<Object, Object> setOps;
    ZSetOperations<Object, Object> zSetOps;
    HashOperations<Object, Object, Object> hashOps;
}
