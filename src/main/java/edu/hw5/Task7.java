package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task7 {

    private Task7() {
    }

    private static boolean hasAtLeast3SymbolsAndThirdIs0(String string) {
        if (string == null) {
            return false;
        }
        String regex = "^[01]{2}0[01]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    private static boolean startsAndEndsWithSameSymbol(String string) {
        if (string == null) {
            return false;
        }
        String regex = "(^0[01]*0$)|(^1[01]*1$)|(^[01]$)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    private static boolean hasLengthNotLessThan1NotMoreThan3(String string) {
        if (string == null) {
            return false;
        }
        String regex = "^[01]{1,3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static boolean runTask71(String string) {
        return hasAtLeast3SymbolsAndThirdIs0(string);
    }

    public static boolean runTask72(String string) {
        return startsAndEndsWithSameSymbol(string);
    }

    public static boolean runTask73(String string) {
        return hasLengthNotLessThan1NotMoreThan3(string);
    }
}
