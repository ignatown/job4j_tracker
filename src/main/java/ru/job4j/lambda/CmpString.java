package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CmpString {
    public static void main(String[] args) {
        Comparator<String> cmpDescSize = (left, right) -> {
            int rs = right.length() - left.length();
            System.out.println("Compare: " + left + " : " + right + " is: " + rs);
           return rs;
        };
        List<String> strs = Arrays.asList("AAAA", "BB", "CCC", "D", "FFFFF");
        Collections.sort(strs, cmpDescSize);
    }
}
