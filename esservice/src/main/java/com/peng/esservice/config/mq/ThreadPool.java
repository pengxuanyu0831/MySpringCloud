package com.peng.esservice.config.mq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @program MySpringCloud
 * @description:
 * @author: pengxuanyu
 * @create: 2021/03/17 10:22
 */

@Configuration
public class ThreadPool implements AsyncConfigurer {
    @Override
    @Bean
    public Executor getAsyncExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(32);
        taskExecutor.setMaxPoolSize(500);
        taskExecutor.setQueueCapacity(500);
        taskExecutor.setThreadNamePrefix("Thread-Executor: ");
        taskExecutor.setKeepAliveSeconds(30000);
        taskExecutor.initialize();
        return taskExecutor;
    }
}
