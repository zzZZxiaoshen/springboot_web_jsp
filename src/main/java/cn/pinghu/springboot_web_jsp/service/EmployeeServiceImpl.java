package cn.pinghu.springboot_web_jsp.service;

import cn.pinghu.springboot_web_jsp.entity.Employee;
import cn.pinghu.springboot_web_jsp.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 员工服务层
 * @author shenkai
 * @date 2018/12/31
 */
@CacheConfig(cacheNames = {"emp"})//指定公共的缓存组件
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
    * 查询员工
    */
    @Cacheable(cacheNames = "emp",key = "#id")
    @Override
    public Employee findEmployee(Integer id) {
        System.out.println("查询员工11`1");
        Employee employee = employeeMapper.selectEmployee(id);
        return employee;
    }



    /**
    * 更新员工
    */
    @CachePut(cacheNames = {"emp"},key = "#employee.id")
    @Override
    public Employee updateEmployee(Employee employee) {
         employeeMapper.updateEmployee(employee);
        return employee;
    }

    /**
    * 删除员工
    */
    @CacheEvict(cacheNames = "emp",/*key = "#id"*/ allEntries = true)
    @Override
    public void deleteEmployee(Integer id) {
        System.out.println("删除员工");
    }

    /**
     * 增加员工
     */
    @Override
    public int addEmployee(Employee employee) {
        return employeeMapper.insert(employee);
    }
}
