package com.stephanstan.pontus.excel

import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook

/**
 * Created by Owner on 1/31/2016.
 */
class ExcelHelper {


     static Workbook createWorkbook() {
        return new XSSFWorkbook()
    }
}
