package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UniqueTextTest {

    @Test
    public void isEquals() {
        String origin = "My cat eats a mouse and milk";
        String text = "My cat eats milk and a mouse";
        assertThat(UniqueText.isEquals(origin, text), is(true));
    }

    @Test
    public void isEquals2() {
        String origin = "A B C D";
        String text = "D B C A";
        assertThat(UniqueText.isEquals(origin, text), is(true));
    }

    @Test
    public void isNotEquals() {
        String origin = "My cat eats a mouse";
        String text = "A mouse is eaten by a cat";
        assertThat(UniqueText.isEquals(origin, text), is(false));
    }

    @Test
    public void isNotEquals2() {
        String origin = "A B C D";
        String text = "A B C F";
        assertThat(UniqueText.isEquals(origin, text), is(false));
    }
}