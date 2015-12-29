package me.nasif.excelreader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class ExcelFileReader {

    private final String fileUrl;

    ExcelFileReader(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    protected abstract void processRow(Row row);

    public void processFile(int startRow, int endRow) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(fileUrl));
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() >= startRow && row.getRowNum() <= endRow) {
                    processRow(row);
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(ExcelFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected long getLongValue(Cell cell) {

        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            return (long) cell.getNumericCellValue();
        }
        return -1;
    }

}
