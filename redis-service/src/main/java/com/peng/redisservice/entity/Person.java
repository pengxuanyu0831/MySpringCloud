package com.peng.redisservice.entity;

import lombok.*;

/**
 * @program MySpringCloud
 * @description:
 * @author: pengxuanyu
 * @create: 2021/03/01 09:38
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private long id;
    private String name;
    private Integer age;
    private String sex;


}
