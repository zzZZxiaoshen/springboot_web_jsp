package cn.pinghu.springboot_web_jsp;

import cn.pinghu.springboot_web_jsp.entity.ExcelPropertyIndexModel;
import cn.pinghu.springboot_web_jsp.entity.LoanInfo;
import cn.pinghu.springboot_web_jsp.listener.ExcelListener;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.apache.logging.log4j.core.util.datetime.FastDateFormat;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.apache.tomcat.util.file.ConfigFileLoader.getInputStream;

public class ExcelTestDemo {


    private static final FastDateFormat FORMAT = FastDateFormat.getInstance("yyyy-MM-dd");


    /**
     * 无java模型直接把excel解析的每行结果以List返回 在ExcelListener获取解析结果
     */
    @Test
    public void testExcel2003NoModel() throws IOException {
        InputStream inputStream = getInputStream("C:\\Users\\lx\\Desktop\\loan1.xlsx");
        try {
            // 解析每行结果在listener中处理
            ExcelListener listener = new ExcelListener();

            ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, listener);
            excelReader.read();
        } catch (Exception e) {

        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 有java模型映射
     */
    @Test
    public void testExcel2003WithReflectModel() throws IOException {
        InputStream inputStream = getInputStream("C:\\Users\\lx\\Desktop\\loan1.xlsx");
        try {
            // 解析每行结果在listener中处理
            AnalysisEventListener listener = new ExcelListener();
            ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, listener);
            excelReader.read(new Sheet(0, 0, LoanInfo.class));
        } catch (Exception e) {

        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 生成Excel 无模型毎一行都是一个listString 无无表头
     */
    @Test
    public void testCreatExcel() throws FileNotFoundException {
        OutputStream out = new FileOutputStream("C:\\Users\\lx\\Desktop\\testCreatExcel.xlsx");
        try {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, false);
            //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
            Sheet sheet1 = new Sheet(0, 0);
            sheet1.setSheetName("第一个sheet");
            writer.write0(getListString(), sheet1);
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 生成Excel @ExcelProperty(value = “姓名”,index = 0) value是表头数据，默认会写在excel的表头位置，index代表第几列
     */
    @Test
    public void test1() throws FileNotFoundException {
        createExcel();
    }

    private void createExcel() throws FileNotFoundException {
        OutputStream out = new FileOutputStream("C:\\Users\\lx\\Desktop\\testCreatExcel02.xlsx");
        try {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
            Sheet sheet1 = new Sheet(0, 0, ExcelPropertyIndexModel.class);
            writer.write(getData(), sheet1);
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<? extends BaseRowModel> getData() {
        ArrayList<ExcelPropertyIndexModel> list = new ArrayList<>();
        ExcelPropertyIndexModel model = new ExcelPropertyIndexModel();
        model.setName("xiaoshen");
        model.setAge("11");
        model.setEmail("644921@qq");
        model.setLast("aaaa");
        // 封装毎一行数据
        list.add(model);
        return list;
    }


    private List<List<String>> getListString() {
        // 整个sheet 的行数据
        ArrayList<List<String>> list = new ArrayList<>();
        ArrayList<String> listString = new ArrayList<>();
        listString.add("11");
        listString.add(FORMAT.format(new Date()));
        // 封装一行数据
        list.add(listString);
        return list;
    }

}

