package com.xq.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.lang.model.element.VariableElement;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Mechrevo
 * @version v1.0
 * 2019/9/24 9:21
 */
public class ExcelUtil {
    public static <T> void excelExport(String title, List<T> datas, File file) throws Exception {
        //声明一个工作簿
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        //设置一个sheet名词
        HSSFSheet hssfSheet = hssfWorkbook.createSheet(title);

        HSSFRow hssfRow0 = hssfSheet.createRow(0);
        HSSFCell hssfCell0 = hssfRow0.createCell(0);
        hssfCell0.setCellValue("路路通fast物流公司");

        Field[] fs = datas.get(0).getClass().getDeclaredFields();
        hssfSheet.addMergedRegion(new CellRangeAddress(0,0,0,fs.length));


        HSSFRow row = hssfSheet.createRow(1);
        for (int i =0 ;i<fs.length;i++) {
            String name = fs[i].getName();
            System.out.println(name);

            HSSFCell cell = row.createCell(i);
            cell.setCellValue(name);
        }


        //数据处理，通过out写出
        for (int i = 0; i < datas.size(); i++) {
            //创建行数，主要是创建在第几行
            HSSFRow hssfRow = hssfSheet.createRow(i+2);
            //获取T的字段数
            Field[] fields = datas.get(i).getClass().getDeclaredFields();

            for (int j = 0; j < fields.length; j++) {
                //获取字段名称
                String fieldName = fields[j].getName();
                //获取get方法
                String methodName = "get"+ fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
                Method method = datas.get(i).getClass().getMethod(methodName);
                //执行get方法获取对应数据
                Object text = method.invoke(datas.get(i));

                //加入到对应单元格
                HSSFCell hssfCell = hssfRow.createCell(j);

                if (text != null) {
                    hssfCell.setCellValue(text.toString());
                }
            }
        }
        BufferedOutputStream bos=null;

        try {

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            // 创建文件输出流
            bos=new BufferedOutputStream(fileOutputStream);

            //写入到输出流中
            hssfWorkbook.write(bos);
        } finally {
            bos.close();
            bos=null;
        }
    }


}
