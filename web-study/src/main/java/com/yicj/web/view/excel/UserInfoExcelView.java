package com.yicj.web.view;

import com.yicj.web.model.ExportMemberVo;
import com.yicj.web.view.excel.DefaultCellStyle;
import com.yicj.web.view.excel.DefaultCellStyleImpl;
import com.yicj.web.view.excel.ExcelView;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;
import java.util.Map;

public class UserInfoExcelView extends ExcelView {
    @Override
    protected void setStyle(Workbook workbook) {
        DefaultCellStyle defaultCellStyle = new DefaultCellStyleImpl();
        super.cellStyle = defaultCellStyle.setCellStyle(workbook);
    }

    @Override
    protected void setRow(Sheet sheet, Map<String, Object> map) {
        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("姓名");
        header.getCell(0).setCellStyle(super.cellStyle);
        header.createCell(1).setCellValue("性别");
        header.getCell(1).setCellStyle(super.cellStyle);
        header.createCell(2).setCellValue("手机号");
        header.getCell(2).setCellStyle(super.cellStyle);
        header.createCell(3).setCellValue("身份证号");
        header.getCell(3).setCellStyle(super.cellStyle);
        header.createCell(4).setCellValue("银行卡号");
        header.getCell(4).setCellStyle(super.cellStyle);

        @SuppressWarnings("unchecked")
        List<ExportMemberVo> list = (List<ExportMemberVo>) map.get("members");
        int rowCount = 1;
        for (ExportMemberVo user : list) {
            Row userRow = sheet.createRow(rowCount++);
            userRow.createCell(0).setCellValue(user.getName());
            userRow.createCell(1).setCellValue(user.getGender());
            userRow.createCell(2).setCellValue(user.getPhone());
            userRow.createCell(3).setCellValue(user.getIdCard());
            userRow.createCell(4).setCellValue(user.getBankNo());
        }
    }
}
