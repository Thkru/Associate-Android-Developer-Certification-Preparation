package com.thkrue.cert.util;

public class InputValidator {

    public boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean isValidPassword(String password) {
        return password != null && password.length() > 6;
    }

}
