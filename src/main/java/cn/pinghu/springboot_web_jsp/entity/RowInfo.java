package cn.pinghu.springboot_web_jsp.entity;


import com.alibaba.excel.metadata.BaseRowModel;

import java.util.Date;

public class RowInfo  extends BaseRowModel {

    int age;
    String name;
    Date date;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
