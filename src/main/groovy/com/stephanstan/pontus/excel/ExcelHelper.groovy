package com.stephanstan.pontus.excel

import org.apache.poi.ss.usermodel.CellStyle
import org.apache.poi.ss.usermodel.IndexedColors
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFFont
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

/**
 * Created by Owner on 1/31/2016.
 */
class ExcelHelper {


     static XSSFWorkbook createWorkbook() {
        return new XSSFWorkbook()
    }

    ExcelHelper()
    {}

    /**
     * create a workbook
     * dress up the workbook
     *
     */
    public static XSSFWorkbook  createAnEmptyDojangBlinger()
    {
        XSSFWorkbook wb = ExcelHelper.createWorkbook()
        String sheetName = "Dojang";//name of sheet
        XSSFSheet sheet = wb.createSheet(sheetName)

        // create first row that contains the header
        XSSFRow row = sheet.createRow(0)

        // http://www.concretepage.com/apache-api/how-to-set-background-and-font-color-in-xlsx-using-poi-in-java
        //https://poi.apache.org/apidocs/org/apache/poi/xssf/usermodel/XSSFCell.html

        CellStyle style = wb.createCellStyle()
        style.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);

        def XSSFFont font = wb.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);

        // create first colunm header - Ignore Row
        XSSFCell cell = row.createCell(0)
        cell.setCellValue("Ignore Row")
        cell.setCellStyle(style)

        // create 2nd column - Name - parameter from the domain object Dojang
        cell = row.createCell(1)
        cell.setCellStyle(style)

        cell.setCellValue("Name")

        return wb
    }

}
