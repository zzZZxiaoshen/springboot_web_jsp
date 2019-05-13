package cn.pinghu.springboot_web_jsp.utils;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.*;
import java.util.List;

public class ExcelUtils {

    public static  byte[] createExcel(List<? extends BaseRowModel> data, Class<? extends BaseRowModel> clazz) throws FileNotFoundException {
        OutputStream out = new ByteArrayOutputStream();
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        Sheet sheet1 = new Sheet(0, 0,clazz);
        writer.write(data, sheet1);
        writer.finish();
        return ((ByteArrayOutputStream) out).toByteArray();
    }

}
