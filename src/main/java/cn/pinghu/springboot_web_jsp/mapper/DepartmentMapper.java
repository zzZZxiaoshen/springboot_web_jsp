package cn.pinghu.springboot_web_jsp.mapper;


import cn.pinghu.springboot_web_jsp.entity.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DepartmentMapper {

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    @Select("select * from department where id = #{id}")
    Department seelectDepartmentById(Integer id);

    /**
     * 根据id删除部门
     * @param id
     * @return
     */
    @Delete("delete from department  where id = #{id}")
    Integer deleteDepartment(Integer id);

}
