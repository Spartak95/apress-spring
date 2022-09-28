package com.apress.prospring5.ch5;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return "sing".equals(method.getName());
    }

    @Override
    public ClassFilter getClassFilter() {
        return cls -> cls == GoodGuitarist.class;
    }
}
