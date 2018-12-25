package cn.pinghu.springboot_web_jsp.controller;

import cn.pinghu.springboot_web_jsp.entity.Department;
import cn.pinghu.springboot_web_jsp.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HolleWorldController {

    @Autowired
    private DepartmentMapper departmentMapper;

    @RequestMapping("/hello")
    public String testMethod() {
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
    public Integer testDelete(Integer id){
        Integer integer = departmentMapper.deleteDepartment(id);
        return integer;
    }
}

