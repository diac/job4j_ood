package ru.job4j.srp;

import java.util.Objects;
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

    public Person() {
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<EntrantApplication> getApplications() {
        return applications;
    }

    public void setApplications(Set<EntrantApplication> applications) {
        this.applications = applications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName)
                && Objects.equals(lastName, person.lastName)
                && Objects.equals(applications, person.applications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, applications);
    }

    public void rollbackAllApplications() {
        applications.forEach(entrantApplication -> entrantApplication.setStatus("Заявление забрано"));
    }
}
