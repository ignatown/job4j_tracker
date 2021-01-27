package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class MatrixToListTest {
    @Test
    public void whenConvert() {
        Integer[][] matrix = {{5, 3, 8}, {1, 4, 9}, {-5, 8, 20}};
        assertThat(MatrixToList.convert(matrix),
                is(Arrays.asList(5, 3, 8, 1, 4, 9, -5, 8, 20)));
    }
}