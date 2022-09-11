package com.apress.prospring5.ch4.environment;

import org.springframework.beans.factory.annotation.Value;

public class AppProperty {
    @Value("${application.home}")
    private String applicationHome;
    @Value("${user.home}")
    private String userHome;

    public String getApplicationHome() {
        return applicationHome;
    }

    public void setApplicationHome(String applicationHome) {
        this.applicationHome = applicationHome;
    }

    public String getUserHome() {
        return userHome;
    }

    public void setUserHome(String userHome) {
        this.userHome = userHome;
    }
}
