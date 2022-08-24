package com.apress.prospring5.ch4.factorybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class MessageDigestDemo {
    @Configuration
    @ComponentScan("com.apress.prospring5.ch4.factorybean")
    static class MessageDigestConfig {
        @Bean
        MessageDigestFactoryBean shaDigest() {
            MessageDigestFactoryBean factoryOne = new MessageDigestFactoryBean();
            factoryOne.setAlgorithmName("SHA1");
            return factoryOne;
        }

        @Bean
        MessageDigestFactoryBean defaultDigest() {
            return new MessageDigestFactoryBean();
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MessageDigestConfig.class);
        MessageDigester digester = ctx.getBean("digester", MessageDigester.class);
        digester.digest("Hello World");
        ctx.close();
    }
}
