package ru.job4j.food;

import java.util.Calendar;

public class Food {

    private String name;
    private Calendar expiryDate;
    private Calendar createDate;
    private float price;
    private float discount;

    public Food(String name, Calendar expiryDate, Calendar createDate, float price, float discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Calendar expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public void applyDiscount() {
        price = price - price * discount / 100;
    }

    public long expiryRate() {
        long expiryRate = (Calendar.getInstance().getTimeInMillis() - createDate.getTimeInMillis())
                * 100
                / (expiryDate.getTimeInMillis() - createDate.getTimeInMillis());
        return expiryRate <= 100 ? expiryRate : 100;
    }
}
