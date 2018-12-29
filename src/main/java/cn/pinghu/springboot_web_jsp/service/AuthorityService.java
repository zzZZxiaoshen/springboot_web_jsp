package cn.pinghu.springboot_web_jsp.service;


import cn.pinghu.springboot_web_jsp.dto.AuthorityDto;

import java.util.List;

public interface AuthorityService{

    int insert(AuthorityDto authority);

    int insertSelective(AuthorityDto authority);

    int insertList(List<AuthorityDto> authoritys);

    int updateByPrimaryKeySelective(AuthorityDto authority);
}
