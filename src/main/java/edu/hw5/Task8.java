package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task8 {

    private Task8() {
    }

    private static Boolean hasOddLength(String string) {
        if (string == null) {
            return false;
        }
        String regex = "^([01]{2})*[01]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    private static Boolean startsWith0AndOddLengthOrStartsWith1AndEvenLength(String string) {
        if (string == null) {
            return false;
        }
        String regex = "^0([01]{2})*$|^1([01]{2})*[01]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    private static Boolean numberOf0Multiple3(String string) {
        if (string == null) {
            return false;
        }
        String regex = "^(1*01*01*0)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    private static Boolean anyStringOtherThan11Or111(String string) {
        if (string == null) {
            return false;
        }
        String regex = "^(?!1{2,3}$)[01]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    private static Boolean everyOddSymbolIs1(String string) {
        if (string == null) {
            return false;
        }
        String regex = "^(1[01])*1*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    private static Boolean containsAtLeastTwo0AndNoMoreThanOne1(String string) {
        if (string == null) {
            return false;
        }
        String regex = "^0+0+10*$|^0+10+$|^10+0+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    private static Boolean noConsecutive1(String string) {
        if (string == null) {
            return false;
        }
        String regex = "^(10+)*$|^(0+10*)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static Boolean runTask81(String string) {
        return hasOddLength(string);
    }

    public static Boolean runTask82(String string) {
        return startsWith0AndOddLengthOrStartsWith1AndEvenLength(string);
    }

    public static Boolean runTask83(String string) {
        return numberOf0Multiple3(string);
    }

    public static Boolean runTask84(String string) {
        return anyStringOtherThan11Or111(string);
    }

    public static Boolean runTask85(String string) {
        return everyOddSymbolIs1(string);
    }

    public static Boolean runTask86(String string) {
        return containsAtLeastTwo0AndNoMoreThanOne1(string);
    }

    public static Boolean runTask87(String string) {
        return noConsecutive1(string);
    }

}
