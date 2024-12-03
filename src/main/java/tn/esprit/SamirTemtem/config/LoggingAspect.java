package tn.esprit.SamirTemtem.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("execution (* tn.esprit.SamirTemtem.Services.*.*(..))")
    public void methodCall() {}

    @Before("methodCall()")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        String params = Arrays.toString(joinPoint.getArgs());

        log.info("In method " + name + " : " + params);

    }
    @After("methodCall() ")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();

        String params = Arrays.toString(joinPoint.getArgs());

        log.info("Out of method " + name + " : " + params);
    }
    @AfterReturning("methodCall()")
    public void logMethodExitReturn(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();

        String params = Arrays.toString(joinPoint.getArgs());

        log.info("AfterReturning of method " + name + " : " + params);
    }

    @AfterThrowing(pointcut="methodCall()", throwing="nameEx")
    public void logMethodExitThrowing(JoinPoint joinPoint, Throwable nameEx) {
        String name = joinPoint.getSignature().getName();

        String params = Arrays.toString(joinPoint.getArgs());

        log.info("AfterThrowing of method " + name + " : " + params);
        log.error(nameEx.getMessage());
    }
}
