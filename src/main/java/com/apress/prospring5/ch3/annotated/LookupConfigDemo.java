package com.apress.prospring5.ch3.annotated;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

public class LookupConfigDemo {

    @Configuration
    @ComponentScan(basePackages = "com.apress.prospring5.ch3.annotated")
    public static class LookupConfig {}

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(LookupConfig.class);
        DemoBean abstractBean = ctx.getBean("abstractLookupBean", DemoBean.class);
        DemoBean standardBean = ctx.getBean("standardLookupBean", DemoBean.class);

        displayInfo("abstractLookupBean", abstractBean);
        displayInfo("standardLookupBean", standardBean);
    }

    private static void displayInfo(String beanName, DemoBean bean) {
        Singer2 singer1 = bean.getMySinger();
        Singer2 singer2 = bean.getMySinger();
        System.out.println("" + beanName + ": " + "Singer Instances the Same? " + (singer1 == singer2));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        for (int x = 0; x < 100000; x++) {
            Singer2 singer = bean.getMySinger();
            singer.sing();
        }
        stopWatch.stop();
        System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
