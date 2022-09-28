package ru.job4j.srp;

import java.time.LocalDate;

public class EntrantApplication {

    private String number;
    private LocalDate date;
    private String status;

    public EntrantApplication(String number, LocalDate date, String status) {
        this.number = number;
        this.date = date;
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
