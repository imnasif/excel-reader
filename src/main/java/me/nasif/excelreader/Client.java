package me.nasif.excelreader;

import me.nasif.excelreader.model.Chocolate;
import me.nasif.excelreader.model.Pizza;
import me.nasif.excelreader.readers.ChocolatesFileReader;
import me.nasif.excelreader.readers.PizzaFileReader;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private static final List<Chocolate> chocolateList = new ArrayList<>();
    private static final List<Pizza> pizzaList = new ArrayList<>();

    public static void main(String[] args) {

        ChocolatesFileReader chocolatesExcelFileReader = new ChocolatesFileReader("res/chocolates.xlsx", chocolateList);
        chocolatesExcelFileReader.processFile(ChocolatesFileReader.START_ROW, ChocolatesFileReader.END_ROW);
        chocolateList.forEach(c -> System.out.println("name : " + c.name + "  price : " + c.price));

        PizzaFileReader pizzaFileReader = new PizzaFileReader("res/pizza.xlsx", pizzaList);
        pizzaFileReader.processFile(PizzaFileReader.START_ROW, PizzaFileReader.END_ROW);
        pizzaList.forEach(p -> System.out.println("name : " + p.name + "  price : " + p.price));
    }
}
