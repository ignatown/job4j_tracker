package ru.job4j.collection;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> search(String key) {
        ArrayList<Person> fnd = new ArrayList<Person>();
        for (Person value: persons) {
            if (value.getName().contains(key) || value.getSurname().contains(key)
                    || value.getPhone().contains(key) || value.getAddress().contains(key)) {
                fnd.add(value);
            }
        }
        return fnd;

    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        return result;
    }
}
