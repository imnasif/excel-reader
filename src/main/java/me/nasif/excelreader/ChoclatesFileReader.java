package me.nasif.excelreader;

import java.util.List;
import me.nasif.excelreader.model.Chocolate;
import org.apache.poi.ss.usermodel.Row;

public class ChoclatesFileReader extends ExcelFileReader {

    public static final int START_ROW = 1;
    public static final int END_ROW = 3;

    private static final int NAME_COLUMN = 0;
    private static final int PRICE_COLUMN = 1;

    private final List<Chocolate> list;

    public ChoclatesFileReader(String fileUrl, List<Chocolate> list) {
        super(fileUrl);
        this.list = list;
    }

    public List<Chocolate> getDataAsList() {
        return this.list;
    }

    @Override
    protected void processRow(Row row) {

        list.add(
                new Chocolate(
                        row.getCell(NAME_COLUMN, Row.CREATE_NULL_AS_BLANK).getStringCellValue().trim(),
                        (int) row.getCell(PRICE_COLUMN, Row.CREATE_NULL_AS_BLANK).getNumericCellValue()
                )
        );
    }

}
