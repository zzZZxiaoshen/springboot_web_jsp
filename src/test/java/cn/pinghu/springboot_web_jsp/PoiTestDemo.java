package cn.pinghu.springboot_web_jsp;


import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.handler.inter.IExcelDataHandler;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import cn.pinghu.springboot_web_jsp.entity.*;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.poi.ss.usermodel.Workbook;
import org.assertj.core.util.Lists;
import org.junit.Test;

import javax.el.ImportHandler;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class PoiTestDemo {

    /**
     * 导出excel 一个对象
     */
    @Test
    public void test01() throws Exception {
        ArrayList<StudentEntity> list = new ArrayList<>();
        StudentEntity entity = new StudentEntity();
        entity.setName("xiaoshen");
        entity.setBirthday(new Date());
        entity.setSex(1);
        list.add(entity);

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生", "学生"),
                StudentEntity.class, list);
        FileOutputStream out = new FileOutputStream("C:\\Users\\lx\\Desktop\\test.xls");
        workbook.write(out);
        out.close();
    }

    /**
     * 导出excel 一对多
     */
    @Test
    public void test02() throws IOException {
        List<CourseEntity> courseEntities = new ArrayList<>();
        // 封装老师信息
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setName("xiaoshen");
        // 封装学生信息
        ArrayList<StudentEntity> stlist = new ArrayList<>();
        StudentEntity entity = new StudentEntity();
        entity.setName("xiaoshen");
        entity.setBirthday(new Date());
        entity.setSex(1);
        stlist.add(entity);
        stlist.add(entity);

        // 封装课程信息
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setName("shuxue");
        courseEntity.setMathTeacher(teacherEntity);
        courseEntity.setStudents(stlist);
        courseEntities.add(courseEntity);

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("2412312", "测试", "测试"),
                CourseEntity.class, courseEntities);

        FileOutputStream out = new FileOutputStream("C:\\Users\\lx\\Desktop\\test.xls");
        workbook.write(out);
        out.close();
    }

    /**
     * 导出多张sheet
     */
    public void test03() {
    }


    /**
     * map导入自由发挥
     */
    @Test
    public void test04() {
        try {
            List<ExcelExportEntity> entity = new ArrayList<ExcelExportEntity>();
        //构造对象等同于@Excel
            ExcelExportEntity excelentity = new ExcelExportEntity("姓名", "name");
            excelentity.setNeedMerge(true);
            entity.add(excelentity);
            entity.add(new ExcelExportEntity("性别", "sex"));
            excelentity = new ExcelExportEntity(null, "students");
            List<ExcelExportEntity> temp = new ArrayList<ExcelExportEntity>();
            temp.add(new ExcelExportEntity("姓名", "name"));
            temp.add(new ExcelExportEntity("性别", "sex"));
        //构造List等同于@ExcelCollection
            excelentity.setList(temp);
            entity.add(excelentity);
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        //把我们构造好的bean对象放到params就可以了
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("测试", "测试"), entity,
                    list);
            FileOutputStream fos = new FileOutputStream("C:\\Users\\lx\\Desktop\\ExcelExportForMap.tt.xls");
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * excel 导入
     */
    @Test
    public void test2() throws Exception {
        FileInputStream fin = new FileInputStream("C:\\Users\\lx\\Desktop\\test.xls");
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        long start = new Date().getTime();
        List<StudentEntity> list = ExcelImportUtil.importExcel(
                fin,
                StudentEntity.class, params);
        System.out.println(new Date().getTime() - start);
        System.out.println(list.size());
        System.out.println(ReflectionToStringBuilder.toString(list.get(0)));
    }

    /**
     * 如何自定义数据处理
     */
    @Test
    public void bigDataExport() throws Exception {
        List<MsgClient> list = new ArrayList<MsgClient>();
        Workbook workbook = null;
        Date start = new Date();
        ExportParams params = new ExportParams("大数据测试", "测试");
        for (int i = 0; i < 1000; i++) {  //一百万数据量
            MsgClient client = new MsgClient();
            client.setBirthday(new Date());
            client.setClientname("小明" + i);
            client.setClientphone("18797" + i);
            client.setCreateby("JueYue");
            client.setId("1" + i);
            client.setRemark("测试" + i);
            list.add(client);
            if(list.size() == 10000){
                workbook = ExcelExportUtil.exportBigExcel(params, MsgClient.class, list);
                list.clear();
            }
        }
        ExcelExportUtil.closeExportBigExcel();
        System.out.println(new Date().getTime() - start.getTime());
        File savefile = new File("D:/excel/");
           if (!savefile.exists()) {
               savefile.mkdirs();
           }
        FileOutputStream fos = new FileOutputStream("C:\\Users\\lx\\Desktop\\ExcelExportBigData.bigDataExport.xlsx");
        workbook.write(fos);
        fos.close();
    }

    /**
    * 使用模板导出Demo
    */
    @Test
    public void fe_map() throws Exception {
        /*TemplateExportParams params = new TemplateExportParams(
                "C:\\Users\\lx\\Desktop\\沈凯的个人文件夹\\数据导入\\专项支出用款申请书_map.xls");*/
        TemplateExportParams params = new TemplateExportParams(
                "template/专项支出用款申请书_map.xls",true);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", "2014-12-25");
        map.put("money", 2000000.00);
        map.put("upperMoney", "贰佰万");
        map.put("company", "执笔潜行科技有限公司");
        map.put("bureau", "财政局");
        map.put("person", "JueYue");
        map.put("phone", "1879740****");
        List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
        for (int i = 0; i < 4; i++) {
            Map<String, String> lm = new HashMap<String, String>();
            lm.put("id", i + 1 + "");
            lm.put("zijin", i * 10000 + "");
            lm.put("bianma", "A001");
            lm.put("mingcheng", "设计");
            lm.put("xiangmumingcheng", "EasyPoi " + i + "期");
            lm.put("quancheng", "开源项目");
            lm.put("sqje", i * 10000 + "");
            lm.put("hdje", i * 10000 + "");

            listMap.add(lm);
        }
        map.put("maplist", listMap);

        exportExcel(params, map);
    }

    /**
     * 使用模板导出test(本地文件不在项目里引入文件)
     */
    @Test
    public void fe_map1() throws Exception {
        TemplateExportParams params = new TemplateExportParams(
                "C:\\Users\\lx\\Desktop\\沈凯的个人文件夹\\数据导入\\template.xlsx");
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
        for (int i = 0; i < 4; i++) {
            Map<String, String> lm = new HashMap<String, String>();
            lm.put("id", i + 1 + "");
            lm.put("project", i * 10000 + "");
            lm.put("name", "A001");
            lm.put("age", "设计");
            lm.put("sex", "EasyPoi " + i + "期");
            listMap.add(lm);
        }
        map.put("maplist", listMap);
        map.put("test", 1);

        exportExcel(params, map);
    }

    /**
     * 使用模板导出test(在项目里引入文件)
     */
    @Test
    public void fe_map2() throws Exception {
        TemplateExportParams params = new TemplateExportParams(
                "template/template.xlsx");
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
        for (int i = 0; i < 4; i++) {
            Map<String, String> lm = new HashMap<String, String>();
            lm.put("id", i + 1 + "");
            lm.put("project", i * 10000 + "");
            lm.put("name", "A001");
            lm.put("age", "设计");
            lm.put("sex", "EasyPoi " + i + "期");
            listMap.add(lm);
        }
        map.put("maplist", listMap);
        map.put("test", 2);

        exportExcel(params, map);
    }

    private void exportExcel(TemplateExportParams params, Map<String, Object> map) throws IOException {
        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
        File savefile = new File("C:\\Users\\lx\\Desktop\\");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("C:\\Users\\lx\\Desktop\\test.xls");
        workbook.write(fos);
        fos.close();
    }



}
