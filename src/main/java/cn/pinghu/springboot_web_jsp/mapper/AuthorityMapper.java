package cn.pinghu.springboot_web_jsp.mapper;

import cn.pinghu.springboot_web_jsp.domain.AuthorityDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthorityMapper {
    int insert(@Param("authority") AuthorityDo authority);

    int insertSelective(@Param("authority") AuthorityDo authority);

    int insertList(@Param("authoritys") List<AuthorityDo> authoritys);

    int updateByPrimaryKeySelective(@Param("authority") AuthorityDo authority);
}
