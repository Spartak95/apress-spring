package com.apress.prospring5.ch4.profile;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class ProfileJavaConfigExample {
    public static void main(String[] args) {
        GenericApplicationContext
            ctx = new AnnotationConfigApplicationContext(KindergartenConfig.class, HighschoolConfig.class);
        ctx.getEnvironment().setActiveProfiles("kindergarten");
        FoodProviderService foodProviderService = ctx.getBean("foodProviderService", FoodProviderService.class);

        List<Food> lunchSet = foodProviderService.provideLunchSet();

        for(Food food : lunchSet) {
            System.out.println("Food: " + food.getName());
        }

        ctx.close();
    }
}
