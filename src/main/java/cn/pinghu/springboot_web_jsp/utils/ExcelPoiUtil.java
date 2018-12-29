package cn.pinghu.springboot_web_jsp.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelPoiUtil {


    /**
     * 设置导入参数
     */
    public ImportParams getImportParams() {
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        return params;
    }

    /**
     * 根据注解导入excel
     * @param path  文件位置
     * @param clazz 读取excel封装的java类型
     * @return 封装的excel毎一列的数据 返回一个lst集合
     */
    public <T> List<T> impoteExcel(String path, Class<T> clazz) throws Exception {
        FileInputStream fin = new FileInputStream(path);
        ImportParams params = getImportParams();
        List<T> list = ExcelImportUtil.importExcel(
                fin,
                clazz, params);
        return list;
    }

    /**
     * 模板路径
     */
    public static TemplateExportParams getTemplateExportParams() {
        return new TemplateExportParams(
                "C:\\Users\\lx\\Desktop\\沈凯的个人文件夹\\数据导入\\订单列表.xls");
    }

    /**
     * 使用模板导出excel  注意模板只能是xls后缀结尾的
     * @param map 需要导出的数据
     * @return 用户信息
     */
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

}