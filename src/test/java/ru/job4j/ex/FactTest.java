package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FactTest {

    @Test
    public void testCalcNorm() {
    assertThat(Fact.calc(5), is(120));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalcIsc() {
        Fact.calc(-3);
    }
}