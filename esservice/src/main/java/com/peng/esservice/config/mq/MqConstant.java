package com.peng.esservice.config.mq;

/**
 * @program MySpringCloud
 * @description:
 * @author: pengxuanyu
 * @create: 2021/03/02 21:02
 */
public class MqConstant {

    public static class Topic{
        // 主题
        public static final String ES_USER_IMPORT = "ES_USER_IMPORT";
    }

    public static class Tag{
        public static final String ES_USER_IMPORT_TAG_INSERT = "ES_USER_IMPORT_TAG_INSERT";
        public static final String ES_USER_IMPORT_TAG_UPDATE = "ES_USER_IMPORT_TAG_UPDATE";
        public static final String ES_USER_IMPORT_TAG_DELETE = "ES_USER_IMPORT_TAG_DELETE";
    }

    public static class ConsumeGroup{
        public static final String ES_USER_IMPORT = "GID_ES_USER_IMPORT";
    }
}
