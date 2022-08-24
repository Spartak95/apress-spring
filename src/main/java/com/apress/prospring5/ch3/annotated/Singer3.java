package com.apress.prospring5.ch3.annotated;

import org.springframework.stereotype.Component;

//@Component
@Component("johnMayer")
public class Singer3 {
    private String lyric = "We found a message in a bottle we were drinking";

    public void sing() {
        System.out.println(lyric);
    }
}
