package me.nasif.excelreader.readers;

import me.nasif.excelreader.model.Pizza;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PizzaFileReaderTest {
    @Test
    public void getContents() throws Exception {
        List<Pizza> pizzas = new ArrayList<>();
        PizzaFileReader pizzaFileReader = new PizzaFileReader("res/pizza.xlsx", pizzas);
        pizzaFileReader.processFile(PizzaFileReader.START_ROW, PizzaFileReader.END_ROW);
        assertEquals(3, pizzas.size());
        assertEquals("Salami", pizzas.get(0).getName());
        assertEquals(500, pizzas.get(0).getPrice());
        assertEquals("Meet lovers", pizzas.get(1).getName());
        assertEquals(600, pizzas.get(1).getPrice());
        assertEquals("Four Seasons", pizzas.get(2).getName());
        assertEquals(700, pizzas.get(2).getPrice());
    }
}