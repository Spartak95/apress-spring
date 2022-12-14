package com.apress.prospring5.ch5.aspectj;

import com.apress.prospring5.ch5.Guitar;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnotatedAdvice {
    // առաջին * - նշանակում է, որ կարող է վերադարձնել ցանկացած տիպի արժեք․
    // com.apress.prospring5.ch5..sing* - նշանակում է, որ com.apress.prospring5.ch5 package-ում գտնվող ցանկացած մեթոդ, որը սկսվում է sing անունով․
    // com.apress.prospring5.ch5.Guitar - այսինքն մեթոդի պարամետրը պետք է լինի Guitar տիպի․
    @Pointcut("execution(* com.apress.prospring5.ch5.aspectj..sing*(com.apress.prospring5.ch5.Guitar)) && args(value)")
    public void singExecution(Guitar value) { // pointcut
        //․․․
    }

    @Pointcut("bean(john*)")
    public void isJohn() { // pointcut
        //․․․
    }

    @Before(value = "singExecution(value) && isJohn()")
    public void simpleBeforeAdvice(JoinPoint joinPoint, Guitar value) {
        if (value.getBrand().equals("Gibson")) {
            System.out.println(
                "Executing: " + joinPoint.getSignature().getDeclaringTypeName() + " " + joinPoint.getSignature()
                    .getName() + " argument: " + value.getBrand());
        }
    }

    @Around(value = "singExecution(value) && isJohn()")
    public Object simpleAroundAdvice(ProceedingJoinPoint pjp, Guitar value) throws Throwable {
        System.out.println(
            "Before execution: " + pjp.getSignature().getDeclaringTypeName() + " " + pjp.getSignature().getName()
                + " argument: " + value.getBrand());

        Object retVal = pjp.proceed();

        System.out.println("After execution: " + pjp.getSignature().getName() + " argument: " + value.getBrand());

        return retVal;
    }
}
