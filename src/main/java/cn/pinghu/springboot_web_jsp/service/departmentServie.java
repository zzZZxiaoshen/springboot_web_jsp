package cn.pinghu.springboot_web_jsp.service;

import cn.pinghu.springboot_web_jsp.entity.Department;
import cn.pinghu.springboot_web_jsp.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;


@CacheConfig(cacheNames = "dept",cacheManager = "deptCacheManager")
@Service
public class departmentServie {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private RedisCacheManager deptCacheManager;


    @Cacheable(cacheNames = "dept")
    public Department findDepartment(Integer id){
        Department department = departmentMapper.seelectDepartmentById(id);
        // 编码的方式存储缓存  利用的是缓存抽象的接口 api操作。
        Cache dept = deptCacheManager.getCache("dept");
        dept.put("id", department);
        return department;
    }
}
