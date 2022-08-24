package com.apress.prospring5.ch3.annotated;

import org.springframework.core.annotation.AliasFor;

public @interface Award {
    @AliasFor("price")
    String[] value() default {};

    @AliasFor("value")
    String[] prize() default {};
}
