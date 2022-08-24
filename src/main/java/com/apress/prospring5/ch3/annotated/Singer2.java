package com.apress.prospring5.ch3.annotated;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("singer2")
@Scope("prototype")
public class Singer2 {
    private String lyric = "I played a quick game of chess with the sait and pepper shaker";

    public void sing() {
        // մեկնաբանված է, քանի որ կեղտոտում է կոնսուլը
        //System.out.println(lyric);
    }
}
