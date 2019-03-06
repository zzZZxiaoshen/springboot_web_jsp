package cn.pinghu.springboot_web_jsp.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ExcelPoiUtil {

    private static final Logger LOGGER = LogManager.getLogger(ExcelPoiUtil.class);
    private static final FastDateFormat FORMAT1 = FastDateFormat.getInstance("yyyyMMddHHmmss");
    private static final FastDateFormat FORMAT2 = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");



    /**
     * 设置导入参数
     */
    public ImportParams getImportParams() {
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        return params;
    }


  /*
    /**
     * 根据注解导入excel
     * @param path  文件位置
     * @param clazz 读取excel封装的java类型
     * @return 封装的excel毎一列的数据 返回一个lst集合

  public <T> List<T> impoteExcel(String path, Class<T> clazz) throws Exception {
        FileInputStream fin = new FileInputStream(path);
        ImportParams params = getImportParams();
        List<T> list = ExcelImportUtil.importExcel(
                fin,
                clazz, params);
        return list;
    }
    */
    public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        if (file == null) {
            return Collections.emptyList();
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> excelData = null;
        try {
            excelData = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
        } catch (NoSuchElementException e) {
            LOGGER.error("excel is empty");
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return excelData;
    }


    /**
     * 模板路径

    public static TemplateExportParams getTemplateExportParams() {
        return new TemplateExportParams(
                "C:\\Users\\lx\\Desktop\\沈凯的个人文件夹\\数据导入\\订单列表.xls");
    }


     * 使用模板导出excel  注意模板只能是xls后缀结尾的
     * @param map 需要导出的数据
     * @return 用户信息

    public static byte[] exportExcel(Map<String, Object> map) throws IOException {
        Workbook workbook = ExcelExportUtil.exportExcel(getTemplateExportParams(), map);
        File savefile = new File("C:\\Users\\lx\\Desktop\\");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        ByteArrayOutputStream fos = new ByteArrayOutputStream();
        workbook.write(fos);
        return fos.toByteArray();
    }
     */

    /**
     * 模板路径
     */
    public static TemplateExportParams getTemplateExportParams(String tempName) {
        return new TemplateExportParams(
                "C:\\Users\\lx\\Desktop\\沈凯的个人文件夹\\数据导入\\"+tempName+".xlsx");
    }
    public static void exportExcel(String tempName ,Map<String, Object> map,HttpServletResponse response) throws IOException {
        Workbook workbook = ExcelExportUtil.exportExcel(getTemplateExportParams(tempName), map);
        if (workbook == null) {
            LOGGER.error("create work book error, result is null");
            return;
        }
        downLoadExcel(tempName, workbook, response);
    }
    private static void downLoadExcel(String fileName, Workbook workbook, HttpServletResponse response) {
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            fileName = new String((FORMAT1.format(new Date()) + "@" + fileName + ".xlsx").getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            workbook.write(outputStream);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

}