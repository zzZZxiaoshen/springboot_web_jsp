package cn.pinghu.springboot_web_jsp.service;

import cn.pinghu.springboot_web_jsp.entity.Employee;

public interface EmployeeService {

    /**
    * 查询所有员工
    * @return 员工
    */
    Employee findEmployee(Integer id);

    /**
    * 增加员工
    * @param employee 增加员工信息
     * @return 是否成功
    */
    int addEmployee(Employee employee);


    /**
    * 更新员工
    * @param employee 更的员工的信息
    * @return 是否更新成功
    */
    Employee updateEmployee(Employee employee);

    /**
    * 删除员工
    * @param id
    * @return
    */
    void deleteEmployee(Integer id);
}
