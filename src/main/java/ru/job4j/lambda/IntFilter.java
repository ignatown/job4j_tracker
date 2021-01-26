package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IntFilter {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(-5);
        ints.add(4);
        ints.add(0);
        ints.add(-2);
        ints.add(1);
       List<Integer> fltInt = ints.stream().filter(
                i -> i>=0
        ).collect(Collectors.toList());
        fltInt.forEach(System.out::println);
    }
}
