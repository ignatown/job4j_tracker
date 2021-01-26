package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentToMap {
    public Map<String, Integer> convert(List<Student> students) {
        return students
                .stream()
                .distinct()
                .collect(Collectors.toMap(
                e -> e.getSurname(),
                t -> t.getScore()
        ));
    }
}
