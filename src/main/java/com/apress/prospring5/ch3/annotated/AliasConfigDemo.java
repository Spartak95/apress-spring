package com.apress.prospring5.ch3.annotated;

import java.util.Arrays;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AliasFor;

public class AliasConfigDemo {

    @Configuration
    public static class AliasBeanConfig {
        //@Bean
        @Bean(name = {"johnMayer", "john", "johnathan", "johnny"})
        public Singer4 singer() {
            return new Singer4();
        }
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AliasBeanConfig.class);
        Map<String, Singer4> beans = ctx.getBeansOfType(Singer4.class);

        beans.entrySet().stream().forEach(b -> System.out.println(
            "id: " + b.getKey() + "\n aliases: " + Arrays.toString(ctx.getAliases(b.getKey())) + "\n"));
    }
}
