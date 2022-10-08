package com.apress.prospring5.ch5.regexppointcut;

import com.apress.prospring5.ch5.Singer;

public class Guitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("Just keep me where the light is");
    }

    public void sing2() {
        System.out.println("Oh gravity, stay the hell away from me");
    }

    public void rest() {
        System.out.println("zzz");
    }
}
