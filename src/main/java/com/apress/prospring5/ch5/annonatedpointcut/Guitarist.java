package com.apress.prospring5.ch5.annonatedpointcut;

import com.apress.prospring5.ch5.Guitar;
import com.apress.prospring5.ch5.Singer;

public class Guitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("Dream of ways to throw it all away");
    }

    @AdviceRequired
    public void sing(Guitar guitar) {
        System.out.println("play: " + guitar.play());
    }

    public void rest() {
        System.out.println("zzz");
    }
}
