package com.hand.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.hand.girl.controller.GirlController.*(..))")
    public void log(){
    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
         HttpServletRequest request = attributes.getRequest();
         logger.info("url={}",request.getRequestURL());
         logger.info("mothod={}",request.getMethod());
         logger.info("ip={}",request.getLocalAddr());
         logger.info("prama={}",joinPoint.getArgs());
         logger.info("class_mothod={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());



    }
    @After("log()")
    public void doAfter(){
        logger.info("654321");
    }

    @AfterReturning(returning ="object",pointcut = "log()")
    public void returndata(Object object){
        logger.info("reponse={}",object);
    }
}
