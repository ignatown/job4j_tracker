package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalcFuncTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = CalcFunc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponential() {
        List<Double> result = CalcFunc.diapason(0, 4, x -> 2 * x * x + 5);
        List<Double> expected = Arrays.asList(5D, 7D, 13D, 23D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadratic() {
        List<Double> result = CalcFunc.diapason(-2, 4, x -> Math.pow(0.5, x));
        List<Double> expected = Arrays.asList(4D, 2D, 1D, 0.5, 0.25, 0.125);
        assertThat(result, is(expected));
    }
}