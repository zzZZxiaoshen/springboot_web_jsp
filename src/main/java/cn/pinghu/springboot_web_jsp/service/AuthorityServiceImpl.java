package cn.pinghu.springboot_web_jsp.service;

import cn.pinghu.springboot_web_jsp.domain.AuthorityDo;
import cn.pinghu.springboot_web_jsp.dto.AuthorityDto;
import cn.pinghu.springboot_web_jsp.mapper.AuthorityMapper;
import cn.pinghu.springboot_web_jsp.utils.BeanHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityMapper authorityMapper;

    /**
    * 插入权限
    */
    @Override
    public int insert(AuthorityDto authority){
        return authorityMapper.insert(BeanHelper.convertBean(authority, AuthorityDo::new));
    }

    /**
    *  根据条件插入权限
    */
    @Override
    public int insertSelective(AuthorityDto authority){
        return authorityMapper.insertSelective(BeanHelper.convertBean(authority, AuthorityDo::new));
    }

    /**
    *  插入多个权限
    */
    @Override
    public int insertList(List<AuthorityDto> authoritys){
        return authorityMapper.insertList(BeanHelper.convertBeans(authoritys, AuthorityDo::new));
    }

    /**
    * 更新权限
    */
    @Override
    public int updateByPrimaryKeySelective(AuthorityDto authority){
        return authorityMapper.updateByPrimaryKeySelective(BeanHelper.convertBean(authority, AuthorityDo::new));
    }

}
