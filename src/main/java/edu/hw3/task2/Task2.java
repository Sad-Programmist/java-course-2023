package edu.hw3.task2;

import java.util.ArrayList;
import java.util.List;

public class Task2 {

    private Task2() {
    }

    private static List<String> clusterize(String string) {
        int leftBracket = 0;
        int rightBracket = 0;

        String[] stringArray = string.split("");

        StringBuilder cluster = new StringBuilder();
        List<String> clusters = new ArrayList<>();

        for (String s : stringArray) {
            if (s.equals("(")) {
                leftBracket++;
            } else {
                rightBracket++;
            }

            cluster.append(s);

            if (leftBracket == rightBracket) {
                clusters.add(cluster.toString());
                cluster.setLength(0);
                leftBracket = 0;
                rightBracket = 0;
            }
        }
        return clusters;
    }

    public static List<String> runTask2(String string) {
        return clusterize(string);
    }
}
