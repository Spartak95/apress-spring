package com.apress.prospring5.ch4.factorybean;

import java.security.MessageDigest;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("digester")
public class MessageDigester {
    private MessageDigest digest1;
    private MessageDigest digest2;

    @Autowired
    public void setDigest1(@Qualifier("shaDigest") MessageDigest digest1) {
        this.digest1 = digest1;
    }

    @Autowired
    public void setDigest2(@Qualifier("defaultDigest") MessageDigest digest2) {
        this.digest2 = digest2;
    }

    public void digest(String msg) {
        System.out.println("Using digest1");
        digest(msg, digest1);
        System.out.println("Using digest2");
        digest(msg, digest2);
    }

    private void digest(String msg, MessageDigest digest) {
        System.out.println("Using algorithm: " + digest.getAlgorithm());
        digest.reset();
        byte[] bytes = msg.getBytes();
        byte[] out = digest.digest(bytes);
        System.out.println(Arrays.toString(out));
    }
}
