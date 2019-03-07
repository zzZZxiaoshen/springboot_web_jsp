package cn.pinghu.springboot_web_jsp.controller;

import cn.pinghu.springboot_web_jsp.entity.OrderConversionEntity;
import cn.pinghu.springboot_web_jsp.entity.response.HttpBizCode;
import cn.pinghu.springboot_web_jsp.entity.response.ResponseEntity;
import cn.pinghu.springboot_web_jsp.utils.BeanHelper;
import cn.pinghu.springboot_web_jsp.utils.ExcelConversionUtils;
import com.google.common.collect.Lists;
import com.xuxueli.poi.excel.ExcelImportUtil;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  文件上传测试类
 * @author shenkai
 * @date 2019/3/7
 */
@Controller
public class FilleUplocadController {

    /**
     *      本质是操作系统资源使用io流
     *将图片保存至本地
     *   上传文件使用springmvc提供的multipartFile组件完成文件上传
     *     得到下载流： 得到想要文件只要使用的文件流只需要file.getBytes()即可
     *                  大大的封装了fileupload组件的开发的难度
     *     得到文件名字 ：getOriginalFilename();获取文件名称。
     *                    getName(); 获取上传文件时候表单的key。一般都是与字符串截取方法配合使用
     *     获取文件路径： 一般都是自己定义下载的路径的进行拼接
     *
     *     将上传文件写到服务器上指定的文件： 使用transferTo（dest）方法
     *                      这一步就简化了我们使用io流获取输入流 定义输出流进行输出了。
     *                      注意在这一步我们一般会与其他工具一起使用以实现功能
     *                      比如poi拿到transferto输出之后的文件（file）然后使用io流获得其输入流
     *                      然后拿到输入流之后 进行其他组件的操作
     *
     *     其他api：
     *      使用getSize()方法获得文件长度，以此决定允许上传的文件大小。
     *
     *      使用isEmpty()方法判断上传文件是否为空文件，以此决定是否拒绝空文件。
     *
     *     使用getInputStream()方法将文件读取为java.io.InputStream流对象。
     *
     *      使用getContentType()方法获得文件类型，以此决定允许上传的文件类型。
     *
     *      例如，如果上传的文件不为空并且大小不小于1024字节，那么可以按照清单7-35中的代码来实现。
     *
     *      清单7-35  文件上传示例
     *
     *      def upload = {
     *
     *      def file = request.getFile('myFile')
     *
     *        if(file && !file.empty&& file.size < 1024){
     *
     *           file.transferTo( new java.io.File("/local/server/path/${file.name}" ) )
     *
     *          }
     *
     *     }
     *
     *    MultipartFile[] 组件 可以接收多个对象
     *      与原生的fileupload组件相比大大的简化了我们自生获取拿到文件对象的难度。
     */

    @RequestMapping("/file/uplocad")
    public void uplocadfile(@RequestParam("file") MultipartFile[] file) {
        System.out.println(file[0].getName());
        System.out.println(file[0].getOriginalFilename());
//        File newPath = new File("C:\\Users\\lx\\Desktop\\企业微信\\"+System.currentTimeMillis()+".jpg");
     File newPath = new File(System.currentTimeMillis()+".jpg");

        try {
            if (!newPath.exists()) {
                newPath.createNewFile();
            }
            //    IOUtils.copy(file[0].getInputStream(),new FileOutputStream(newPath));
          /*
               注意进行输出的时候需要将 文件的io流给transferTo 然后进行输出
               注意区分文件是文件  io流是io流
               在创建文件之后 建立io流通道之后才能进行 数据的写入与输出。
               在这里操作的是两个东西 一个是文件  一个是数据 这是两方面的概念
           */
            file[0].transferTo(newPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(newPath.getAbsolutePath());
        System.out.println(newPath.exists());
    }

    /**
     * 导入线路   以下是完成文件上传 之后拿到文件file对象之后， 可以对其进行io操作。
     */
 /*   @ResponseBody
    @RequestMapping(value = "/api/upload/route", method = RequestMethod.POST)
    @RequiresPermissions(value = "route:import", name = "导入线路号", desc = "导入线路号")
    public ResponseEntity uploadRoute(MultipartFile file) {
        ResponseEntity response = ResponseEntity.newInstance();
        if (file == null || file.isEmpty()) {
            return response.fill(HttpBizCode.ILLEGAL, "请上传线路数据", StringUtils.EMPTY);
        }
        String fileName = file.getOriginalFilename();
        if (StringUtils.isBlank(fileName)) {
            return response.fill(HttpBizCode.ILLEGAL, "请上传线路数据", StringUtils.EMPTY);
        }
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        final List<String> excelPrefix = Lists.newArrayList(".xls", ".xlsx");
        if (!excelPrefix.contains(prefix)) {
            return response.fill(HttpBizCode.ILLEGAL, "请上传EXCEL文件", StringUtils.EMPTY);
        }
        File tempFile = null;
        try {
            tempFile = File.createTempFile(String.valueOf(System.currentTimeMillis()), prefix);
            file.transferTo(tempFile);
            ExcelConversionUtils<OrderConversionEntity> conversionUtils = ExcelConversionUtils.getInstance();
            List<OrderConversionEntity> orderConversions = conversionUtils.conversion(tempFile, OrderConversionEntity.class);
            if (CollectionUtils.isEmpty(orderConversions)) {
                return response.fill(HttpBizCode.ILLEGAL, "文件内容不存在", StringUtils.EMPTY);
            }
            orderConversions = orderConversions.parallelStream().filter(item -> StringUtils.isNotBlank(item.getOrderNo())).collect(Collectors.toList());
            Response<Boolean> booleanResponse = orderService.batchUpdateOrderRoute(BeanHelper.convertBeans(orderConversions, OrderRouteDto::new));
            if (booleanResponse == null || !booleanResponse.getResult()) {
                return response.fill(HttpBizCode.NOTICE, "线路号未批量分配成功，请确认数据", StringUtils.EMPTY);
            }
            return response.fill(HttpBizCode.SUCCESS, HttpBizCode.SUCCESS.getMessage(), StringUtils.EMPTY);
        } catch (Exception e) {
            LOGGER.error("[uploadImage] save error. reason:[{}]", e.getMessage());
            return response.fill(HttpBizCode.SYS_ERROR, HttpBizCode.SYS_ERROR.getMessage(), StringUtils.EMPTY);
        } finally {
            if (tempFile != null && tempFile.exists() && tempFile.isFile() && tempFile.delete()) {
                LOGGER.error("upload route method delete temp file success");
            }
        }
    }*/


    /**
     * EXCEL数据转化工具
     * @author zhuhongxin
     * @date 2018/12/19
     */
  /*  @SuppressWarnings("unchecked")
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

    }*/
}
