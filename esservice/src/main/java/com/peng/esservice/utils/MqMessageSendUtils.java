package com.peng.esservice.utils;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program MySpringCloud
 * @description:
 * @author: pengxuanyu
 * @create: 2021/03/02 21:49
 */

@Slf4j
@Component
public class MqMessageSendUtils {

    @Autowired
    private DefaultMQProducer producer;

    public <T> boolean sendNormalMessage(String topic,String tag, T messagebody){
        Message message = new Message(topic, tag, JSON.toJSONBytes(messagebody) );
        try{
            SendResult result = producer.send(message);
            if(result != null){
                log.info("mq 消息发送成功" + result);
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            log.warn("mq发送消息失败",e);
            return false;
        }
    }

    public <T> boolean sendNormalMessage(String topic,String tag, T messagebody,long delay){
        Message message = new Message(topic,tag ,JSON.toJSONBytes(messagebody) );
        message.setDelayTimeLevel(3);
        try{
            SendResult result = producer.send(message);
            if(result != null){
                log.info("延时消息发送成功" + result);
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            log.warn("延时消息发送失败" ,e);
            return false;
        }
    }
}
