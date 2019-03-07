package cn.pinghu.springboot_web_jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *  文件上传测试类
 * @author shenkai
 * @date 2019/3/7
 */
@Controller
public class FilleUplocadController {

    @RequestMapping("/file/uplocad")
    public void uplocadfile(@RequestParam("file") MultipartFile[] file) {
        System.out.println(file[0].getName());
        System.out.println(file[0].getOriginalFilename());

    }
}
