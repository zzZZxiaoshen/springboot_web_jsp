package cn.pinghu.springboot_web_jsp.entity;

public class Student {
    String name;
    Integer age;

    public Student() {
    }

    public void  show(){
        System.out.println("show");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
