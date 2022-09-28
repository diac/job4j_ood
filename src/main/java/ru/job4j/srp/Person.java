package ru.job4j.srp;

import java.util.Set;

/*
* В данной модели нарушается SRP, т.к. в методе rollbackAllApplications() через метод-сеттер
* изменяется внутреннее состояние другой модели.
* */
public class Person {

    private String firstName;
    private String lastName;
    private int age;

    private Set<EntrantApplication> applications;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void rollbackAllApplications() {
        applications.forEach(entrantApplication -> entrantApplication.setStatus("Заявление забрано"));
    }
}
