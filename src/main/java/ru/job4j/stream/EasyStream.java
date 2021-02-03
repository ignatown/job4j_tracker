package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EasyStream {
    private List<Integer> ints = new ArrayList<>();



    public static EasyStream of(List<Integer> source) {
    if (source == null) {
        throw new UnsupportedOperationException();
    }
        EasyStream rsl = new EasyStream();
        for (Integer i:
             source) {
            rsl.ints.add(i);
        }
        return rsl;
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        if (fun == null) {
            throw new UnsupportedOperationException();
        }
        EasyStream rsl = new EasyStream();
        for (Integer i:
             ints) {
           rsl.ints.add(fun.apply(i));
        }
        return rsl;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        if (fun == null) {
            throw new UnsupportedOperationException();
        }
        EasyStream rsl = new EasyStream();
        for (Integer i:
             ints) {
            if (fun.test(i)) {
                rsl.ints.add(i);
            }
        }
        return rsl;
    }

    public List<Integer> collect() {
        return ints.stream().collect(Collectors.toList());
    }
}