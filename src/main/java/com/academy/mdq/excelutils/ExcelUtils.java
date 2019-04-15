package com.academy.mdq.excelutils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public final class ExcelUtils {

  private static final Logger LOGGER = getLogger(ExcelUtils.class);

  private static XSSFSheet getSheet(String filePath, String sheetName) {
    FileInputStream file;
    XSSFWorkbook wb;
    try {
      file = new FileInputStream(filePath);
      wb = new XSSFWorkbook(file);
      return wb.getSheet(sheetName);
    } catch (FileNotFoundException e) {
      LOGGER.error(e.getLocalizedMessage(), e);
    } catch (IOException e) {
      LOGGER.error(e.getLocalizedMessage(), e);
    }
    return null;
  }

  public static Object[][] readExcel(String filePath, String sheetName) {
    XSSFSheet sheet = getSheet(filePath, sheetName);
    int rowCount = sheet.getLastRowNum();
    int column = sheet.getRow(0).getLastCellNum();
    Object[][] data = new Object[rowCount][column];
    for (int i = 1; i <= rowCount; i++) {
      XSSFRow row = sheet.getRow(i);
      for (int j = 0; j < column; j++) {
        XSSFCell cell = row.getCell(j);
        DataFormatter formatter = new DataFormatter();
        String val = formatter.formatCellValue(cell);
        data[i - 1][j] = val;
      }
    }
    return data;
  }

}
