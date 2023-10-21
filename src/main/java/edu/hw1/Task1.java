package edu.hw1;

public class Task1 {

    private Task1() {
    }

    private static int minutesToSeconds(String string) {
        int videoLength = -1;
        if (string != null) {
            int minutes = Integer.parseInt(string.split(":")[0]);
            int seconds = Integer.parseInt(string.split(":")[1]);
            if (seconds < Constants.MAX_SECONDS_VALUE && seconds >= 0 && minutes >= 0) {
                videoLength = minutes * Constants.MAX_SECONDS_VALUE + seconds;
            }
        }
        return videoLength;
    }

    public static int runTask1(String string) {
        return minutesToSeconds(string);
    }
}
