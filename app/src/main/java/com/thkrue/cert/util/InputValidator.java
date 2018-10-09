package com.thkrue.cert.util;

import java.util.regex.Pattern;

public class InputValidator {

    public boolean isValidEmail(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        return Pattern.compile(ePattern).matcher(email).matches();
    }

    public boolean isValidPassword(String password) {
        return password != null && password.length() > 6;
    }

}
