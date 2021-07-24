package com.example.cinemaapp.util;

public class regExpEmail {
    public static final String mailRegExp= "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    public static boolean isEmail(String mail) {
        return mail.matches(mailRegExp);
    }
}
