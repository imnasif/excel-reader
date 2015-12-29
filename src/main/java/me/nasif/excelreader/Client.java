package me.nasif.excelreader;

import java.util.ArrayList;
import java.util.List;
import me.nasif.excelreader.model.Chocolate;
import me.nasif.excelreader.model.Pizza;

public class Client {

    private static final List<Chocolate> chocolateList = new ArrayList<>();
    private static final List<Pizza> pizzaList = new ArrayList<>();

    public static void main(String[] args) {

        ChoclatesFileReader choclatesExcelFileReader = new ChoclatesFileReader("res/chocolates.xlsx", chocolateList);
        choclatesExcelFileReader.processFile(ChoclatesFileReader.START_ROW, ChoclatesFileReader.END_ROW);

        chocolateList.forEach(c -> {
            System.out.println("name : " + c.name + "  price : " + c.price);
        });

        PizzaFileReader pizzaFileReader = new PizzaFileReader("res/pizza.xlsx", pizzaList);
        pizzaFileReader.processFile(PizzaFileReader.START_ROW, PizzaFileReader.END_ROW);

        pizzaList.forEach(p -> {
            System.out.println("name : " + p.name + "  price : " + p.price);
        });
    }
}
