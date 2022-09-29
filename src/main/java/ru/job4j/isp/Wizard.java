package ru.job4j.isp;

/*
* Класс-обработчик последовательно выполняемых задач. Выполняет последовательность шагов. Можно начать
* последовательность с начала либо досрочно завершить.
* */
public class Wizard implements Work {

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
        /* Нужный метод */
    }

    @Override
    public void restart() {
        /* Нужный метод */
    }

    @Override
    public void rollback() {
        /* (!) Ненужный метод */
    }

    @Override
    public void commit() {
        /* (!) Ненужный метод */
    }

    @Override
    public void cancel() {
        /* (!) Ненужный метод */
    }

    @Override
    public void close() {
        /* Нужный метод */
    }
}
