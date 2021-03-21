package com.peng.esservice.service;

import com.peng.esservice.config.mq.MqConstant;
import com.peng.esservice.config.mq.ThreadPool;
import com.peng.esservice.dao.EsUserDao;
import com.peng.esservice.entity.EsUserEntity;
import com.peng.esservice.utils.MqMessageSendUtils;
import org.apache.rocketmq.common.ThreadFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.*;

/**
 * @program MySpringCloud
 * @description:
 * @author: pengxuanyu
 * @create: 2021/03/02 21:13
 */

@Service
public class EsUserService {
    @Autowired
    public EsUserDao esUserDao;

    @Autowired
    public MqMessageSendUtils mqMessageSendUtils;

    @Autowired
    private ThreadPool threadPoolExecutor;

    @Transactional(rollbackFor = Exception.class)
    public Integer importEsUsers(EsUserEntity userEntity){
        // 导入mysql
        int insert = esUserDao.insert(userEntity);
        if(insert > 0){
            //
            boolean result = mqMessageSendUtils.sendNormalMessage(MqConstant.Topic.ES_USER_IMPORT,MqConstant.Tag.ES_USER_IMPORT_TAG_INSERT,userEntity);
            if(result){
                return userEntity.getId();
            }
        }

        return null;
    }

}
