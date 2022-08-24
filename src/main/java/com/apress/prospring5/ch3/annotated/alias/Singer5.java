package com.apress.prospring5.ch3.annotated.alias;

import com.apress.prospring5.ch3.annotated.Trophy;
import org.springframework.stereotype.Component;

@Component("serjTankian")
@Trophy(name = {"grammy", "platinum disk"})
public class Singer5 {
    private String lyric = "We found a message in a bottle we were drinking";

    public void sing() {
        System.out.println(lyric);
    }
}
