package com.springboot.admin.controller;

import com.springboot.admin.entity.ExcelEntity;
import com.springboot.admin.mapper.SysStudentMapper;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/stu/excel")
public class ExcelController {

    @Autowired
    SysStudentMapper sysStudentMapper;

    //点击下载excel 表格
    @PostMapping("/download")
    public void downAll(Integer s_id, HttpServletResponse response)throws Exception{
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");
        List<ExcelEntity> classmateList;
        if(s_id == null){
            classmateList = sysStudentMapper.getAllExcel();
        }else {
            classmateList = sysStudentMapper.getExcelBySId(s_id);
        }
        //设置要导出的文件的名字
        String fileName = "成绩表"+ ".xls";
        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        String[] headers = {"排名", "学号", "姓名","性别", "生日", "籍贯",
                "状态","班级","数学","Java", "英语", "体育", "总分"};
        //headers表示excel表中第一行的表头
        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头
        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        //在表中存放查询到的数据放入对应的列
        for (ExcelEntity table : classmateList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(rowNum);
            row1.createCell(1).setCellValue(table.getSId());
            row1.createCell(2).setCellValue(table.getSName());
            row1.createCell(3).setCellValue(table.getSex());
            row1.createCell(4).setCellValue(table.getBirth());
            row1.createCell(5).setCellValue(table.getNativePlace());
            row1.createCell(6).setCellValue(table.getStatu());
            row1.createCell(7).setCellValue(table.getClassName());
            row1.createCell(8).setCellValue(table.getMath());
            row1.createCell(9).setCellValue(table.getJava());
            row1.createCell(10).setCellValue(table.getEnglish());
            row1.createCell(11).setCellValue(table.getET());
            row1.createCell(12).setCellValue(table.getCOUNT());
            rowNum++;
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition",
                "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
}
