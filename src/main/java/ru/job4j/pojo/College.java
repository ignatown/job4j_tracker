package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ignatov Nikita Vitalievich");
        student.setStudyGroup("ER-14-18");
        student.setStartDate(new Date());
    }
}
