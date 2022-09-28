package ru.job4j.srp;

/*
* Шаблон проектирования Singleton нарушает SRP, т.к. одновременно отвечает за создание новых объектов
* и за выполнение какой-то логики или хранение данных.
*  */
public class ConnectionHandler {

    private ConnectionHandler instance = null;

    private ConnectionHandler() {
    }

    public ConnectionHandler getInstance() {
        if (instance == null) {
            instance = new ConnectionHandler();
        }
        return instance;
    }

    public void process() {
        /* Этот метод делает какую-то полезную работу */
    }
}
