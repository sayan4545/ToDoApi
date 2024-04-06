package org.example.todorestapi;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class TimeMonitorClass {

    @Around("@annotation(TimeMonitor)")
    public void loggingTime(ProceedingJoinPoint joinPoint) {

        long start = System.currentTimeMillis();
        try{
            joinPoint.proceed();
        }catch (Throwable e){
            System.out.println("Something went wrong");
        }finally{
            long end = System.currentTimeMillis();
            long exec_time = end -start;
            System.out.println("Total execution time is : " +" "+ exec_time);
        }


        //System.out.println("Logging time");
    }
}






