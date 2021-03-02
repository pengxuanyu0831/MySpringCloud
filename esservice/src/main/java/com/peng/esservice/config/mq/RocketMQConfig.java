package com.peng.esservice.config.mq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @program MySpringCloud
 * @description:
 * @author: pengxuanyu
 * @create: 2021/03/02 20:56
 */

@Component
public class RocketMQConfig {
    Logger logger = LoggerFactory.getLogger(RocketMQConfig.class);

    @Autowired
    private RocketMqProperties rocketMqProperties;

    // 初始化生产者
    @Bean
    public DefaultMQProducer defaultMQProducer()throws Exception{
        // 实例化生产者
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer(MqConstant.ConsumeGroup.ES_USER_IMPORT);
        // 设置nameServer地址
        defaultMQProducer.setNamesrvAddr(rocketMqProperties.getNamesrvAddr());
        defaultMQProducer.setSendMsgTimeout(rocketMqProperties.getSendMsgTimeoutMillis());
        defaultMQProducer.setRetryTimesWhenSendFailed(rocketMqProperties.getReconsumeTimes());
        defaultMQProducer.start();
        return defaultMQProducer;
    }


}
