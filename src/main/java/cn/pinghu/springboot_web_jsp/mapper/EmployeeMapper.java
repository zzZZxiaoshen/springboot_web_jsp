package cn.pinghu.springboot_web_jsp.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import cn.pinghu.springboot_web_jsp.entity.Employee;

@Mapper
public interface EmployeeMapper {

    @Insert("INSERT INTO `employee` (`lastName`,`email`,`gender`,`d_id`) VALUES (#{lastName},#{email},#{gender},#{dId} )")
    int insert( Employee employee);

    @Update("UPDATE   `Employee` SET  `lastName`=#{lastName} WHERE id=#{id}")
    int updateEmployee ( Employee employee);

    @Select("SELECT  * FROM `employee` WHERE id= #{id}")
    Employee selectEmployee(Integer id);

}
