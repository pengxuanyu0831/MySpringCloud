package com.peng.redisservice.controller;

import com.peng.redisservice.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program MySpringCloud
 * @description:
 * @author: pengxuanyu
 * @create: 2021/03/13 17:04
 */
@Slf4j
@Controller
@RequestMapping(value = "/redis")
public class RedisController {
    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping(value = "/getRedis",method = RequestMethod.POST)
    @ResponseBody
    public String getRedis(){
        // redisUtils.set("00001","姓名:pengxuanyu 性别:男",0);
        String res = redisUtils.get("0001",0);
        return res;
    }
    @RequestMapping(value = "setRedis",method = RequestMethod.POST)
    public void setRedis(){
        redisUtils.set("1111", "2222", 0);
        Long reExpire = redisUtils.expire("1111", 60, 0);
        log.info("过期时间设置成功!");
        log.info("set 成功!!");
    }

}
