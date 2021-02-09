package com.peng.xlogserver.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @program MySpringCloud
 * @description:
 * @author: pengxuanyu
 * @create: 2021/02/09 14:54
 */


@Aspect
@Component
public class XLogServerAspect {
    @Pointcut("@annotation(com.peng.xlogserver.aspect.xlogserver)")
    public void xlogserver(){}

    @Around("xlogserver()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("-----使用了@Around 注解-----");
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        System.out.println("use args :" + result.toString());
        System.out.println("总耗时 :" + (System.currentTimeMillis() - startTime) + "秒");
        return result;
    }

    @After("xlogserver()")
    public void doAfter(){
        System.out.println("----结束！----");
    }
}
