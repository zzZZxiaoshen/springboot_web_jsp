package cn.pinghu.springboot_web_jsp.utils;

import com.alibaba.excel.util.CollectionUtils;
import com.xuxueli.poi.excel.ExcelImportUtil;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

/**
 * EXCEL数据转化工具
 * @author zhuhongxin
 * @date 2018/12/19
 */
@SuppressWarnings("unchecked")
public class ExcelConversionUtils<T> {

    public List<T> conversion(File file, Class<T> clazz) {
        if (file == null) {
            return Collections.emptyList();
        }
        if (!file.exists()) {
            return Collections.emptyList();
        }
        if (!file.isFile()) {
            return Collections.emptyList();
        }
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            return Collections.emptyList();
        }
        BufferedInputStream bis = new BufferedInputStream(fis);
        List<Object> objects = ExcelImportUtil.importExcel(bis, clazz);
        if (CollectionUtils.isEmpty(objects)) {
            return Collections.emptyList();
        }
        return (List<T>) objects;
    }

    public static <T> ExcelConversionUtils<T> getInstance() {
        return new ExcelConversionUtils<>();
    }

}
