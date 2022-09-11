package com.apress.prospring5.ch4.environment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class PlaceHolderConfig {
    @Bean
    public AppProperty appProperty() {
        return new AppProperty();
    }
}
