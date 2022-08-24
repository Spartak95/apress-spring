package com.apress.prospring5.ch3.annotated.dependson;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

public class DependsOnDemo {

    @ComponentScan("com.apress.prospring5.ch3.annotated.dependson")
    public static class DependsOnConfigDemo {

    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DependsOnConfigDemo.class);
        Singer johnMayer = ctx.getBean("johnMayer", Singer.class);
        johnMayer.sing();
    }
}
