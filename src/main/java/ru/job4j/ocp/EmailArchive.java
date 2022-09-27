package ru.job4j.ocp;

import java.util.Set;

/**
 * Данная реализация нарушает OCP, так как в классе явным образом объявлен объект класса KickboxEmailValidator.
 * Таким образом, реализация зависит от другой реализации, что делает невозможным расширение функиональности через
 * расширение. Если потребуется другой валидатор, то придется либо добавлять его
 * как отдельное поле или локальную переменную, возможно изменяя уже существующий код.
 * Правильно было бы объявлять валидатор через интерфейс EmailValidator, или же строить данную реализацию на базе
 * шаблона "Стратегия".
 */
public class EmailArchive {

    private final KickboxEmailValidator validator = new KickboxEmailValidator();

    private Set<String> emailAddresses;

    public Set<String> getEmailAddresses() {
        return emailAddresses;
    }

    public boolean add(String email) {
        boolean isValid = validator.isValid(email);
        if (isValid) {
            emailAddresses.add(email);
        }
        return isValid;
    }
}
