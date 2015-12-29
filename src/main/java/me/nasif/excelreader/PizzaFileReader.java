package me.nasif.excelreader;

import java.util.List;
import me.nasif.excelreader.model.Pizza;
import org.apache.poi.ss.usermodel.Row;

public class PizzaFileReader extends ExcelFileReader {

    public static final int START_ROW = 1;
    public static final int END_ROW = 3;

    private static final int NAME_COLUMN = 0;
    private static final int PRICE_COLUMN = 1;

    private final List<Pizza> list;

    public PizzaFileReader(String fileUrl, List<Pizza> list) {
        super(fileUrl);
        this.list = list;
    }

    public List<Pizza> getDataAsList() {
        return this.list;
    }

    @Override
    protected void processRow(Row row) {

        list.add(
                new Pizza(
                        row.getCell(NAME_COLUMN, Row.CREATE_NULL_AS_BLANK).getStringCellValue().trim(),
                        (int) row.getCell(PRICE_COLUMN, Row.CREATE_NULL_AS_BLANK).getNumericCellValue()
                )
        );
    }

}
