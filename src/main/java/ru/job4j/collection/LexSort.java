package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] sLeft = left.split(". ", 0);
        int iLeft = Integer.parseInt(sLeft[0], 10);
        String[] sRight = right.split(". ", 0);
        int iRight = Integer.parseInt(sRight[0], 10);
        return iLeft - iRight;
    }
}