package com.yqy.smartpage.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @program: smartpage-springboot
 * @description:
 * @author: Mr.Yqy
 * @create: 2019-05-08 18:57
 **/
@Component
@Aspect
public class LogAop {

    @Pointcut("execution(public * com.yqy.smartpage.Controller.FileController.*(..))")
    public void log(){}

    @Before("log()")
    public void DoBefore(JoinPoint joinPoint){
        System.out.println("收到ocr请求");
    }

}
