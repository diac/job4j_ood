package ru.job4j.ocp;

import java.nio.file.Path;

/**
 * Данная реализация нарушает OCP, так как класс PostAttachment наследуется от класса Post
 * со всеми его полями и методами.
 * (Post -- публикация на сайте, PostAttachment -- приложенное к публикации изображение, текстовый документ и т.п.)
 * Во-первых из-за наследования в классе PostAttachment будут доступны все методы, определенные в Post. В частности --
 * generateExcerpt(), который в классе PostAttachment вообще не нужен.
 * Во-вторых любое изменение класса Post неизбежно приведет к изменению поведения класса PostAttachment. Следовательно,
 * любое расширение класса Post фактически повлечет за собой изменение класса PostAttachment -- а это нарушение OCP.
 * Правильным решением здесь была бы другая иерархия наследования с выделением общих полей и методов
 * в абстрактные классы и интерфейсы.
 */
public class PostAttachment extends Post {

    private int size;
    private Path path;
    private String url;
    private Post post;
}
