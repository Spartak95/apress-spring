package com.apress.prospring5.ch3.annotated;

import java.util.Arrays;
import java.util.Map;

import com.apress.prospring5.ch3.annotated.alias.Singer5;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class AliasConfigDemo2 {

    @Configuration
    @ComponentScan("com.apress.prospring5.ch3.annotated.alias")
    public static class AliasBeanConfig {

    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AliasBeanConfig.class);
        Map<String, Singer5> beans = ctx.getBeansOfType(Singer5.class);

        Class<Singer5> singer5Class = Singer5.class;
        Trophy annotation = singer5Class.getAnnotation(Trophy.class);
        System.out.println("Annotation name: " + annotation.name());

        Singer5 singer5 = ctx.getBean("serjTankian", Singer5.class);

        singer5.sing();

        beans.entrySet().stream().forEach(b -> System.out.println(
            "id: " + b.getKey() + "\n aliases: " + Arrays.toString(ctx.getAliases(b.getKey())) + "\n"));
    }
}
