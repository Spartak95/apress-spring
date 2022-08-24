package com.apress.prospring5.ch3.annotated;

import org.springframework.stereotype.Component;

// սովորական Spring Bean կոմպոնետ
@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
