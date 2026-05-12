package com.internetbot.data;

public class LoginScenario {
    private String usernameKey;
    private String passwordKey;
    private String expectedMessageKey;
    private boolean valid;

    public String getUsernameKey() {
        return usernameKey;
    }

    public String getPasswordKey() {
        return passwordKey;
    }

    public String getExpectedMessageKey() {
        return expectedMessageKey;
    }

    public boolean isValid() {
        return valid;
    }
}
