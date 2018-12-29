package cn.pinghu.springboot_web_jsp.domain;

import cn.pinghu.springboot_web_jsp.entity.AuthorityEntity;

import java.util.List;

public class UserDo {

    private String username;
    private List<AuthorityDo> authorityList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public List<AuthorityDo> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<AuthorityDo> authorityList) {
        this.authorityList = authorityList;
    }

}
