package ru.job4j.srp;

import java.time.LocalDate;
import java.util.Objects;

public class EntrantApplication {

    private String number;
    private LocalDate date;
    private String status;

    public EntrantApplication() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EntrantApplication that = (EntrantApplication) o;
        return Objects.equals(number, that.number) && Objects.equals(date, that.date)
                && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, date, status);
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
