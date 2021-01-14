package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("ignatow.n@mail.ru", "Игнатов Никита Витальевич");
        map.put("fkdsa@mail.ry", "Сергеев Анатолий Владимирович");
        for (String key:
             map.keySet()) {
            System.out.println(key +" "+map.get(key));
        }

    }
}
