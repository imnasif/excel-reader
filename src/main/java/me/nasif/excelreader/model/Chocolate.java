package me.nasif.excelreader.model;

public class Chocolate {

    public String name;
    public int price;

    public Chocolate(String name, int price) {
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