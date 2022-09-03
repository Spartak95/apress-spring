package com.apress.prospring5.ch4.javaconfig.importannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ConfigB.class)
public class ConfigA {
    // եթե չլիներ @Import աննոտացիան, ապա ServiceB bean-ին context-ը չէր տեսնի,
    // անգամ, եթե ServiceB կլասսի վերևում հայտարված լիներ @Component աննոտացիան
    @Bean
    ServiceA serviceA(ServiceB serviceB) {
        serviceB.service();
        return new ServiceA();
    }
}
