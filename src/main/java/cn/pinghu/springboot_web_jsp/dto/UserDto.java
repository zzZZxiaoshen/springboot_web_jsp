package cn.pinghu.springboot_web_jsp.dto;

import java.util.List;

public class UserDto {
    private String username;
    private List<AuthorityDto> authorityList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<AuthorityDto> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<AuthorityDto> authorityList) {
        this.authorityList = authorityList;
    }
}
