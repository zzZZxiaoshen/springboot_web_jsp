package cn.pinghu.springboot_web_jsp.entity;

/**
 * easypoi模型类
 * @author shenkai
 * @date 2018/12/26
 */
public class EasyPOIModel {
    private int id;
    private String project;
    private String name;
    private String sex;
    private int age;



    public EasyPOIModel(int id, String project, String name, String sex,int age) {
        this.id = id;
        this.project = project;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
