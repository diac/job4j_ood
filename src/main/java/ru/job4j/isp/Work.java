package ru.job4j.isp;

/*
* Этот интерфейс описывает неторорую полезную работу в общем случае.
* Есть три реализации, в которых которых реализуется только часть из объявленных в интерфейсе методов.
* Таким образом, здесь нарушается ISP -- интерфейс Work является слишком общим, его необходимо разделить на более
* специфические.
* */
public interface Work {

    void init();

    void process();

    void processStep();

    void restart();

    void rollback();

    void commit();

    void cancel();

    void close();
}
