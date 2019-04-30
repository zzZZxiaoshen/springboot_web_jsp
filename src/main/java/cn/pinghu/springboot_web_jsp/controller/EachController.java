package cn.pinghu.springboot_web_jsp.controller;


import cn.pinghu.springboot_web_jsp.entity.Employee;
import cn.pinghu.springboot_web_jsp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
public class EachController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 查询员工
     */
    @ResponseBody
    @RequestMapping("/find/employee")
    public Employee findEmployee(Integer id) {

        return employeeService.findEmployee(id);
    }

    /**
    * 更新员工
    */
    @ResponseBody
    @RequestMapping("/update/employee")
    public Employee updateEmployee(@ModelAttribute Employee employee){
        employeeService.updateEmployee(employee);
        return employee;
    }

    /**
    * 删除员工
    */
    @ResponseBody
    @RequestMapping("/delete/employee")
    public String deleteEmployee(Integer id){
        employeeService.deleteEmployee(id);
        return "success";
    }
}
