package com.litvak.mystore_lesson1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Aspect
@Component
public class Logger {

    public static List<String> loggerInfo = Collections.synchronizedList(new ArrayList<>());

    @Pointcut("execution(* com.litvak.mystore_lesson1.controllers..*.*(..))")
    private void logger() {
    }

    @Before("logger()")
    public void logBefore(JoinPoint joinPoint) {
        LocalDateTime localNow = LocalDateTime.now();
        ZonedDateTime zonedUTC = localNow.atZone(ZoneId.of("UTC"));
        ZonedDateTime zonedIST = zonedUTC.withZoneSameInstant(ZoneId.of("Europe/Moscow"));
        loggerInfo.add("[" + LocalDate.now() + " " +
                zonedIST.truncatedTo(ChronoUnit.SECONDS) + "] Before: " + joinPoint.getSignature());
    }

    @AfterReturning("logger()")
    public void logAfterReturning(JoinPoint joinPoint) {
        LocalDateTime localNow = LocalDateTime.now();
        ZonedDateTime zonedUTC = localNow.atZone(ZoneId.of("UTC"));
        ZonedDateTime zonedIST = zonedUTC.withZoneSameInstant(ZoneId.of("Europe/Moscow"));
        loggerInfo.add("[" + LocalDate.now() + " " +
                zonedIST.truncatedTo(ChronoUnit.SECONDS) + "] AfterReturning: " + joinPoint.getSignature());
    }

    @AfterThrowing("logger()")
    public void logAfterThrowing(JoinPoint joinPoint) {
        LocalDateTime localNow = LocalDateTime.now();
        ZonedDateTime zonedUTC = localNow.atZone(ZoneId.of("UTC"));
        ZonedDateTime zonedIST = zonedUTC.withZoneSameInstant(ZoneId.of("Europe/Moscow"));
        loggerInfo.add("[" + LocalDate.now() + " " +
                zonedIST.truncatedTo(ChronoUnit.SECONDS) + "] AfterThrowing: " + joinPoint.getSignature());
    }

    @Around("logger()")
    public Object logAround(ProceedingJoinPoint pjp) {
        LocalDateTime localNow = LocalDateTime.now();
        ZonedDateTime zonedUTC = localNow.atZone(ZoneId.of("UTC"));
        ZonedDateTime zonedIST = zonedUTC.withZoneSameInstant(ZoneId.of("Europe/Moscow"));
        Object value;
        loggerInfo.add("[" + LocalDate.now() + " " +
                zonedIST.truncatedTo(ChronoUnit.SECONDS) + "] Around before: " + pjp.getSignature());
        try {
            value = pjp.proceed();
            loggerInfo.add("[" + LocalDate.now() + " " +
                    zonedIST.truncatedTo(ChronoUnit.SECONDS) + "] Around: " + pjp.getSignature());
        } catch (Throwable t) {
            loggerInfo.add("[" + LocalDate.now() + " " +
                    zonedIST.truncatedTo(ChronoUnit.SECONDS) + "] Around with Error: " + pjp.getSignature());
            return null;
        }
        loggerInfo.add("[" + LocalDate.now() + " " +
                zonedIST.truncatedTo(ChronoUnit.SECONDS) + "] Around after: " + pjp.getSignature());
        return value;
    }
}
