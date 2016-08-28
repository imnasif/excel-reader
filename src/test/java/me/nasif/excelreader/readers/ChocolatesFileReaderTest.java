package me.nasif.excelreader.readers;

import me.nasif.excelreader.model.Chocolate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ChocolatesFileReaderTest {
    @Test
    public void getContents() throws Exception {
        List<Chocolate> chocolates = new ArrayList<>();
        ChocolatesFileReader chocolatesExcelFileReader = new ChocolatesFileReader("res/chocolates.xlsx", chocolates);
        chocolatesExcelFileReader.processFile(ChocolatesFileReader.START_ROW, ChocolatesFileReader.END_ROW);
        assertEquals(3, chocolates.size());
        assertEquals("Kitkat", chocolates.get(0).getName());
        assertEquals(10, chocolates.get(0).getPrice());
        assertEquals("Mars", chocolates.get(1).getName());
        assertEquals(20, chocolates.get(1).getPrice());
        assertEquals("Cadbury", chocolates.get(2).getName());
        assertEquals(30, chocolates.get(2).getPrice());
    }

}