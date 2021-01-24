package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        String[] arrOrigin = origin.split(" |, |; |: |! |!|/");
        Set<String> setOrigin = new HashSet<String>(Arrays.asList(arrOrigin));
        String[] arrLine = line.split(" |, ");
        Set<String> setLine = new HashSet<String>(Arrays.asList(arrLine));
        for (String s:
             setLine) {
           if (!setOrigin.contains(s)) {
               return false;
           }
        }
        return true;
    }

    public static void main(String[] args) {
        generateBy("aaa aaa aaa, aa a"," ");
    }
}