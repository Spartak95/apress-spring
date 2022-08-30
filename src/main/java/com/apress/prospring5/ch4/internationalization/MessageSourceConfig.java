package com.apress.prospring5.ch4.internationalization;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageSourceConfig {

    @Bean
    // if there was another name instead of the messageSource name, ApplicationContext would throw an exception.
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.addBasenames("labels");
        return resourceBundleMessageSource;
    }
}
