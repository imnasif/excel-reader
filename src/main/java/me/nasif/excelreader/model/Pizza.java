package me.nasif.excelreader.model;

public class Pizza {

    public String name;
    public int price;

    public Pizza(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}