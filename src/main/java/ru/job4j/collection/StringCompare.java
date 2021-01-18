package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int lln = left.length();
        int rln = right.length();
        for (int i = 0; i < Math.min(lln, rln); i++) {

            char c1 = left.charAt(i);
            char c2 = right.charAt(i);
            if (c1 != c2) {
                return c1 - c2;

            }
        }
        return lln - rln;
    }
}