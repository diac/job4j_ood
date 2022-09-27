package ru.job4j.tdd;

import java.util.*;
import java.util.function.Predicate;

public class Cinema3D implements Cinema {

    private Set<Ticket> tickets = new HashSet<>();

    @Override
    public List<Session> find(Predicate<Session> filter) {
        return null;
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        if (row < 1 || column < 1) {
            throw new IllegalArgumentException("Invalid place");
        }
        Calendar now = Calendar.getInstance();
        for (var calendar : List.of(date, now)) {
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
        }
        if (date.before(now)) {
            throw new IllegalArgumentException("Invalid date");
        }
        Ticket ticket = new Ticket3D(account, row, column, date);
        if (tickets.contains(ticket)) {
            throw new IllegalArgumentException("This ticket has already been sold");
        }
        tickets.add(ticket);
        return ticket;
    }

    @Override
    public void add(Session session) {

    }
}