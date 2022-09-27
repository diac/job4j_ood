package ru.job4j.ocp;

import java.time.LocalDate;

public class Post {

    private static final int EXCERPT_LENGTH = 50;

    private String title;
    private String author;
    private String content;
    private String excerpt;
    private LocalDate date;

    public void generateExcerpt() {
        excerpt = content.substring(EXCERPT_LENGTH);
    }
}
