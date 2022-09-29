package ru.job4j.isp;

/*
* Класс-реализация сисиемной команды. Команду можно запустить, отменить или откатить внесенные ей изменения.
* */
public class Command implements Work {

    @Override
    public void init() {
        /* (!) Ненужный метод */
    }

    @Override
    public void process() {
        /* Нужный метод */
    }

    @Override
    public void processStep() {
        /* (!) Ненужный метод */
    }

    @Override
    public void restart() {
        /* (!) Ненужный метод */
    }

    @Override
    public void rollback() {
        /* Нужный метод */
    }

    @Override
    public void commit() {
        /* (!) Ненужный метод */
    }

    @Override
    public void cancel() {
        /* Нужный метод */
    }

    @Override
    public void close() {
        /* (!) Ненужный метод */
    }
}
