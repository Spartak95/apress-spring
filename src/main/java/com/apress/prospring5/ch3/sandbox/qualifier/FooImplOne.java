package com.apress.prospring5.ch3.sandbox.qualifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FooImplOne implements Foo {

    @Override
    public String toString() {
        return "FooImplOne{}";
    }
}
