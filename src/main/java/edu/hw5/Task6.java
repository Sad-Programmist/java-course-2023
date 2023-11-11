package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {

    private Task6() {
    }

    private static Boolean isSubstring(String substring, String string) {
        if (substring == null || string == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(substring);
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }

    public static Boolean runTask6(String substring, String string) {
        return isSubstring(substring, string);
    }
}
