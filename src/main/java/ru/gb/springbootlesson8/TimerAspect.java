package ru.gb.springbootlesson8;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimerAspect {

    private static final Logger logger = LoggerFactory.getLogger(TimerAspect.class);

    @Around("@annotation(timer)")
    public Object measureTime(ProceedingJoinPoint joinPoint, Timer timer) throws Throwable {
        long startTime = System.nanoTime();

        Object result = joinPoint.proceed();

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds

        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        logger.info(className + " - " + methodName + " #(" + duration + " milliseconds)");

        return result;
    }
}