package com.apress.prospring5.ch4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class NamedSingerDemo {
    @Configuration
    static class NamedSingerConfig {

        @Bean(name = "johnMayer")
        NamedSinger namedSinger() {
            return new NamedSinger();
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(NamedSingerConfig.class);
        NamedSinger bean = ctx.getBean("johnMayer", NamedSinger.class);
        bean.sing();
        ctx.close();
    }
}
