package cn.pinghu.springboot_web_jsp.domain;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}