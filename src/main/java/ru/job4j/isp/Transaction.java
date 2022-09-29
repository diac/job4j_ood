package ru.job4j.isp;

/*
* Класс-реализация транзакции. Транзакцию можно инициализировать, запустить на выполнение,
* зафиксировать или откатить изменения.
* */
public class Transaction implements Work {

    @Override
    public void init() {
        /* Нужный метод */
    }

    @Override
    public void process() {
        /* (!) Ненужный метод */
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
        /* Нужный метод */
    }

    @Override
    public void cancel() {
        /* (!) Ненужный метод */
    }

    @Override
    public void close() {
        /* (!) Ненужный метод */
    }
}
