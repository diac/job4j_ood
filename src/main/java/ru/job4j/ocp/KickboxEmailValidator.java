package ru.job4j.ocp;

public class KickboxEmailValidator implements EmailValidator {

    @Override
    public boolean isValid(String email) {
        return false;
    }
}
