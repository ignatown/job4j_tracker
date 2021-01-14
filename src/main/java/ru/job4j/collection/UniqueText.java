package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String original:
             origin) {
            check.add(original);
        }
        for (String checkW:
             text) {
            if (!check.contains(checkW)) {
               return false;
            }
        }
        return true;
    }
}