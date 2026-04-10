package ru.diasoft.example.aspect;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Around("@annotation (ru.diasoft.example.aspect.annotation.Loggable)")
    public Object logAround(ProceedingJoinPoint joinPoint)
            throws Throwable
    {
        logger.info("Логгирование метода: " + joinPoint.getSignature().getName());
        logger.info("Входные параметры: " + Arrays.asList(joinPoint.getArgs()));

        Object res = joinPoint.proceed();

        logger.info("Результат работы метода: " + joinPoint.getSignature().getName() + ": " + res);
        return res;
    }

    @AfterThrowing(
            pointcut = "@annotation (ru.diasoft.example.aspect.annotation.Loggable)",
            throwing = "error"
    )
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        logger.error("Ошибка работы метода: " + joinPoint.getSignature().getName() + ": " + error.toString());
    }

}
