package com.apress.prospring5.ch4.javaconfig.importannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigB {
    @Bean
    ServiceB serviceB() {
        return new ServiceB();
    }
}
