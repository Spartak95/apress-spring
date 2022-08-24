package com.apress.prospring5.ch4.destructiveBean;

import java.io.File;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class DestructiveBeanWithInterface implements InitializingBean, DisposableBean {

    @ComponentScan("com.apress.prospring5.ch4.destructiveBean")
    static class DestructiveBeanConfig {

    }

    private File file;
    @Value("${systemProperties'java.io.tmpdir'}${systemProperties'file.separator'}test.txt")
    private String filePath;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean");

        if (filePath == null) {
            throw new IllegalArgumentException(
                "You must specify the filePath property of " + DestructiveBeanWithInterface.class);
        }

        this.file = new File(filePath);
        this.file.createNewFile();

        System.out.println("File exists: " + file.exists());
    }

    @Override
    public void destroy() {
        System.out.println("Destroying Bean");

        if (!file.delete()) {
            System.out.println("ERROR: failed to delete file.");
        }

        System.out.println("File exists: " + file.exists());
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DestructiveBeanConfig.class);
        DestructiveBeanWithInterface bean =
            ctx.getBean("destructiveBeanWithInterface", DestructiveBeanWithInterface.class);
        System.out.println("Calling destroy");
        ctx.registerShutdownHook(); // համարժեք է close() և destroy() մեթոդներին
        System.out.println("Calling destroy");
    }
}
