package com.high.concurrency.currency02.util;
import com.high.concurrency.currency02.domain.User;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.io.FileOutputStream;
import java.util.List;
public class ExcelUtil {
    public static void createExcel(Integer currentPageNum, List userList) {
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("用户信息");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        // 创建一个居中格式
        style.setAlignment(HorizontalAlignment.CENTER);
        HSSFCell cell = row.createCell((short) 0);
        cell.setCellValue("id");
        cell.setCellStyle(style);
        cell = row.createCell((short) 1);
        cell.setCellValue("姓名");
        cell.setCellStyle(style);
        cell = row.createCell((short) 2);

// 第五步，写入实体数据 实际应用中这些数据从数据库得到，

        for (int i = 0; i < userList.size(); i++)
        {
            row = sheet.createRow((int) i + 1);
            User stu = (User) userList.get(i);
            // 第四步，创建单元格，并设置值
            row.createCell((short) 0).setCellValue(stu.getId());
            row.createCell((short) 1).setCellValue(stu.getName());

        }
// 第六步，把文件存到指定位置
        try
        {
            //为了测试方便，写死了路径，建议大家可以手工建D://excel路径，不然会报错
            FileOutputStream fout = new FileOutputStream("/Users/suyuzhou/project/springboot/currency02/src/main/resources/file/user-"+(currentPageNum+1)+".xls");
            wb.write(fout);
            fout.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
