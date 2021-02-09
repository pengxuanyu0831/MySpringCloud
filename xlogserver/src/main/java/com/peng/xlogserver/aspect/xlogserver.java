package com.peng.xlogserver.aspect;


import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD}) // 用在方法上
@Retention(RetentionPolicy.RUNTIME)  // 运行时
public @interface xlogserver {
    String description() default "";
}
