package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void getAddresses() {
        List<Address> address = Arrays.asList(
                new Address("Moscow", "Okhotny ryad", 1, 1),
                new Address("Sankt-Petersburg", "Nevsky prospect", 7, 5)

        );
        List<Profile> list = Arrays.asList(
                new Profile(address.get(0)),
                new Profile(address.get(1))

        );
        assertThat(
                Profiles.collect(list),
                is(address)
        );
    }}