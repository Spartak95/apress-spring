package com.apress.prospring5.ch3.annotated;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FieldInjection {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration2.class);
        Singer singerBean = ctx.getBean(Singer.class);
        singerBean.sing();
        Singer singer = new Singer();
    }
}
