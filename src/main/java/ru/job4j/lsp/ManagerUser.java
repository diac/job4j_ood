package ru.job4j.lsp;

public class ManagerUser extends User {

    @Override
    public void login() {
        if (loginAttempts > 3) {
            throw new IllegalArgumentException("Слишком много попыток входа");
        }
        super.login();
    }

    @Override
    public void logout() {

    }

    @Override
    public void register() {

    }
}
