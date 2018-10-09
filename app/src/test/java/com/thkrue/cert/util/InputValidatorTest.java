package com.thkrue.cert.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputValidatorTest {

    private InputValidator validator;

    @Before
    public void setup() {
        validator = new InputValidator();
    }

    @Test
    public void isValidEmail() {
        assertEquals(true, validator.isValidEmail("abc@abc.abc"));
        assertEquals(true, validator.isValidEmail("a@a.aa"));
        assertEquals(false, validator.isValidEmail("abc@abc."));
        assertEquals(false, validator.isValidEmail("@abc.abc"));
        assertEquals(false, validator.isValidEmail("abc@abc..abc"));
    }

    @Test
    public void isValidPassword() {
        assertEquals(true, validator.isValidPassword("1234567"));
        assertEquals(false, validator.isValidPassword("1"));
        assertEquals(false, validator.isValidPassword(null));
    }
}