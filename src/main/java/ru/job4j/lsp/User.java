package ru.job4j.lsp;

/*
От этого класса наследуются два других: AdminUser и ManagerUser.
В переопределенном в ManagerUser методе login() усиливается условие входа -- "не больше трех попыток подряд".
Соответственно, с классом ManagerUser нельзя будет работать через абстракцию User.
Таким образом, в данном примере нарушается LSP
 */
public abstract class User {

    protected int loginAttempts = 0;

    void login() {
        if (loginAttempts > 5) {
            throw new IllegalArgumentException("Слишком много попыток входа");
        }
    }
    void logout() {

    }
    void register() {

    }
}
