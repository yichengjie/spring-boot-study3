package com.yicj.web.view.excel;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

public class DefaultCellStyleImpl implements DefaultCellStyle{
    @Override
    public CellStyle setCellStyle(Workbook workbook) {
        // create style for header cells
        CellStyle cellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        cellStyle.setFillForegroundColor(HSSFColor.BLUE.index);
        cellStyle.setFillPattern((short) 1);
        font.setBold(true);
        font.setColor(HSSFColor.WHITE.index);
        cellStyle.setFont(font);
        return cellStyle;
    }
}
