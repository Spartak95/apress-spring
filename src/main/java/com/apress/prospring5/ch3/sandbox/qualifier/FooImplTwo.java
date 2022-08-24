package com.apress.prospring5.ch3.sandbox.qualifier;

import org.springframework.stereotype.Component;

@Component
public class FooImplTwo implements Foo {
    @Override
    public String toString() {
        return "FooImplTwo{}";
    }
}
