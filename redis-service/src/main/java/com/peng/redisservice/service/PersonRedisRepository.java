package com.peng.redisservice.service;

import com.peng.redisservice.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/**
 * @program MySpringCloud
 * @description:
 * @author: pengxuanyu
 * @create: 2021/02/28 23:02
 */
public class PersonRedisRepository {
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @SuppressWarnings({"SpringJavaInjectionPointsAutowiringInspection","WeakerAccess"})
    @Resource(name = "redisTemplate")
    ValueOperations<Object,Object> valueOperations;

    public void saveInfo(Person person){
        valueOperations.set(person.getId(),person);
    }

    public Person getInfo(){
        return (Person) valueOperations.get("1");
    }


}
