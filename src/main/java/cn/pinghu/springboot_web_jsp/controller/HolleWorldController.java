package cn.pinghu.springboot_web_jsp.controller;


import cn.pinghu.springboot_web_jsp.entity.Department;
import cn.pinghu.springboot_web_jsp.entity.OrderConversionEntity;
import cn.pinghu.springboot_web_jsp.entity.StudentEntity;
import cn.pinghu.springboot_web_jsp.entity.UserEntity;
import cn.pinghu.springboot_web_jsp.entity.response.HttpBizCode;
import cn.pinghu.springboot_web_jsp.entity.response.ResponseEntity;
import cn.pinghu.springboot_web_jsp.mapper.DepartmentMapper;
import cn.pinghu.springboot_web_jsp.service.OrderService;
import cn.pinghu.springboot_web_jsp.utils.ExcelConversionUtils;
import cn.pinghu.springboot_web_jsp.utils.ExcelPoiUtil;
import cn.pinghu.springboot_web_jsp.utils.ExcelUtils;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

/*@SessionAttributes(value={"user"}, types={String.class})
@Controller*/
public class HolleWorldController {

    private static final Logger LOGGER = LogManager.getLogger(HolleWorldController.class);
    private static final FastDateFormat FORMAT2 = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");


    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private OrderService orderService;

    @ModelAttribute
    public void getUser(@RequestParam(value="id",required=false) Integer id,
                        Map<String, Object> map){
        System.out.println("modelAttribute method");
        if(id != null){
            //模拟从数据库中获取对象
            UserEntity user = new UserEntity("Tom", "123456");
            System.out.println("从数据库中获取一个对象: " + user);
            map.put("user", user);
        }
    }


    @RequestMapping("/hello")
    public String testMethod() {
        System.out.println("jrebeltest");
        System.out.println("hello");
        return "hello";
    }

    @ResponseBody
    @RequestMapping("/mybatis")
    public Department testMybatis(Integer id) {
        Department dept = departmentMapper.seelectDepartmentById(id);
        return dept;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Integer testDelete(Integer id) {
        Integer integer = departmentMapper.deleteDepartment(id);
        return integer;
    }

    @ResponseBody
    @RequestMapping("/converter")
    public void converterTest(Date date) {
        if (date instanceof Date) {
            System.out.println(date);
            return;
        }
        System.out.println("这是一个字符串" + date);
    }

    /**
     * 导入线路自己测试
     */
    @ResponseBody
    @RequestMapping(value = "/api/upload/route", method = RequestMethod.POST)
    public ResponseEntity uploadRoute1( MultipartFile file) {
        ResponseEntity response = ResponseEntity.newInstance();
        if (file == null || file.isEmpty()) {
            return response.fill(HttpBizCode.ILLEGAL, HttpBizCode.ILLEGAL.getMessage(), null);
        }
        String filename = file.getOriginalFilename();
        if (filename == null) {
            return response.fill(HttpBizCode.ILLEGAL, "请传入文件", null);
        }
        String prifix = filename.substring(filename.lastIndexOf("."));
        ArrayList<String> excelPrifix = Lists.newArrayList(".xls", ".xlsx");
        if (!excelPrifix.contains(prifix)) {
            return response.fill(HttpBizCode.ILLEGAL, "请上传EXCEL文件", null);
        }
        File tempFile = null;
        try {
            tempFile = File.createTempFile(String.valueOf(System.currentTimeMillis()), prifix);
            file.transferTo(tempFile);
            //不知道为什么不能直接强转类型，而是需要自定义一个工具类
          /*  FileInputStream fin = new FileInputStream(tempFile);
            BufferedInputStream bis = new BufferedInputStream(fin);
            List<Object> objects = ExcelImportUtil.importExcel(bis, OrderConversionEntity.class);*/
          // 得到excel数据
            ExcelConversionUtils<OrderConversionEntity> instance = ExcelConversionUtils.getInstance();
            List<OrderConversionEntity> conversion = instance.conversion(tempFile, OrderConversionEntity.class);
            if (CollectionUtils.isEmpty(conversion)) {
                return response.fill(HttpBizCode.BIZ_ERROR, "文件内容不存在", null);
            }
            //批量更新线路
          /*  List<OrderConversionEntity> collect = conversion.parallelStream().filter(item -> StringUtils.isNotBlank(item.getOrderNo())).collect(Collectors.toList());
            Response<Integer> integerResponse=orderService.bathUpDateRoute(collect);
            if (integerResponse.getResult() != null) {
                return response.fill(HttpBizCode.BIZ_ERROR, "更新失败", null);
            }*/
            return response.fill(HttpBizCode.SUCCESS, HttpBizCode.SUCCESS.getMessage(), StringUtils.EMPTY);
        } catch (IOException e) {
            LOGGER.error("[uploadImage] save error. reason:[{}]", e.getMessage());
            return response.fill(HttpBizCode.SYS_ERROR, HttpBizCode.SYS_ERROR.getMessage(), StringUtils.EMPTY);
        } finally {
            if (tempFile != null && tempFile.exists() && tempFile.isFile() && tempFile.delete()) {
                LOGGER.error("upload route method delete temp file success");
            }
        }

    }

    @RequestMapping("/excel/import")
    public void excelImport(MultipartFile file, HttpServletResponse response){
        List<StudentEntity> studentEntities =  ExcelPoiUtil.importExcel(file, 1, 0, StudentEntity.class);

        HashMap<String, Object> map = new HashMap<>();
        map.put("rows", studentEntities);
        map.put("exportTime", FORMAT2.format(new Date()));
        try {
            ExcelPoiUtil.exportExcel("客户列表",map,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


