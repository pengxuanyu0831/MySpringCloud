package com.peng.redisservice.controller;

import com.peng.redisservice.entity.Person;
import com.peng.redisservice.service.PersonRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program MySpringCloud
 * @description:
 * @author: pengxuanyu
 * @create: 2021/02/28 23:01
 */
public class PersonController {
    @Autowired
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    PersonRedisRepository personRedisRepository;

    @RequestMapping("/setInfo")
    public void setInfo(){
        Person person = Person.builder()
                .id(1L)
                .name("张三")
                .age(33)
                .sex("nan")
                .build();
        personRedisRepository.saveInfo(person);
    }

    @RequestMapping("getInfo")
    public Person getInfo(){
        return personRedisRepository.getInfo();
    }
}
