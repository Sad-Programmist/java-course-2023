package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {

    private Task4() {
    }

    public static Boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }
        String regex = "[~!@#$%^&*|]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public static Boolean runTask4(String password) {
        return validatePassword(password);
    }
}
