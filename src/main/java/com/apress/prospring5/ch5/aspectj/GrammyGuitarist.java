package com.apress.prospring5.ch5.aspectj;

import com.apress.prospring5.ch5.Guitar;
import com.apress.prospring5.ch5.Singer;
import org.springframework.stereotype.Component;

@Component("johnMayer")
public class GrammyGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("sing: Gravity is working against me\n"
                               + "And gravity wants to bring me down");
    }

    public void sing(Guitar guitar) {
        System.out.println("play: " + guitar.play());
    }

    public void rest() {
        System.out.println("zzz");
    }

    public void talk() {
        System.out.println("talk");
    }
}
