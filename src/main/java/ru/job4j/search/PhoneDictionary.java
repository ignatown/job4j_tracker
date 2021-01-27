package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combineName = (Person person) -> person.getName().contains(key);
        Predicate<Person> combineSurname = (Person person) -> person.getSurname().contains(key);
        Predicate<Person> combinePhone = (Person person) -> person.getPhone().contains(key);
        Predicate<Person> combineAddress = (Person person) -> person.getAddress().contains(key);
        Predicate<Person> combine = (Person person) -> combineName.or(combineSurname.or(combinePhone.or(combineAddress))).test(person);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}