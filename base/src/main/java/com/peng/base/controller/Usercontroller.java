package com.peng.base.controller;

import com.peng.base.mapper.UserMapper;
import com.peng.base.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @program MySpringCloud
 * @description:
 * @author: pengxuanyu
 * @create: 2021/04/13 21:11
 */
@RestController
@RequestMapping("/peng")
@EnableAutoConfiguration
public class Usercontroller {

    @Autowired
    UserMapper userMapper;



    @RequestMapping(value = "/select")
    public List<UserVo> select(String userId){
        List list = new LinkedList();
        list.add("1");
        list.add("2");
        //return userMapper.seletByUserId("1");
        return list;
    }


    //@GetMapping("/fileOpen")
    public static void  fileOpen(){
        Properties properties = new Properties();
        try{
            properties = PropertiesLoaderUtils.loadAllProperties("question.properties");
            for(Object key:properties.entrySet()){
                System.out.println(key);
                System.out.println(properties.get(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        fileOpen();
    }
}
