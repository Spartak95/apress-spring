package com.apress.prospring5.ch5;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityDemo {
    public static void main(String[] args) {
        SecurityManager mgr = new SecurityManager();

        SecureBean bean = getSecurityBean(mgr);

        mgr.login("John", "pwd");
        bean.writeSecureMessage();
        mgr.logout();

        try {
            mgr.login("invalid user", "pwd");
            bean.writeSecureMessage();
        } catch (SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        } finally {
            mgr.logout();
        }

        try {
            bean.writeSecureMessage();
        } catch (SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        }
    }

    private static SecureBean getSecurityBean(SecurityManager mgr) {
        SecureBean target = new SecureBean();

        SecurityAdvice advice = new SecurityAdvice(mgr);

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(advice);

        SecureBean proxy = (SecureBean)factory.getProxy();

        return proxy;
    }
}
