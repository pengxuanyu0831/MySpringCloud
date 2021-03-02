package com.peng.esservice.config.mq;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program MySpringCloud
 * @description:
 * @author: pengxuanyu
 * @create: 2021/03/02 20:57
 */


@Data
@Component
@ConfigurationProperties(prefix = "rocketmq")
public class RocketMqProperties {
    private String namesrvAddr;
    private Integer sendMsgTimeoutMillis;
    // 失败重试次数
    private Integer reconsumeTimes;
}
