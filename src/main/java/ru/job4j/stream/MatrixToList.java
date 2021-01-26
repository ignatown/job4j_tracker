package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
public static List<Integer> convert(Integer[][] matrix) {
    return (List<Integer>) Stream.of(matrix).flatMap(e -> Arrays.stream(e.clone())).collect(Collectors.toList());
}
}
